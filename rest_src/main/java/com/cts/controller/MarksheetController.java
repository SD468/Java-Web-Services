package com.cts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.dto.Merit;
import com.cts.rest.exception.MarksheetNotFoundException;
import com.cts.service.MarksDetailsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/marksheets")
public class MarksheetController {
	
	private final Logger logger =LoggerFactory.getLogger(MarksheetController.class);
	@Autowired
	private MarksDetailsService msService;
	
	/**
	 * add a new maeksheet details
	 * @param markDetails
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<MarksDetails> create(@Valid @RequestBody MarksDetails markDetails) {
		logger.info("Start"); logger.debug("Mark details", markDetails);
		  logger.info("End");
		 
		return new ResponseEntity<>(msService.create(markDetails), HttpStatus.CREATED);
	}
	/**
	 * returns all the markDetails information 
	 * @return
	 */
	@GetMapping("/ms-lists")
	public ResponseEntity<List<Marksheet>> findAll() {
		return  new ResponseEntity<>(msService.findAll(),HttpStatus.OK);
	}
	/**
	 * return a markDetails based on roll no
	 * @param rollNo
	 * @return
	 * @throws MarksheetNotFoundException
	 */
	@GetMapping("/search/{rollNo}")
	public ResponseEntity<Marksheet> findByRollNo(@PathVariable("rollNo") int rollNo) 
			throws MarksheetNotFoundException{
		logger.info("Start"); 
		logger.debug("Roll no to find:"+ rollNo);
		 logger.info("End");
		 
		return  new ResponseEntity<>(msService.findByRollNo(rollNo), HttpStatus.OK);
	}
	
	/**
	 * delete resources based on roll no
	 * @param rollNo
	 * @return
	 */
	@DeleteMapping("/delete/{rollNo}")
	public ResponseEntity<String> deletByRollNo(@PathVariable("rollNo") int rollNo) throws MarksheetNotFoundException{
		logger.info("Start");
		logger.debug("Roll no for delete:" + rollNo);
		
		msService.deleteByRollNo(rollNo);
		logger.info("End");
		return new ResponseEntity<>("Resource Deleted Sucessfully", HttpStatus.OK);
	}
	
	/**
	 * update resources 
	 * @param employee
	 * @return
	 * @throws MarksheetNotFoundException 
	 */
	@PutMapping
	public ResponseEntity<MarksDetails> update(@RequestBody MarksDetails markDetails) throws MarksheetNotFoundException {
		logger.info("Start");
		logger.debug("Mark details"+ markDetails);
		MarksDetails update = msService.update(markDetails);
		logger.info("End");
		return new ResponseEntity<>(update,HttpStatus.OK);
	}
	@GetMapping("/getMeritList")
	public ResponseEntity<List<Merit>> getMeritList() {
		return  new ResponseEntity<>(msService.getMeritList(),HttpStatus.OK);
	}
	
}
