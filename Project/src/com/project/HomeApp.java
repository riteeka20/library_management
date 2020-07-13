package com.project;

import java.util.Scanner;

public class HomeApp extends home {

	public static void homeApplianceSection() {
		System.out.println("HOME APPLIANCES\r\n" + "1. Refrigerator\r\n" + "2. Microwave\r\n"
				+ "3. Induction CookTops\r\n" + "4. Previous Page\r\n" + "5. Home Page\r\n" + "select choice:");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			Refrigerator.frigeSection();
			break;
		case 2:
			Microwave.microwaveSection();
			break;
		case 3:
			InductionCookTop.inductionTopSection();
			break;
		case 4:
			homeSection();
			break;
		case 5:
			homeSection();
			break;

		default:
			System.out.println("Enter valid input");
			homeApplianceSection();
			break;
		}
	}

}
