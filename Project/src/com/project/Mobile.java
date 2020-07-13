package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Mobile extends Electronic{

	public static void mobSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Apple", "Rs130000");
		mapPut("Samsung","Rs60000");
		mapPut("OnePlus", "Rs45000");
		mapPut("Mi", "Rs20000");
		mapDisp();
//		System.out.println(
//				"MOBILE\r\n" + "1. Apple			Rate=Rs130000\r\n" + "2. Samsung			Rate=Rs60000\r\n"
//						+ "3. OnePlus			Rate=Rs45000\r\n" + "4. Mi				Rate=Rs20000\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n"+"7. Exit\n" + "Select choice:");
		int choice =in.nextInt();
		switch (choice) {

		case 1:
			addItems("Apple", 130000);
			break;
		case 2:
			addItems("Samsung", 60000);
			break;
		case 3:
			addItems("OnePlus", 45000);
			break;
		case 4:
			addItems("Mi", 20000);
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
			mobSection();
			break;
		}
	}

}
