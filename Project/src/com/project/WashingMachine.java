package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class WashingMachine extends Electronic{

	public static void WashMchnSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Samsung", "Rs12000");
		mapPut("LG","Rs13400");
		mapPut("Whirlpool", "Rs14500");
		mapPut("Bosch", "Rs16500");
		mapDisp();
//		System.out.println(
//				"LAPTOP\r\n" + "1. Samsung 			Rate=Rs12000\r\n" + "2. LG			\tRate=Rs13400\r\n"
//						+ "3. Whirlpool			Rate=Rs14500\r\n" + "4. Bosch			Rate=Rs16500\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" +"7. Exit\n" + "Select choice:");
		int choice =in.nextInt();
		switch (choice) {

		case 1:
			addItems("Samsung", 12000);
			break;
		case 2:
			addItems("LG", 13400);
			break;
		case 3:
			addItems("Whirlpool", 14500);
			break;
		case 4:
			addItems("Bosch", 16500);
			break;
		case 5:
			electronicSection();
			break;
		case 6:
			homeSection();
			break;
		case 7:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			WashMchnSection();
			break;
		}
	}

}
