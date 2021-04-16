package com.real.q1;

public class Student {
	
	private int rollno;
	private String name;
	private double marks;
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public int getRollno() {
		return rollno;
	}
	public String getName() {
		return name;
	}
	public Student(int rollno, String name, double marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}
	
	
	
	

}
