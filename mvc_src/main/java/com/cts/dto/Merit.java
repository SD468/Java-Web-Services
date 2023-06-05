package com.cts.dto;

public class Merit {
	private int rank;
	private int rollNo;
	private String studentName;
	private int totalMarks;
	public Merit() {
		// TODO Auto-generated constructor stub
	}
	public Merit(int rank, int rollNo, String studentName, int totalMarks) {
		super();
		this.rank = rank;
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.totalMarks = totalMarks;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "Merit [rank=" + rank + ", rollNo=" + rollNo + ", studentName=" + studentName + ", totalMarks="
				+ totalMarks + "]";
	}
	

}
