package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Wpants extends Women {

	public static void wPantsSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Levi's", "Rs2450");
		mapPut("Jack & Jones","Rs2150");
		mapPut("Calvin Klein", "Rs2200");
		mapPut("Tommy Hilfiger", "Rs1840");
		mapPut("Nike", "Rs1960");
		mapPut("Adidas", "Rs1620");
		mapDisp();
//		System.out.println("PANTS\r\n" + "1. Levi's			Rate=Rs2450\n" + "2. Jack & Jones			Rate=Rs2150\r\n"
//				+ "3. Calvin Klein			Rate=Rs2200\r\n" + "4. Tommy Hilfiger		Rate=Rs1840\r\n"
//				+ "5. Nike				Rate=Rs1960\r\n" + "6. Adidas			Rate=Rs1620\r\n" + "7. Previouspage\r\n"
//				+ "8. Home Page\r\n" + "9. Exit\r\n" + "Select choice:");
		switch (in.nextInt()) {
		case 1:
			addItems("Levi's", 2450);
			break;
		case 2:
			addItems("Jack & Jones", 2150);
			break;
		case 3:
			addItems("Calvin Klein", 2200);
			break;
		case 4:
			addItems("Tommy Hilfiger", 1840);
			break;
		case 5:
			addItems("Nike", 1960);
			break;
		case 6:
			addItems("Adidas", 1620);
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
			System.out.println("Enter valid input");
			wPantsSection();
			break;
		}
	}

}
