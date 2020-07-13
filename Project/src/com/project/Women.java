package com.project;

import java.util.Scanner;

public class Women extends Clothes{

	public static void womenSection() {
		Scanner in = new Scanner(System.in);
		System.out.println("WOMEN'S\r\n" + "1. Tshirts\r\n" + "2. Shirts\r\n" + "3. Pants\r\n"
				+ "4. Previous page\r\n" + "5. Home Page\r\n" + "6. Exit\r\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			Wtshirt.wtshirtSection();
			break;
		case 2:
			Wshirt.WShirtSection();
			break;
		case 3:
			Wpants.wPantsSection();
			break;
		case 4:
			clothesSection();
			break;
		case 5:
			homeSection();
			break;
		case 6:
			exitSection();
			break;
		default:
			System.out.println("Enter a valid input");
			clothesSection();
			break;
		}
	}


}
