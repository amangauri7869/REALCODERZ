package com.real.q4;

import java.util.Scanner;

public class Objects {
	
	static int noOfObjects=1;
	{
		noOfObjects +=1;
	}

	
	public void Test()
	{
	}
	public void Test(int n)
	{
	}
	public void Test(String s)
	{
	}
	
	void display()
	{
		Objects t1=new Objects();
		Objects t2=new Objects();
		Objects t3=new Objects();
		
		System.out.println(Objects.noOfObjects);
	}
	
	public static void main(String args[])
	{
		Objects o=new Objects();
		o.display();
	}
	
	
}
