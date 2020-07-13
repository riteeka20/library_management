package com.project;

import java.util.Scanner;

public class Footwear extends home{

	public static void footWearSection() {
		System.out.println("FOOTWEAR\r\n" + "1. Shoes\r\n" + "2. Slippers\r\n" + "3. Previous Page\r\n"
				+ "4. Home Page\r\n" + "select choice:");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			Shoes.shoeSection();
			break;
		case 2:
			Slipper.slipperSection();
			break;
		case 3:
			homeSection();
			break;
		case 4:
			homeSection();
			break;

		default:
			System.out.println("Enter valid input");
			footWearSection();
			break;
		}
	}

}
