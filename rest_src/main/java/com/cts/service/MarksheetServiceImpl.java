package com.cts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.dto.MarksDetails;

public class MarksheetServiceImpl implements MarksheetService {

	
	private final Logger logger =LoggerFactory.getLogger(MarksheetServiceImpl.class);
	@Override
	public int findTotalMarks(MarksDetails details) {
		logger.info("Start");
		logger.debug("Mark details"+details);
		logger.info("End");
		return details.getFirstLang()+details.getSecondLang()+details.getMath()+details.getPhys()+details.getChem();
	}

	@Override
	public double findPercentage(MarksDetails details) {
		logger.info("Start");
		logger.debug("Mark details"+ details);
		logger.info("End");
		return ((double) findTotalMarks(details)/5);
	}

	@Override
	public String findGrade(MarksDetails details) {
		logger.info("Start");
		logger.debug("Mark details"+ details);
		if(details.getFirstLang()<30 || details.getSecondLang()<30 || 
				details.getMath()<30 || details.getPhys()<30 || details.getChem()<30) {
			return "Fail";
		}
		if(findPercentage(details)<=100 && findPercentage(details)>=90) {
			return "O";
		}else if(findPercentage(details)<=89 && findPercentage(details)>=80) {
			return "E";
		}else if(findPercentage(details)<=79 && findPercentage(details)>=70) {
			return "A";
		}else if(findPercentage(details)<=69 && findPercentage(details)>=60) {
			return "B";
		}else if(findPercentage(details)<=59 && findPercentage(details)>=50) {
			return "C";
		}else if(findPercentage(details)<=49 && findPercentage(details)>=30) {
			return "D";
		}
		logger.info("End");
		return null;
	}

}
