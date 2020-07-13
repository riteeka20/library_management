package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Refrigerator extends HomeApp {

	public static void frigeSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("LG", "Rs24500");
		mapPut("Whirlpool","Rs22000");
		mapPut("Samsung", "Rs26000");
		mapPut("Bosch", "Rs25000");
		mapDisp();
//		System.out.println(
//				"REFRIGERATORS\r\n" + "1. LG				Rate=Rs24500\r\n" + "2. Whirlpool			Rate=Rs22000\r\n"
//						+ "3. Samsung			Rate=Rs26000\r\n" + "4. Bosch			Rate=Rs25000\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" +"7. Exit\n"+ "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("LG", 24500);
			break;
		case 2:
			addItems("Whirlpool", 22000);
			break;
		case 3:
			addItems("Samsung", 26000);
			break;
		case 4:
			addItems("Bosch", 25000);
			break;
		case 5:
			homeApplianceSection();
			break;
		case 6:
			homeSection();
			break;
		case 7:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			frigeSection();
			break;
		}
	}

}
