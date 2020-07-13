package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Laptop extends Electronic {

	public static void laptopSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Apple", "Rs100000");
		mapPut("HP","Rs50000");
		mapPut("Asus", "Rs60000");
		mapPut("Dell", "Rs55000");
		mapDisp();
//		System.out.println(
//				"LAPTOP\r\n" + "1. Apple 			Rate=Rs100000\r\n" + "2. HP			\tRate=Rs50000\r\n"
//						+ "3. Asus			\tRate=Rs60000\r\n" + "4. Dell				Rate=Rs55000\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" +"7. Exit\n" + "Select choice:");
		int choice =in.nextInt();
		switch (choice) {

		case 1:
			addItems("Apple", 100000);
			break;
		case 2:
			addItems("HP", 50000);
			break;
		case 3:
			addItems("Asus", 60000);
			break;
		case 4:
			addItems("Dell", 55000);
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
			laptopSection();
			break;
		}

	}

}
