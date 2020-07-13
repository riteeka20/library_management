package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Television extends Electronic{

	public static void tvSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Sony", "Rs150000");
		mapPut("Samsung","Rs100000");
		mapPut("Onida", "Rs45000");
		mapPut("LG", "Rs50000");
		mapDisp();
//		System.out.println(
//				"TELEVISION\r\n" + "1. Sony				Rate=Rs150000\r\n" + "2. Samsung			Rate=Rs100000\r\n"
//						+ "3. Onida			Rate=Rs45000\r\n" + "4. LG				Rate=Rs50000\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" +"7. Exit\n"+ "Select choice:");
		int choice =in.nextInt();
		switch (choice) {

		case 1:
			addItems("Sony", 150000);
			break;
		case 2:
			addItems("Samsung", 100000);
			break;
		case 3:
			addItems("Onida", 45000);
			break;
		case 4:
			addItems("LG", 50000);
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
			tvSection();
			break;
		}
	}

}
