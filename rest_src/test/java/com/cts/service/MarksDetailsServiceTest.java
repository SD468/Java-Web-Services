package com.cts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContextException;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.cts.dao.MarksDetailsDao;
import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.rest.exception.MarksheetNotFoundException;
import com.cts.service.MarksDetailsService;

@WebMvcTest(MarksDetailsService.class)
public class MarksDetailsServiceTest {

	MarksDetails markDetails1; 
	MarksDetails markDetails2;
	Marksheet marksheet1; 

	@Autowired
	private MarksDetailsService markDetailsService;
	
	@Autowired
	@MockBean
	private MarksDetailsDao markDetailsDao;
	
	/*
	 * test crete method
	 */
	@Test
	// @Ignore
	public void testCreateMarksDetails() {

		markDetails1 = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);
		Mockito.when(markDetailsDao.create(markDetails1)).thenReturn(markDetails1);

		assertThat(markDetailsService.create(markDetails1)).isEqualTo(markDetails1);

	}
	
	/*
	 * test find by roll no method
	 */
	@Test
	public void testGetMarksDetailsById() throws MarksheetNotFoundException {
		marksheet1=new Marksheet(1, "Sayan De", 80, 80, 80, 80, 80,400,80.0,"E");
		markDetails1 = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);
		Mockito.when(markDetailsDao.findByRollNo(1)).thenReturn(markDetails1);
		assertEquals(markDetailsService.findByRollNo(1).toString(),marksheet1.toString());
	}
	
	/*
	 * test find all method
	 */
	@Test
	public void testGetAllBookedMarksDetailss() {

		List<MarksDetails> markDetails1List = List.of(new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80),
				new MarksDetails(2, "Sayan De", 80, 80, 80, 80, 90));
		List<Marksheet> marksheet = List.of(new Marksheet(1, "Sayan De", 80, 80, 80, 80, 80,400,80.0,"E"),
				new Marksheet(2, "Sayan De", 80, 80, 80, 80, 90,410,82.0,"E"));
		Mockito.when(markDetailsDao.findAll()).thenReturn(markDetails1List);

		assertThat(markDetailsService.findAll().toString()).isEqualTo(marksheet.toString());
	}
	/*
	 * test delete method
	 */
	@Test
	public void testDeleteMarksDetails() throws MarksheetNotFoundException {

		markDetails1 = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);
		Mockito.when(markDetailsDao.deleteByRollNo(1)).thenReturn(1);
		markDetailsService.deleteByRollNo(markDetails1.getRollNo()); //
		// markDetailsDao.findByRollNo(markDetails1.getRollNo());
		Mockito.verify(markDetailsDao, times(1)).deleteByRollNo(1);
	}
	/*
	 * test update method
	 */
	@Test
	public void testUpdateMarksDetails() throws MarksheetNotFoundException {

		markDetails1 = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);
		Mockito.when(markDetailsDao.findByRollNo(1)).thenReturn(markDetails1);

		markDetails1.setChem(81);

		MarksDetails markDetails3 = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 81);

		Mockito.when(markDetailsDao.update(markDetails1)).thenReturn(markDetails3);

		assertThat(markDetailsService.update(markDetails1)).isEqualTo(markDetails3);

	}

}
