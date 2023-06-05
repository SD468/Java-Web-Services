package com.cts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.dto.MarksDetails;
import com.cts.dto.Merit;

@Repository
public class MarksDetailsDaoImpl implements MarksDetailsDao {
	private static final String SQL_INSERT = "insert into MarksDetails(studentName, firstLang, secondLang, math, phys, chem) values(?,?,?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE MarksDetails SET studentName=?, firstLang=?, secondLang=?, math=?, phys=?, chem=? WHERE rollNo=?;";
	private static final String SQL_SELECT_ALL = "select * from MarksDetails;";
	private static final String SQL_SELECT_BY_ID = "select * from MarksDetails where rollNo=?;";
	private static final String SQL_DELETE_BY_ID = "delete from MarksDetails where rollNo=?;";
	private static final String SQL_MERIT_LIST = "select rank() OVER (order by totalMarks desc ) AS `rank`,rollNo,studentName,totalMarks from (\r\n"
			+ "SELECT rollNo, studentName, (firstLang + secondLang + math + phys + chem) AS totalMarks\r\n"
			+ "FROM MarksDetails\r\n"
			+ "WHERE firstLang > 25 AND secondLang > 25 AND math > 25 AND phys > 25 AND chem > 25\r\n"
			+ "ORDER BY totalmarks DESC\r\n"
			+ "LIMIT 10) as a\r\n"
			+ "ORDER BY `rank`,studentName;";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public MarksDetailsDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public MarksDetails create(MarksDetails marksheet) {
		int res = jdbcTemplate.update(SQL_INSERT, marksheet.getStudentName(), marksheet.getFirstLang(),marksheet.getSecondLang(),
				marksheet.getMath(),marksheet.getPhys(),marksheet.getChem());
		if(res>0) {
			return marksheet;
		}
		return null;
	}

	@Override
	public MarksDetails update(MarksDetails marksheet) {
		
		int res = jdbcTemplate.update(SQL_UPDATE, marksheet.getStudentName(), marksheet.getFirstLang(),marksheet.getSecondLang(),
				marksheet.getMath(),marksheet.getPhys(),marksheet.getChem(),marksheet.getRollNo());
		if(res>0) {
			return marksheet;
		}
		return null;
	}

	@Override
	public List<MarksDetails> findAll() {
		return jdbcTemplate.query(SQL_SELECT_ALL,
				(rs, rc) -> new MarksDetails(rs.getInt("rollNo"), rs.getString("studentName"), rs.getInt("firstLang"),
						rs.getInt("secondLang"),rs.getInt("math"),rs.getInt("phys"),rs.getInt("chem")));
	}

	@Override
	public MarksDetails findByRollNo(int rollNo) throws EmptyResultDataAccessException{
		return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, 
				(rs, rc) -> new MarksDetails(rs.getInt("rollNo"), rs.getString("studentName"), rs.getInt("firstLang"),
						rs.getInt("secondLang"),rs.getInt("math"),rs.getInt("phys"),rs.getInt("chem")),
				rollNo);
	}

	@Override
	public int deleteByRollNo(int rollNo) {
		return jdbcTemplate.update(SQL_DELETE_BY_ID, rollNo);
	}

	@Override
	public List<Merit> getMeritList() {
		
		return jdbcTemplate.query(SQL_MERIT_LIST,
				(rs, rc) -> new Merit(rs.getInt("rank"),rs.getInt("rollNo"), rs.getString("studentName"),rs.getInt("totalMarks")));
	}

}
