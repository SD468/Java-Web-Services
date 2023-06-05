package com.cts.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.dto.Merit;

import jakarta.validation.Valid;

@FeignClient(name="marksheet-service",url="http://localhost:8080/marksheets")
public interface MarksheetClient {
	@PostMapping("/add")
	public ResponseEntity<MarksDetails> create(@Valid @RequestBody MarksDetails marksheet);
	
	@GetMapping("/ms-lists")
	List<Marksheet> findAll();
	
	@GetMapping("/search/{rollNo}")
	public ResponseEntity<Marksheet> findByRollNo(@PathVariable("rollNo") int rollNo);
	
	
	@DeleteMapping("/delete/{rollNo}")
	public ResponseEntity<String> deletByRollNo(@PathVariable("rollNo") int rollNo);
	
	
	@PutMapping
	public ResponseEntity<MarksDetails> update(@RequestBody MarksDetails marksheet);
	
	@GetMapping("/getMeritList")
	public ResponseEntity<List<Merit>> getMeritList();
}
