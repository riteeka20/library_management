package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Shoes extends Footwear{

	public static void shoeSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Nike", "Rs2050");
		mapPut("Puma","Rs1600");
		mapPut("Adidas", "Rs2000");
		mapPut("Skechers", "Rs3500");
		mapDisp();
//		System.out.println(
//				" SHOES\r\n" + "1. Nike			Rate=Rs2050\r\n" + "2. Puma		\tRate=Rs1600\r\n"
//						+ "3. Adidas		Rate=Rs2000\r\n" + "4. Skechers	\tRate=Rs3500\r\n"
//						+ "5. Previous Page\r\n" + "6. Home Page\r\n" +"7. Exit\n"+ "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("Nike", 2050);
			break;
		case 2:
			addItems("Puma", 1600);
			break;
		case 3:
			addItems("Adidas", 2000);
			break;
		case 4:
			addItems("Skechers", 3500);
			break;
		case 5:
			footWearSection();
			break;
		case 6:
			homeSection();
			break;
		case 7:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			shoeSection();
			break;
		}
	}

}
