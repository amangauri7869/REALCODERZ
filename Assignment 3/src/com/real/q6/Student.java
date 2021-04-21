package com.real.q6;

import java.util.Scanner;

public class Student {
	
	String name;
	int marks[][]=new int[3][];
	float average[]=new float[3];
	float total[]=new float[3];
	
	void accept()
	{
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter student name");
			name=sc.nextLine();
			
			for(int i=0;i<marks.length;i++)
			{
				System.out.println("Enter the number of subjects");
				//marks=new int[5];
				int number=Integer.parseInt(sc.nextLine());
				marks[i]=new int[number];	
				
				for(int j=0;j<marks[i].length;j++)
				{
					System.out.println("enter the marks of subject" + (i+1));
					marks[i][j]=Integer.parseInt(sc.nextLine());
					total[i]=marks[i][j];
				}
				average[i]=total[i] / marks[i].length;
			}
			
			
			
		}catch(Exception ex) { System.out.println(ex); }
		
	}
	
	void display()
	{
		System.out.println("Student Name "+ name);
		for(int i=0;i<marks.length;i++)
		{
			for(int j=0;j<marks[i].length;j++)
			{
				System.out.println("The Subject marks are" + marks[i][j]);
			}
			System.out.println("total marks "+ total[i]);
			System.out.println("average marks "+ average[i]);
		}
		
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of students");
		int number=Integer.parseInt(sc.nextLine());
		Student student[]=new Student[number];
		for(int i=0;i<student.length;i++)
		{
			student[i]=new Student();
			student[i].accept();
		}
		for(int i=0;i<student.length;i++)
		{
			student[i].display();
		}
		
	}
	
	
}
