package com.real.q3;

import java.util.Scanner;

public class Person {
	
	String FirstName;
	String LastName;
	
	Scanner s=new Scanner(System.in);
	
	void show()
	{
		System.out.println("enter first name");
		FirstName=s.nextLine();
		System.out.println("enter last name");
		LastName=s.nextLine();
		
		System.out.println(FirstName+" "+LastName);
		
	}
	public static void main(String args[])
	{
		Person p=new Person();
		p.show();
		
	}
	
}
