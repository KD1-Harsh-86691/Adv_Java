package com.sunbeam;

public class Marks {
	
	private String subject;
	private int marks;
	
	public Marks() {
	}

	public Marks(String subject, int marks) {
		this.subject = subject;
		this.marks = marks;
	}
		
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Marks [subject=" + subject + ", marks=" + marks + "]";
	}	
}
