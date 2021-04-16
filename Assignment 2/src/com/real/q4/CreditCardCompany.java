package com.real.q4;

import java.util.Scanner;

public class CreditCardCompany {

	Scanner sc=new Scanner(System.in);
	double charges=0, pb=0;
	
	if(charges<=500)
	{
		pb=(charges/100)*0.25;
	}
	else
	{
		pb=(500/100)*0.25;
		charges=charges-500;
		if(charges<=1000)
		{
			pb=pb+(charges/100)*0.50;
		}
		else
		{
			pb=pb+(1000/100)*0.50;
			charges=charges-1000;
			
			if(charges<=1000)
			{
				pb=pb+(charges/100)*0.75;
			}
			else
			{
				pb=pb+(1000/100)*0.75;
				charges=charges-1000;
				
				if(charges>=1)
				{
					pb=pb+(charges/100)*1.0;
				}
			}
		}
		
	}
}

}
