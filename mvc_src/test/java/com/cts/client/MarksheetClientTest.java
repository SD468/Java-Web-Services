package com.cts.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;

@WebMvcTest(MarksheetClient.class)
class MarksheetClientTest {

	@Mock
	private MarksheetClient myFeignClient;

	@Test
	public void testCreateEntity_Success() {
		// Mock the Feign client response
		MarksDetails createdEntity = new MarksDetails(1, "ABC", 80, 80, 80, 80, 80);
		ResponseEntity<MarksDetails> response = new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
		when(myFeignClient.create(createdEntity)).thenReturn(response);

		// Make the Feign client call
		ResponseEntity<MarksDetails> returnedEntity = myFeignClient.create(createdEntity);

		// Verify the result
		assertEquals(HttpStatus.CREATED, returnedEntity.getStatusCode());
		assertEquals(createdEntity, returnedEntity.getBody());
	}

	@Test
	public void testGetEntity_Success() { // Mock the Feign client response
		int rollNo = 1;
		Marksheet expectedEntity = new Marksheet(1, "Sayan De", 80, 80, 80, 80, 80,400,80.0,"E");;
		ResponseEntity<Marksheet> responseEntity = new ResponseEntity<>(expectedEntity, HttpStatus.OK);
		when(myFeignClient.findByRollNo(rollNo)).thenReturn(responseEntity);

		// Make the Feign client call
		ResponseEntity<Marksheet> actualEntity = myFeignClient.findByRollNo(rollNo);

		// Verify the result
		assertEquals(HttpStatus.OK, actualEntity.getStatusCode());
		assertEquals(expectedEntity, actualEntity.getBody());
	}

	@Test
	public void testUpdateEntity_Success() {
		// Mock the Feign client response
		int entityId = 1;
		MarksDetails updatedEntity = new MarksDetails(1, "ABC", 80, 80, 80, 80, 80);
		ResponseEntity<MarksDetails> responseEntity = new ResponseEntity<>(updatedEntity, HttpStatus.OK);
		when(myFeignClient.update(updatedEntity)).thenReturn(responseEntity);

		// Make the Feign client call
		ResponseEntity<MarksDetails> returnedEntity = myFeignClient.update(updatedEntity);

		// Verify the result
		assertEquals(HttpStatus.OK, returnedEntity.getStatusCode());
		assertEquals(updatedEntity, returnedEntity.getBody());
	}

	@Test
	public void testDeleteEntity_Success() {
		// Mock the Feign client response
		int entityId = 1;

		ResponseEntity<String> responseEntity = new ResponseEntity<>("Resource Deleted Sucessfully", HttpStatus.OK);

		when(myFeignClient.deletByRollNo(entityId)).thenReturn(responseEntity);

		// Make the Feign client call
		ResponseEntity<String> response = myFeignClient.deletByRollNo(entityId);

		// Verify the result
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
