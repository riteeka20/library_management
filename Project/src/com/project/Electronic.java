package com.project;

import java.util.Scanner;

public class Electronic extends home {

	public static void electronicSection() {
		System.out.println("Electronics\r\n" + "1. Mobile's\r\n" + "2. Television\r\n" + "3. Washing machine\r\n"
				+ "4. Laptop's\r\n" + "5. Camera's\r\n" + "6. Previous Page\r\n" + "7. Home Page\r\n"+"8. Exit\n"
				+ "Select choice:");
		Scanner in = new Scanner(System.in);
		int choice=in.nextInt();
		switch (choice) {
		case 1:
			Mobile.mobSection();
			break;
		case 2:
			Television.tvSection();
			break;
		case 3:
			WashingMachine.WashMchnSection();
			break;
		case 4:
			Laptop.laptopSection();
			break;
		case 5:
			Camera.cameraSection();
			break;
		case 6:
			homeSection();
			break;
		case 7:
			homeSection();
			break;
		case 8:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			electronicSection();
			break;
		}
	}

}
