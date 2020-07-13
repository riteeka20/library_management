package com.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HomeLogin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println();
		Date date = new Date();
		System.out.println("\t\t   ************|SHOPPINGADDA|************");
		System.out.println("\t\t\t****WELCOME TO SHOPPINGADDA***");
		SimpleDateFormat sv = new SimpleDateFormat("E, dd-MMM-yyyy hh:mm:ss a z");
		System.out.println();
		System.out.println(
				"\tDate: " + sv.format(date).substring(0, 16) + "\t\t\tTime: " + sv.format(date).substring(17));
		System.out.println("   ***********************************************************************");
		while (true) {
			System.out.print("Enter your name : ");
			String name = in.nextLine();
			if (!name.matches("[a-zA-Z]+")) {
				System.out.println("\nInvalid Entry!! Retype your name....\n");
			} else {
				while (true) {
					System.out.print("\nEnter your Phone number(10digit):+91 ");
					String number = in.next();
					if (!number.matches("[6-9]{1}[0-9]{9}")) {
						System.out.println("\nInvalid number!! Reenter your number....\n");
					} else {
						System.out.println("\n\t\t\t***Welcome "+name+" To ShoppingADDA***\n"
								+ "   ********************************************************************\n");
						break;
					}
				}
				break;
			}
		}
		while (true) {
			home.homeSection();
		}
	}
}
