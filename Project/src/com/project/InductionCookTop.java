package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class InductionCookTop extends HomeApp {

	public static void inductionTopSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Philips", "Rs2200");
		mapPut("Havells","Rs1500");
		mapPut("Pigeon", "Rs1200");
		mapPut("Prestige", "Rs1450");
		mapDisp();
//		System.out.println(
//				"INDUCTION COOKTOPS\r\n" + "1. Philips			Rate=Rs2200\r\n" + "2. Havells			Rate=Rs1500\r\n"
//						+ "3. Pigeon			Rate=Rs1200\r\n" + "4. Prestige			Rate=Rs1450\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" + "7. Exit\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("Philips", 2200);
			break;
		case 2:
			addItems("Havells", 1500);
			break;
		case 3:
			addItems("Pigeon", 1200);
			break;
		case 4:
			addItems("Prestige", 1450);
			break;
		case 5:
			homeApplianceSection();
			break;
		case 6:
			home.homeSection();
			break;
		case 7:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			inductionTopSection();
			break;
		}

	}

}
