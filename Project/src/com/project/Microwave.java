package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Microwave extends HomeApp{

	public static void microwaveSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Bosch", "Rs8500");
		mapPut("Whirlpool","Rs6000");
		mapPut("Samsung", "Rs7400");
		mapPut("LG", "Rs6500");
		mapDisp();
//		System.out.println(
//				"MICROWAVE\r\n" + "1. Bosch			Rate=Rs8500\r\n" + "2. Whirlpool			Rate=Rs6000\r\n"
//						+ "3. Samsung			Rate=Rs7400\r\n" + "4. LG				Rate=Rs6500\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n"+"7. Exit\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("Bosch", 8500);
			break;
		case 2:
			addItems("Whirlpool", 6000);
			break;
		case 3:
			addItems("Samsung", 7400);
			break;
		case 4:
			addItems("LG", 6500);
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
			microwaveSection();
			break;
		}

	}

}
