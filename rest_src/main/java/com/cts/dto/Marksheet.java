package com.cts.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Marksheet {
	private double percentage;
	private int totalMarks;
	private String grade;
	private int rollNo;
	
	@Size(min = 2, max = 30, message ="Student Name must be between 2 and 30 characters")
	@Pattern(regexp="[a-zA-Z ]+" ,message="Student Name must be alphabetic only")
	@NotEmpty
	private String studentName;
	
	@NotNull
	@Min(value= 0, message ="Marks should not be less than 0")
	@Max(value=100, message ="Marks should not be greater than 100")
	private int firstLang;
	
	@NotNull
	@Min(value= 0, message ="Marks should not be less than 0")
	@Max(value=100, message ="Marks should not be greater than 100")
	private int secondLang;
	
	@NotNull
	@Min(value= 0, message ="Marks should not be less than 0")
	@Max(value=100, message ="Marks should not be greater than 100")
	private int math;
	
	@NotNull
	@Min(value= 0, message ="Marks should not be less than 0")
	@Max(value=100, message ="Marks should not be greater than 100")
	private int phys;
	
	@NotNull
	@Min(value= 0, message ="Marks should not be less than 0")
	@Max(value=100, message ="Marks should not be greater than 100")
	private int chem;
	public Marksheet() {
		// TODO Auto-generated constructor stub
	}
	public Marksheet(double percentage, int totalMarks, String grade, int rollNo,
			@Size(min = 2, max = 30, message = "Student Name must be between 2 and 30 characters") @Pattern(regexp = "[a-zA-Z ]+", message = "Student Name must be alphabetic only") @NotEmpty String studentName,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int firstLang,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int secondLang,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int math,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int phys,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int chem) {
		super();
		this.percentage = percentage;
		this.totalMarks = totalMarks;
		this.grade = grade;
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.firstLang = firstLang;
		this.secondLang = secondLang;
		this.math = math;
		this.phys = phys;
		this.chem = chem;
	}
	
	
	
	public Marksheet(int rollNo,
			@Size(min = 2, max = 30, message = "Student Name must be between 2 and 30 characters") @Pattern(regexp = "[a-zA-Z ]+", message = "Student Name must be alphabetic only") @NotEmpty String studentName,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int firstLang,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int secondLang,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int math,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int phys,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int chem,
			int totalMarks, double percentage, String grade) {
		super();
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.firstLang = firstLang;
		this.secondLang = secondLang;
		this.math = math;
		this.phys = phys;
		this.chem = chem;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Marksheet [percentage=" + percentage + ", totalMarks=" + totalMarks + ", grade=" + grade + ", rollNo="
				+ rollNo + ", studentName=" + studentName + ", firstLang=" + firstLang + ", secondLang=" + secondLang
				+ ", math=" + math + ", phys=" + phys + ", chem=" + chem + "]";
	}


	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getFirstLang() {
		return firstLang;
	}

	public void setFirstLang(int firstLang) {
		this.firstLang = firstLang;
	}

	public int getSecondLang() {
		return secondLang;
	}

	public void setSecondLang(int secondLang) {
		this.secondLang = secondLang;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getPhys() {
		return phys;
	}

	public void setPhys(int phys) {
		this.phys = phys;
	}

	public int getChem() {
		return chem;
	}

	public void setChem(int chem) {
		this.chem = chem;
	}

	
	
	
}
