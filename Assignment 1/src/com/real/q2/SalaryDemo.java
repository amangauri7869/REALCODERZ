package com.real.q2;
import java.util.*;

public class SalaryDemo {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter basic salary");
		double basic=sc.nextDouble();
		System.out.println("enter HRA%");
		double hra=sc.nextDouble();
		System.out.println("enter DA%");
		double da=sc.nextDouble();
		System.out.println("enter insurance premium");
		double premium=sc.nextDouble();
		System.out.println("enter PF%");
		double pf=sc.nextDouble();
		
		double grossSalary= calculateGrossSalary(basic, hra, da, premium,pf);
		System.out.println("gross salary :" +grossSalary);
		
	}

	public static double calculateGrossSalary(double basic, double hra, double da, double premium, double pf) {
		
		double grossSalary=basic+hra+da-premium-pf;
		return grossSalary;
	}

}