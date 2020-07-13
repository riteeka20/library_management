package com.project;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class MtShirt extends Mens{

	public static void mtshirtSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Puma", "Rs900");
		mapPut("U.S Polo","Rs850");
		mapPut("Peter England", "Rs840");
		mapPut("Adidas", "Rs900");
		mapPut("Lactose", "Rs860");
		mapPut("Gucci", "Rs1000");
		mapDisp();
//		System.out
//				.println("T SHIRTS\r\n" + "1. Puma				Rate=Rs900\r\n" + "2. U.S Polo			Rate=Rs850\r\n"
//						+ "3. Peter England	\tRate=Rs840\r\n" + "4. Adidas			Rate=Rs900\r\n"
//						+ "5. Lacoste			Rate=Rs860\r\n" + "6. Gucci	     \t\tRate=Rs1000\r\n"
//						+ "7. Previouspage\r\n" + "8. Home Page\r\n" + "9. Exit\r\n" + "Select choice:");
		int choice = in.nextInt();

		switch (choice) {

		case 1:
			addItems("Puma", 900);
			break;

		case 2:
			addItems("U.S Polo", 850);
			break;

		case 3:
			addItems("Peter England", 840);
			break;

		case 4:
			addItems("Adidas", 900);
			break;

		case 5:
			addItems("Lacoste", 860);
			break;

		case 6:
			addItems("Gucci", 1000);
			break;

		case 7:
			mensSection();
			break;
		case 8:
			homeSection();
			break;
		case 9:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			mtshirtSection();
			break;
		}
	}
}
