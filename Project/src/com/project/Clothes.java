package com.project;

import java.util.Scanner;

public class Clothes extends home{
	public static void clothesSection() {
		System.out.println();
		Scanner in = new Scanner(System.in);
		System.out.println("   ************************************************");
		System.out.println(
				"CLOTHES\r\n" + "1. Men's\r\n" + "2. Women's\r\n" + "3. Kid's\r\n" + "4. Home page\r\n" + "5. Exit");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			Mens.mensSection();
			break;
		case 2:
			Women.womenSection();
			break;
		case 3:
			Kids.kidSection();
			break;
		case 4:
			homeSection();
			break;
		case 5:
			exitSection();
			break;
		default:
			System.out.println("Enter a valid input");
			clothesSection();
			break;
		}
	}
}
