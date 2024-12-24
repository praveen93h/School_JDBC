package com.mgmt;

import java.util.Scanner;

public class SchoolDriver {

	public static void main(String[] args) {
		Scanner scn=new Scanner (System.in);
		System.out.println("WELCOME TO MY SCHOOL DRIVER");
		System.out.println("Enter 1 to Save student Details");
		System.out.println("Enter 2 to Update student Details");
		System.out.println("Enter 3 to Delete student Details");
		System.out.println("Enter 4 to fetch Details");
		System.out.println("Enter 5 to exit application");
		
		System.out.println("Enter the choice");
		int choice=scn.nextInt();
		SchoolService s=new SchoolService();
		switch(choice)
		{
		case 1:
			int num =s.save();
		if(num!=0)
		{
			System.out.print("Date saved");
		}
		break;
		case 2:
			int num1 =s.update();
		if(num1!=0)
		{
			System.out.print("Date saved");
		}
		break;
		case 3:
			int num2 =s.delete();
		if(num2!=0)
		{
			System.out.print("Date saved");
		}
		break;
		case 4:
			s.fetch();
		
		break;
		default:
			break;
		}
		

	}

}

