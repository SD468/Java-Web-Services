package com.cts.rs.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.rs.ws.dbutil.DbConnection;
import com.cts.rs.ws.dto.Consumer;

import jakarta.ws.rs.core.Response;

public class BillingDaoImpl implements BillingDao {

	private final static String SQL_INSERT_CONSUMER = "insert into consumer_billing(consumerId,consumerName,qName,consumedUnit) values(?,?,?,?)";
	private final static String SQL_UPDATE_CONSUMER = "update consumer_billing set consumerId=?,consumerName=?,qName=?,consumedUnit=? where billId=?";
	private final static String SQL_FIND_CONSUMER_BY_ID = "select * from consumer_billing where billId=?";
	private final static String SQL_FIND_ALL_CONSUMER = "select * from consumer_billing";
	private final static String SQL_DELETE_CONSUMER_BY_ID = "DELETE FROM consumer_billing WHERE billId = ?";
	private final static String SQL_COST_BY_ID = "select \r\n"
			+ "case \r\n"
			+ "when consumedUnit <=100\r\n"
			+ "then consumedUnit*5\r\n"
			+ "when consumedUnit <=200\r\n"
			+ "then 100*5+(consumedUnit-100)*6\r\n"
			+ "when consumedUnit <=300\r\n"
			+ "then 100*5+100*6+(consumedUnit-200)*7\r\n"
			+ "else 100*5+100*6+100*7 +(consumedUnit-300)*8\r\n"
			+ "end as cost\r\n"
			+ "from consumer_billing where billId=?;";

	private static Connection connection = DbConnection.getConnection();

	@Override
	public Consumer create(Consumer consumer) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SQL_INSERT_CONSUMER);
			/* ps.setInt(1, consumer.getId()); */
			ps.setString(1, consumer.getConsumerId());
			ps.setString(2, consumer.getConsumerName());
			ps.setString(3, consumer.getqName());
			ps.setInt(4, consumer.getConsumedUnit());
			System.out.println("Insert Query: " + ps);
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0) {
				return consumer;
			}
		} catch (SQLException e) {
			System.err.println("Inser Error: " + e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Consumer> findAll() {
		List<Consumer> consumers = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SQL_FIND_ALL_CONSUMER);
			rs = ps.executeQuery();
			while (rs.next()) {
				Consumer consumer = new Consumer(rs.getInt("billId"), rs.getString("consumerId"),
						rs.getString("consumerName"),rs.getString("qName"),rs.getInt("consumedUnit"));
				consumers.add(consumer);
			}
		} catch (SQLException e) {
			consumers = null;
			System.err.println("Find All Error: " + e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return consumers;
	}

	@Override
	public  Consumer findById(int id) {
		Consumer consumer = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SQL_FIND_CONSUMER_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				consumer = new Consumer(rs.getInt("billId"), rs.getString("consumerId"),
						rs.getString("consumerName"),rs.getString("qName"),rs.getInt("consumedUnit"));

			}
		} catch (SQLException e) {

			System.err.println("Find BY Id Error: " + e);
		} finally {
			try {
				// rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return consumer;
	}

	@Override
	public Consumer deleteById(int id) {
		Consumer consumer = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SQL_FIND_CONSUMER_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				consumer = new Consumer();

			}
			ps = connection.prepareStatement(SQL_DELETE_CONSUMER_BY_ID);
			ps.setInt(1, id);
			
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0) {
				return consumer;
			}
		} catch (SQLException e) {
			System.out.println("Delete Error : "+e);
		}
		return consumer;
	}

	@Override
	public Consumer update(Consumer consumer) {
		 PreparedStatement ps = null;
		    try {
		        ps = connection.prepareStatement(SQL_UPDATE_CONSUMER);
		        ps.setString(1, consumer.getConsumerId());
				ps.setString(2, consumer.getConsumerName());
				ps.setString(3, consumer.getqName());
				ps.setInt(4, consumer.getConsumedUnit());
				ps.setInt(5, consumer.getBiilId());
		        int executeUpdate = ps.executeUpdate();
		        if (executeUpdate > 0) {
		            return consumer;
		        }
		    } catch (SQLException e) {
		        System.err.println("Update Error: " + e);
		    } finally {
		        try {
		        	
		            ps.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return null;
		}

	@Override
	public int calculateCost(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int amt=0;
		try {
			ps = connection.prepareStatement(SQL_COST_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				amt = rs.getInt("cost");

			}
		} catch (SQLException e) {

			System.err.println("Cost BY Id Error: " + e);
		} finally {
			try {
				// rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return amt;
	}
		
}
