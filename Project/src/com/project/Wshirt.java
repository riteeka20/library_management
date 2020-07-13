package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Wshirt extends Women {

	public static void WShirtSection() {
		Scanner in = new Scanner(System.in);
		map = new LinkedHashMap<String, String>();
		mapPut("Louis Philippe", "Rs1000");
		mapPut("John Players", "Rs1850");
		mapPut("Levi's", "Rs1200");
		mapPut("Tommy Hilfiger", "Rs2140");
		mapPut("Versace", "Rs1960");
		mapPut("Hugo Boss", "Rs2540");
		mapDisp();
		// System.out.println(
		// "SHIRTS\r\n" + "1. Louis Philippe Rate=Rs1000\r\n" + "2. John Players
		// Rate=Rs1850\r\n"
		// + "3. Levi's Rate=Rs1200\r\n" + "4. Tommy Hilfiger Rate=Rs2140\r\n"
		// + "5. Versace Rate=Rs1960\r\n" + "6. Hugo Boss Rate=Rs2540\r\n"
		// + "7. Previouspage\r\n" + "8. Home Page\r\n" + "9. Exit\r\n" + "Select
		// choice:");
		switch (in.nextInt()) {
		case 1:
			addItems("Louis Philippe", 1000);
			break;
		case 2:
			addItems("John Players", 1850);
			break;
		case 3:
			addItems("Levi's", 1200);
			break;
		case 4:
			addItems("Tommy Hilfiger", 2140);
			break;
		case 5:
			addItems("Versace", 1960);
			break;
		case 6:
			addItems("Hugo Boss", 2540);
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
			WShirtSection();
			break;
		}
	}

}
