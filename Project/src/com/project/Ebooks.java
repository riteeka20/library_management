package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Ebooks extends Book{

	public static void eBookSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Invisible", "Rs180");
		mapPut("Lost","Rs150");
		mapPut("The Miracle of Dunkirk", "Rs200");
		mapDisp();
//		System.out.println("EBOOKSs\r\n" + "1. Invisible			Rate=Rs180\r\n" + "2. Lost			\tRate=Rs150\r\n"
//				+ "3. The Miracle of Dunkirk	Rate=Rs200\r\n" + "4. Previous Page\r\n" + "5. Home Page\r\n"+"6. Exit\n"
//				+ "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("Invisible", 180);
			break;
		case 2:
			addItems("Lost", 150);
			break;
		case 3:
			addItems("The Miracle of Dunkirk", 200);
			break;
		case 4:
			bookSection();
			break;
		case 5:
			homeSection();
			break;
		case 6:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			eBookSection();
			break;
		}
	}

}
