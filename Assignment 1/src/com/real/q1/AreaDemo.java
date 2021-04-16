package com.real.q1;
import java.util.*;

public class AreaDemo {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter plot length");
		double plotlength=sc.nextDouble();
		System.out.println("enter plot width");
		double plotwidth=sc.nextDouble();
		System.out.println("enter construction area length");
		double constlength=sc.nextDouble();
		System.out.println("enter construction area width");
		double constwidth=sc.nextDouble();
		double openarea= calculateArea(plotlength, plotwidth, constlength, constwidth);
		System.out.println("open area :" +openarea);
		
	}

	public static double calculateArea(double plotlength, double plotwidth, double constlength, double constwidth) {
		double openArea=0;
		
		openArea= plotlength*plotwidth-constlength*constwidth;
		
		
		return openArea;
	}
}
