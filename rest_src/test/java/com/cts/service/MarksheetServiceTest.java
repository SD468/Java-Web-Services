package com.cts.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.dto.MarksDetails;

@WebMvcTest(MarksheetService.class)
class MarksheetServiceTest {
	
	private MarksheetService marksheetService=new MarksheetServiceImpl();
	
		MarksDetails details1 = new MarksDetails(1,"ABC",84,89,97,87,81);
		MarksDetails details2 = new MarksDetails(1,"ABC",70,70,70,70,70);
		MarksDetails details3 = new MarksDetails(1,"ABC",60,60,60,60,60);
		MarksDetails details4 = new MarksDetails(1,"ABC",90,90,90,90,90);
		MarksDetails details5 = new MarksDetails(1,"ABC",0,0,0,80,80);
	
	

	@Test
	void testFindTotalMarks() {
		 assertEquals(438, marksheetService.findTotalMarks(details1));
		 assertEquals(350, marksheetService.findTotalMarks(details2));
		 assertEquals(300, marksheetService.findTotalMarks(details3));
		 assertEquals(450, marksheetService.findTotalMarks(details4));
		 assertEquals(160, marksheetService.findTotalMarks(details5));
	}
	@Test
	void testFindPercentage() {
		 assertEquals(87.6, marksheetService.findPercentage(details1));
		 assertEquals(70.0, marksheetService.findPercentage(details2));
		 assertEquals(60.0, marksheetService.findPercentage(details3));
		 assertEquals(90.0, marksheetService.findPercentage(details4));
		 assertEquals(32.0, marksheetService.findPercentage(details5));
	}
	@Test
	void testFindGrade() {
		 assertEquals("E", marksheetService.findGrade(details1));
		 assertEquals("A", marksheetService.findGrade(details2));
		 assertEquals("B", marksheetService.findGrade(details3));
		 assertEquals("O", marksheetService.findGrade(details4));
		 assertEquals("Fail", marksheetService.findGrade(details5));
	}

}
