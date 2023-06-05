package com.cts.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandeller extends ResponseEntityExceptionHandler {

	private Log logger = LogFactory.getLog(GlobalExceptionHandeller.class);

	@ExceptionHandler(value = UserNotFoundException.class)
	public String handleUserNotFoundException(Model model, HttpServletRequest request, UserNotFoundException ex) {
		logger.error("Request " + request.getRequestURL() + " Threw an Exception", ex);
		model.addAttribute("login", new User());
		model.addAttribute("error", ex.getMessage());
		return "login";
	}

	@ExceptionHandler(value = FeignException.class)
	public String handleFeignClientException(Model model, HttpServletRequest request, FeignException ex) {
		logger.error("Request " + request.getRequestURL() + " Threw an Exception", ex);
		
		ErrorDetails er = null;
		try {
			er = new ObjectMapper().readValue(ex.contentUTF8(), ErrorDetails.class);
			model.addAttribute("errMsg", er.getMessage());
			// logger.debug(er.getMessage());
			logger.info("End");

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "home";

	}

	@ExceptionHandler(value = NumberFormatException.class)
	public String handleFeignClientException(Model model, HttpServletRequest request, NumberFormatException ex) {
		logger.error("Request " + request.getRequestURL() + " Threw an Exception", ex);

		model.addAttribute("errMsg", "Invalid Search " + ex.getMessage());

		return "home";

	}

	@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		logger.error("Request " + request.getRequestURL() + " Threw an Exception", ex);
		/* model.addAttribute("err",ex); */
		return "error";
	}

}