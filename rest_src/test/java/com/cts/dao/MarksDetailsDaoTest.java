package com.cts.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.util.CanIgnoreReturnValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.controller.MarksheetController;
import com.cts.dto.MarksDetails;


class MarksDetailsDaoTest {
	private final Logger logger =LoggerFactory.getLogger(MarksDetailsDaoTest.class);
	@InjectMocks
    private MarksDetailsDaoImpl dao; // DAO class

   
    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByRollNo() {
        // Mocking the JdbcTemplate queryForObject() method
    	MarksDetails details = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class),Mockito.eq(details.getRollNo())))
                .thenReturn(details);

        // Calling the method in the DAO
        MarksDetails result = dao.findByRollNo(1);
        logger.debug("Returned value " + result);
        // Verifying the method was called with the correct arguments
        verify(jdbcTemplate).queryForObject(anyString(), any(RowMapper.class), Mockito.eq(details.getRollNo()));

        // Assertions
        assertNotNull(result);
        assertEquals(1, result.getRollNo());
        assertEquals("Sayan De", result.getStudentName());
    }

    @Test
   
    public void testCreate_Success() {
        MarksDetails entityToSave = new MarksDetails("Sayan De", 80, 80, 80, 80, 80);
        dao.create(entityToSave);
       
        // Verifying the JdbcTemplate update() method was called with the correct arguments
        verify(jdbcTemplate).update(anyString(),any(), any(), any(), any(), any(), any());
        

    }

    @Test
    public void testUpdate() {
        MarksDetails existingEntity = new MarksDetails(1, "Sayan De", 80, 80, 80, 80, 80);
        
        dao.update(existingEntity);
        
        // Verifying the JdbcTemplate update() method was called with the correct arguments
        verify(jdbcTemplate).update(anyString(),any(), any(), any(), any(), any(), any(),any());
    }

    @Test
    public void testDelete() {
        // Calling the method in the DAO
        dao.deleteByRollNo(1);

        // Verifying the JdbcTemplate update() method was called with the correct arguments
        verify(jdbcTemplate).update(anyString(),eq(1));
    }

}
