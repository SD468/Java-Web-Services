package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cts.controller.MarksheetController;
import com.cts.dao.MarksDetailsDao;
import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.dto.Merit;
import com.cts.rest.exception.MarksheetNotFoundException;

//@Component
@Service
public class MarksDetailsServiceImpl implements MarksDetailsService {
	
	private final Logger logger =LoggerFactory.getLogger(MarksDetailsServiceImpl.class);
	@Autowired
	private MarksDetailsDao dao;

	private MarksheetService marksheetService=new MarksheetServiceImpl();
	@Override
	public MarksDetails create(MarksDetails marksheet) {
		logger.info("Start");
		logger.debug("Received details:" + marksheet);
		MarksDetails details = dao.create(marksheet);
		logger.debug("Created details:" + details);
		logger.info("End");
		return details;
	}

	@Override
	public MarksDetails update(MarksDetails marksheet) throws MarksheetNotFoundException {
		logger.info("Start");
		logger.debug("Received details:" + marksheet);
		logger.info("End");
		 MarksDetails update = dao.update(marksheet);
		 if(update==null) {
				throw new MarksheetNotFoundException("Marks details Not found with id: " + marksheet.getRollNo());
			}
		 return update;
	}

	@Override
	public List<Marksheet> findAll() {
		logger.info("Start");
		List<MarksDetails> findAll = dao.findAll();
		logger.debug("Received details list:" +findAll);
		List<Marksheet> list = new ArrayList<Marksheet>();
		for(MarksDetails entity:findAll) {
			Marksheet marksheet = new Marksheet(marksheetService.findPercentage(entity),marksheetService.findTotalMarks(entity), marksheetService.findGrade(entity),
					entity.getRollNo(), entity.getStudentName(), entity.getFirstLang(), entity.getSecondLang(),
					entity.getMath(), entity.getPhys(), entity.getChem());
			list.add(marksheet);
			
		}
		logger.debug("All details list:" +list);
		logger.info("End");
		return list;
	}

	@Override
	public Marksheet findByRollNo(int id) throws MarksheetNotFoundException  {
		try {
			logger.info("Start");
			logger.debug("Received roll no:" , id);
			
			 MarksDetails entity = dao.findByRollNo(id);
			 logger.debug("Found details:" + entity);
			 Marksheet marksheet = new Marksheet(marksheetService.findPercentage(entity), marksheetService.findTotalMarks(entity), marksheetService.findGrade(entity),
						entity.getRollNo(), entity.getStudentName(), entity.getFirstLang(), entity.getSecondLang(),
						entity.getMath(), entity.getPhys(), entity.getChem());
			 
			 logger.info("End");
			 return marksheet;
		} catch (EmptyResultDataAccessException e) {
			throw new MarksheetNotFoundException("Marks details Not found with id: " + id,e);
		}
	}

	@Override
	public void deleteByRollNo(int id) throws MarksheetNotFoundException{
		logger.info("Start");
		int res=dao.deleteByRollNo(id);
		if(res<=0) {
			throw new MarksheetNotFoundException("Marks details Not found with id: " + id);
		}
		logger.info("End");
	}

	@Override
	public List<Merit> getMeritList() {
		logger.info("Start");
		List<Merit> meritList = dao.getMeritList();
		logger.debug("Received details list:" +meritList);
		
		
		return meritList;
	}

}
