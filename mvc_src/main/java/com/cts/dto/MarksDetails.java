package com.cts.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MarksDetails {
	
	private int rollNo;
	
	@Size(min = 2, max = 30)//, message ="Student Name must be between 2 and 30 characters")
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

	public MarksDetails() {
	}

	public MarksDetails(int rollNo, String studentName, int firstLang, int secondLang, int math, int phys, int chem) {
		super();
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.firstLang = firstLang;
		this.secondLang = secondLang;
		this.math = math;
		this.phys = phys;
		this.chem = chem;
	}
	

	public MarksDetails(
			@Size(min = 2, max = 30, message = "Student Name must be between 2 and 30 characters") @Pattern(regexp = "[a-zA-Z ]+", message = "Student Name must be alphabetic only") String studentName,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int firstLang,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int secondLang,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int math,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int phys,
			@NotNull @Min(value = 0, message = "Marks should not be less than 0") @Max(value = 100, message = "Marks should not be greater than 100") int chem) {
		super();
		this.studentName = studentName;
		this.firstLang = firstLang;
		this.secondLang = secondLang;
		this.math = math;
		this.phys = phys;
		this.chem = chem;
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

	@Override
	public String toString() {
		return "Marksheet [rollNo=" + rollNo + ", studentName=" + studentName + ", firstLang=" + firstLang
				+ ", secondLang=" + secondLang + ", math=" + math + ", phys=" + phys + ", chem=" + chem + "]";
	}
	
}
