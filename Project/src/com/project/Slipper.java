package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Slipper extends Footwear{

	public static void slipperSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Nike", "Rs650");
		mapPut("Puma","Rs300");
		mapPut("Adidas", "Rs400");
		mapPut("Sparks", "Rs250");
		mapDisp();
//		System.out.println(" SHOES\r\n" + "1. Nike			Rate=Rs650\r\n" + "2. Puma		\tRate=Rs300\r\n"
//				+ "3. Adidas		Rate=Rs400\r\n" + "4. Sparks	\tRate=Rs250\r\n" + "5. Previous Page\r\n"
//				+ "6. Home Page\r\n" + "7. Exit\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("Nike", 650);
			break;
		case 2:
			addItems("Puma", 300);
			break;
		case 3:
			addItems("Adidas", 400);
			break;
		case 4:
			addItems("Sparks", 250);
			break;
		case 5:
			footWearSection();
			break;
		case 6:
			homeSection();
			break;
		case 7:
			exitSection();
			break;

		default:
			System.out.println("Enter valid input");
			slipperSection();
			break;
		}
	}

}
