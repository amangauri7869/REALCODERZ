package com.real.q1;

public class StudentDemo {

	public static void main(String[] args) {
		
		Student one=new Student(1, "Ravi", 45);
		Student two=new Student(2, "Amit", 65);
		Student three=new Student(3, "Pooja", 55);
		
		System.out.println("student with highest marks is" +compareStudents(one, two, three));

	}

	private static String compareStudents(Student one, Student two, Student three) {
		
		Student st=one;
		
		if(two.getMarks() >st.getMarks())
			st=two;
		if(three.getMarks() >st.getMarks())
			st=three;
		return st.getName();
	}

}
