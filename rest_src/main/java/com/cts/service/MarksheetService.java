package com.cts.service;

import org.springframework.stereotype.Service;

import com.cts.dto.MarksDetails;
@Service
public interface MarksheetService {
	int findTotalMarks(MarksDetails details);
	double findPercentage(MarksDetails details);
	String findGrade(MarksDetails details);
	
}
