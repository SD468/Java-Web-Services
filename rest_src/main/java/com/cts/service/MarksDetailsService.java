package com.cts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.dto.Merit;
import com.cts.rest.exception.MarksheetNotFoundException;
@Service
public interface MarksDetailsService {

	MarksDetails create(MarksDetails marksheet);

	MarksDetails update(MarksDetails marksheet) throws MarksheetNotFoundException;

	List<Marksheet> findAll();

	Marksheet findByRollNo(int id) throws MarksheetNotFoundException;

	void deleteByRollNo(int id) throws MarksheetNotFoundException;
	
	List<Merit> getMeritList();
}
