package com.project;

import java.util.Scanner;

public class Mens extends Clothes{
	public static void mensSection() {
		Scanner in = new Scanner(System.in);
		System.out.println("MEN'S\r\n" + "1. Tshirts\r\n" + "2. Shirts\r\n" + "3. Pants\r\n" + "4. Watches\r\n"
				+ "5. Previous page\r\n" + "6. Home Page\r\n" + "7. Exit\r\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			MtShirt.mtshirtSection();
			break;
		case 2:
			Mshirt.mShirtSection();
			break;
		case 3:
			Mpants.mPantsSection();
			break;
		case 4:
			Mwatches.mWatchSection();
			break;
		case 5:
			clothesSection();
			break;
		case 6:
			homeSection();
			break;
		case 7:
			exitSection();
		default:
			System.out.println("Enter valid input");
			mensSection();
			break;
		}
	}
}
