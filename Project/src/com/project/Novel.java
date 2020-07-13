package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Novel extends Book {

	public static void novelSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("The Lord Of The Rings", "Rs245");
		mapPut("1984","Rs220");
		mapPut("Dune", "Rs160");
		mapPut("The Martian", "Rs180");
		mapDisp();
//		System.out.println(
//				"NOVELS\r\n" + "1. The Lord Of The Rings	Rate=Rs245\r\n" + "2. 1984			\tRate=Rs220\r\n"
//						+ "3. Dune			\tRate=Rs160\r\n" + "4. The Martian			Rate=Rs180\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" + "7. Exit\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("The Lord Of The Rings", 245);
			break;
		case 2:
			addItems("1984", 220);
			break;
		case 3:
			addItems("Dune", 160);
			break;
		case 4:
			addItems("The Martian", 180);
			break;
		case 5:
			bookSection();
			break;
		case 6:
			homeSection();
			break;
		case 7:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			novelSection();
			break;
		}
	}

}
