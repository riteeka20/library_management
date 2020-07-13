package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Mwatches extends Mens {
	public static void mWatchSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("MINI", "Rs6450");
		mapPut("Fossil","Rs5400");
		mapPut("Tommy Hilfiger", "Rs5200");
		mapPut("Casio", "Rs4840");
		mapPut("Armani Exchange", "Rs5960");
		mapDisp();
//		System.out.println("WATCH\r\n" + "1. MINI	\t\t\tRate=Rs6450\n" + "2. Fossil			Rate=Rs5400\r\n"
//				+ "3. Tommy Hilfiger		Rate=Rs5200\r\n" + "4. Casio 		\tRate=Rs4840\r\n"
//				+ "5. Armani Exchange		Rate=Rs5960\r\n" + "6. Previouspage\r\n" + "7. Home Page\r\n"
//				+ "8. Exit\r\n" + "Select choice:");
		switch (in.nextInt()) {
		case 1:
			addItems("MINI", 6450);
			break;
		case 2:
			addItems("Fossil", 5400);
			break;
		case 3:
			addItems("Tommy Hilfiger", 5200);
			break;
		case 4:
			addItems("Casio", 4840);
			break;
		case 5:
			addItems("Armani Exchange", 5960);
			break;
		case 6:
			mensSection();
			break;
		case 7:
			homeSection();
			break;
		case 8:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			mWatchSection();
			break;
		}
	}
}
