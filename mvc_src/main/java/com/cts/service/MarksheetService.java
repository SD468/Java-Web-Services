package com.cts.service;

import java.io.PrintWriter;

import org.springframework.stereotype.Service;

import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
@Service
public interface MarksheetService {
	
	void downloadCsvFile(PrintWriter printWriter, Marksheet marksheet);
}
