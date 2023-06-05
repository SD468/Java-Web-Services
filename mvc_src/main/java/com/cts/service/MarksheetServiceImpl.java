package com.cts.service;

import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;

public class MarksheetServiceImpl implements MarksheetService {

	


	@Override
	public void downloadCsvFile(PrintWriter printWriter, Marksheet marksheet) {
		printWriter.write("Roll No, Student Name, First Language, Second Language, Math,"
				+ "Physics, Chemistry, Total Marks, Percentage, Grade\n");
		printWriter.write(marksheet.getRollNo()+","+marksheet.getStudentName()+","+
				marksheet.getFirstLang()+","+marksheet.getSecondLang()+","+marksheet.getMath()+","+marksheet.getPhys()+","+
				marksheet.getChem()+","+marksheet.getTotalMarks()+","+
				marksheet.getPercentage()+","+marksheet.getGrade()+"\n");
		
	}

}
