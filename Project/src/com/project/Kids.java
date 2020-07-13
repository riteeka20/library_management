package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Kids extends Clothes{

	public static void kidSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("T-Shirt", "Rs250");
		mapPut("Shirt","Rs320");
		mapPut("Jeans", "Rs540");
		mapDisp();
//		System.out.println("KID'S \r\n" + "1. T-Shirt			Rate=Rs250\r\n" + "2. Shirt			Rate=Rs320\r\n"
//				+ "3. Jeans		\tRate=Rs540\r\n" + "4. Previouspage\r\n" + "5. Home Page\r\n" + "6. Exit\r\n"
//				+ "Select choice:");
		int choice = in.nextInt();

		switch (choice) {

		case 1:
			addItems("T-Shirt", 250);
			break;
		case 2:
			addItems("Shirt", 320);
			break;
		case 3:
			addItems("Jeans", 540);
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
			kidSection();
			break;
		}
	}

}
