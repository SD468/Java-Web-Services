package com.cts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.rest.exception.MarksheetNotFoundException;
import com.cts.service.MarksDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MarksheetController.class)
public class MarksheetControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MarksDetailsService markDetailsService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testFindAll() throws Exception {

		List<Marksheet> marksheet = List.of(new Marksheet(1, "Sayan De", 80, 80, 80, 80, 80,400,80.0,"E"));

		when(markDetailsService.findAll()).thenReturn(marksheet);

		this.mockMvc.perform(get("/marksheets/ms-lists").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(marksheet.size())).andDo(print());

		verify(markDetailsService, times(1)).findAll();
	}

	@Test
	void testCreate() throws Exception {
		MarksDetails input = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);

		MarksDetails output = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);

		when(markDetailsService.create(input)).thenReturn(output);

		this.mockMvc
				.perform(post("/marksheets/add").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))
				.andExpect(status().isCreated()).andDo(print());
	}

	@Test
	void testFindByRollNo_Valid() throws Exception {
		int input=1;

		Marksheet output =new Marksheet(1, "Sayan De", 80, 80, 80, 80, 80,400,80.0,"E");

		when(markDetailsService.findByRollNo(1)).thenReturn(output);

		this.mockMvc.perform(get("/marksheets/search/{rollNo}", input).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.rollNo").value(output.getRollNo()))
				.andExpect(jsonPath("$.studentName").value(output.getStudentName()))
				.andExpect(jsonPath("$.firstLang").value(output.getFirstLang()))
				.andExpect(jsonPath("$.secondLang").value(output.getSecondLang()))
				.andExpect(jsonPath("$.math").value(output.getMath()))
				.andExpect(jsonPath("$.phys").value(output.getPhys()))
				.andExpect(jsonPath("$.chem").value(output.getChem()))
				.andExpect(jsonPath("$.totalMarks").value(output.getTotalMarks()))
				.andExpect(jsonPath("$.percentage").value(output.getPercentage()))
				.andExpect(jsonPath("$.grade").value(output.getGrade()))
				.andDo(print());

		verify(markDetailsService, times(1)).findByRollNo(1);
	}
	
	@Test
	void testFindByRollNo_WithInvalidRollNo() throws Exception {
		int input=1;
		when(markDetailsService.findByRollNo(input)).thenThrow(MarksheetNotFoundException.class);
		this.mockMvc.perform(get("/marksheets/search/{rollNo}", input).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andDo(print());
		
		verify(markDetailsService, times(1)).findByRollNo(1);
	}

	@Test
	void testDelete() throws Exception {
		int id = 1;
		// markDetailsService.deleteByRollNo(id);

		this.mockMvc.perform(delete("/marksheets/delete/{rollNo}", id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());

		verify(markDetailsService, times(1)).deleteByRollNo(id);
	}

	@Test
	void testUpdate() throws Exception, MarksheetNotFoundException {

		Marksheet input = new Marksheet(1, "Sayan De", 80, 80, 80, 80, 80,400,80.0,"E");;

		MarksDetails output = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 81);
		Mockito.when(markDetailsService.findByRollNo(1)).thenReturn(input);
		input.setChem(81);
		when(markDetailsService.update(output)).thenReturn(output);

		this.mockMvc
				.perform(put("/marksheets").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(output)))
				.andExpect(status().isOk()).andDo(print());
	}
	
}
