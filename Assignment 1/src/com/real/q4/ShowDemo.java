package com.real.q4;
import java.util.*;

public class ShowDemo {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter Fixed Cost");
		double fixedCost=sc.nextDouble();
		System.out.println("enter Variable Cost");
		double variableCost=sc.nextDouble();
		System.out.println("enter rate");
		double ratePerTicket=sc.nextDouble();
		System.out.println("enter number of attendees");
		double noOfAttendees=sc.nextDouble();
		
		double profit= calculateProfit(fixedCost, variableCost, ratePerTicket, noOfAttendees);
		System.out.println("Profit :" +profit);
		
	}

	public static double calculateProfit(double fixedCost, double variableCost, double ratePerTicket,
			double noOfAttendees) {
		
		double profit=0;
		profit=fixedCost+variableCost+ratePerTicket+noOfAttendees;
		return profit;
	}

}