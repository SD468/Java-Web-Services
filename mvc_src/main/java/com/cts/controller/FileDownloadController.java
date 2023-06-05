package com.cts.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.client.MarksheetClient;
import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.service.MarksheetService;
import com.cts.service.MarksheetServiceImpl;
import com.itextpdf.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
	private final Logger LOGGER = LoggerFactory.getLogger(FileDownloadController.class);
	@Autowired
	private MarksheetClient client;

	private MarksheetService marksheetService = new MarksheetServiceImpl();

	public FileDownloadController(MarksheetClient client/* ,MarksheetService marksheetService */) {
		super();
		this.client = client;
	}

	@RequestMapping("/data")
	public void downloadDataAsCSV(@RequestParam("rollNo") int rollNo, HttpServletResponse response)
			throws DocumentException, IOException {

		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment;file=marksheet.csv");
		Marksheet marksheet = client.findByRollNo(rollNo).getBody();
		LOGGER.debug("found Details:"+marksheet);
//		Marksheet marksheet = new Marksheet(marksheetService.findPercentage(entity),
//				marksheetService.findTotalMarks(entity), marksheetService.findGrade(entity), entity.getRollNo(),
//				entity.getStudentName(), entity.getFirstLang(), entity.getSecondLang(), entity.getMath(),
//				entity.getPhys(), entity.getChem());
//		LOGGER.debug("found Details:"+ marksheetService.findPercentage(entity));
//		LOGGER.debug("found Details:"+ marksheetService.findGrade(entity));
//		LOGGER.debug("found Details:"+ marksheetService.findTotalMarks(entity));
		marksheetService.downloadCsvFile(response.getWriter(), marksheet);
	}
}