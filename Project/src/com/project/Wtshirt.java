package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Wtshirt extends Women {

	public static void wtshirtSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Puma", "Rs920");
		mapPut("Nike","Rs850");
		mapPut("H&M", "Rs840");
		mapPut("Adidas", "Rs980");
		mapPut("Reebok", "Rs960");
		mapPut("Gucci", "Rs1100");
		mapDisp();
//		System.out
//				.println("T SHIRTS\r\n" + "1. Puma				Rate=Rs920\r\n" + "2. Nike			\tRate=Rs850\r\n"
//						+ "3. H&M		\t\tRate=Rs840\r\n" + "4. Adidas			Rate=Rs980\r\n"
//						+ "5. Reebok			Rate=Rs960\r\n" + "6. Gucci	     \t\tRate=Rs1100\r\n"
//						+ "7. Previouspage\r\n" + "8. Home Page\r\n" + "9. Exit\r\n" + "Select choice:");
		int choice = in.nextInt();

		switch (choice) {

		case 1:
			addItems("Puma", 920);
			break;
		case 2:
			addItems("Nike", 850);
			break;
		case 3:
			addItems("H&M", 840);
			break;
		case 4:
			addItems("Adidas", 980);
			break;
		case 5:
			addItems("Reebok", 960);
			break;
		case 6:
			addItems("Gucci", 1100);
			break;
		case 7:
			womenSection();
			break;
		case 8:
			homeSection();
			break;
		case 9:
			exitSection();
			break;
		default:
			System.out.println("Enter a valid input");
			womenSection();
			break;
		}
	}

}
