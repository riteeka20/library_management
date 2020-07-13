package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Fiction extends Book{

	public static void fictionSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Harry Potter", "Rs245");
		mapPut("Normal People","Rs160");
		mapPut("Sherlock Holmes", "Rs200");
		mapPut("Where Forest Meet Stars", "Rs180");
		mapDisp();
//		System.out.println(
//				"FICTION BOOKS\r\n" + "1. Harry Potter			Rate=Rs245\r\n" + "2. Normal People		Rate=Rs160\r\n"
//						+ "3. Sherlock Holmes		Rate=Rs200\r\n" + "4. Where Forest Meet Stars	Rate=Rs180\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" + "7. Exit\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("Harry Potter", 245);
			break;
		case 2:
			addItems("Normal People", 160);
			break;
		case 3:
			addItems("Sherlock Holmes", 200);
			break;
		case 4:
			addItems("Where Forest Meet Stars", 180);
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
			fictionSection();
			break;
		}
	}

}
