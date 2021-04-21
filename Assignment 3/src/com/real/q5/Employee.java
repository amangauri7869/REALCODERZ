package com.real.q5;

import java.util.Scanner;

public class Employee {
	
	int empno;
	String ename;
	String employeedept;
	int salary;

	void accept()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee id");
		empno=sc.nextInt();
		Scanner scn=new Scanner(System.in);
		System.out.println("enter employee name");
		ename=scn.nextLine();
		Scanner scd=new Scanner(System.in);
		System.out.println("enter employee department");
		employeedept=scd.nextLine();
		Scanner scs=new Scanner(System.in);
		System.out.println("enter employee salary");
		salary=scs.nextInt();
	}
	void show()
	{
		System.out.println("Employee id: "+empno);
		System.out.println("Employee name: "+ename);
		System.out.println("Employee Department: "+employeedept);
		System.out.println("Employee Salary: "+salary);
		
	}
   
	public static void main(String args[])
	{
		Employee e=new Employee();
		e.accept();
		e.show();
		
	}
	
	
}
