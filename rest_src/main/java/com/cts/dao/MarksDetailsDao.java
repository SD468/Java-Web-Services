package com.cts.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cts.dto.MarksDetails;
import com.cts.dto.Merit;
@Component
public interface MarksDetailsDao {

	MarksDetails create(MarksDetails marksheet);

	MarksDetails update(MarksDetails marksheet);

	List<MarksDetails> findAll();

	MarksDetails findByRollNo(int id);

	int deleteByRollNo(int id);
	
	List<Merit> getMeritList();
}
