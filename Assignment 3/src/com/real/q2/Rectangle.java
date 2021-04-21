package com.real.q2;

import java.util.Scanner;

public class Rectangle {
	
	int length=1;
	int breadth=1;
	
	void calculate()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter length");
		length=sc.nextInt();
		System.out.println("enter breadth");
		breadth=sc.nextInt();
		int area=length*breadth;
		System.out.println("Area of rectangle is: "+area);
	}
	public static void main(String args[])
	{
		Rectangle r=new Rectangle();
		r.calculate();
		
	}
}
