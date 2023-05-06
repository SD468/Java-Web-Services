package com.cts.rs.ws;

import java.util.List;

import com.cts.rs.ws.dao.BillingDao;
import com.cts.rs.ws.dao.BillingDaoImpl;
import com.cts.rs.ws.dto.Consumer;
import com.cts.rs.ws.exception.BillNotFoundException;
import com.cts.rs.ws.exception.InvalidDetailsException;

import jakarta.ws.rs.core.Response;

public class BillingImpl implements Billing {
	
	private BillingDao dao = new BillingDaoImpl();

	@Override
	public Consumer create(Consumer consumer) {
		if(!consumer.getConsumerId().matches("[1-9][0-9]{8}")) {
			throw new InvalidDetailsException("Invalid Details!!Consumer id must be 9 digit number");
		}
		if(!consumer.getConsumerName().matches("[a-zA-Z ]+")) {
			throw new InvalidDetailsException("Invalid Details!!Consumer name should be only alphabetical");
		}
		if(!consumer.getqName().matches("[Q][1-4]{1}")) {
			throw new InvalidDetailsException("Invalid Details!! Quaters are Q1,Q2,Q3,Q4");
		}
		Consumer c = null; 
		try {
			c=dao.create(consumer);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public List<Consumer> findAll() {
		return dao.findAll();
	}

	@Override
	public Response findById(int id) {
		Consumer consumer = dao.findById(id);
		if (consumer == null) {
			throw new BillNotFoundException("Consumer not found with " + id);
		}
		return Response.ok(consumer).build();
	}

	@Override
	public Response deleteById(int id) {
		Consumer consumer = dao.deleteById(id);
		if (consumer == null) {
			throw new BillNotFoundException("Consumer not deleted with " + id);
		}
		return Response.ok(consumer).build();
	}

	@Override
	public Response update(Consumer consumer) {
		if(!consumer.getConsumerId().matches("[1-9][0-9]{8}")) {
			throw new InvalidDetailsException("Invalid Details!!Consumer id must be 9 digit number");
		}
		if(!consumer.getConsumerName().matches("[a-zA-Z ]+")) {
			throw new InvalidDetailsException("Invalid Details!!Consumer name should be only alphabetical");
		}
		if(!consumer.getqName().matches("[Q][1-4]{1}")) {
			throw new InvalidDetailsException("Invalid Details!! Quaters are Q1,Q2,Q3,Q4");
		}
		Consumer consumer1 = dao.update(consumer);
		if(consumer1==null) {
			throw new BillNotFoundException("Consumer not updated with "+ consumer.getBiilId());
		}
		return Response.ok(consumer1).build();
	}

	@Override
	public Response calculateBill(int id) {
		
		double cost=dao.calculateCost(id);
		if(cost==0) {
			throw new BillNotFoundException("Consumer not updated with "+ id);
		}
		return Response.ok(cost).build();
	}

}
