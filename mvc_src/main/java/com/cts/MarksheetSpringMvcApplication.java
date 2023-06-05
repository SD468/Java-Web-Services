package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarksheetSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarksheetSpringMvcApplication.class, args);
	}

}
