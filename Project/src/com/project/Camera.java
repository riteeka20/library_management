package com.project;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Camera extends Electronic{

	public static void cameraSection() {
		Scanner in = new Scanner(System.in);
		map=new LinkedHashMap<String, String>();
		mapPut("Canon", "Rs52000");
		mapPut("Nikon","Rs50000");
		mapPut("Sony", "Rs48000");
		mapDisp();
//		System.out.println("CAMERA\r\n" + "1. Canon 			Rate=Rs52000\r\n"
//				+ "2. Nikon			Rate=Rs50000\r\n" + "3. Sony			\tRate=Rs48000\r\n" + "4. Previous Page\r\n"
//				+ "5. Home Page\r\n" +"6. Exit\n"+ "Select choice:");
		int choice = in.nextInt();
		switch (choice) {

		case 1:
			addItems("Canon", 52000);
			break;
		case 2:
			addItems("Nikon", 50000);
			break;
		case 3:
			addItems("Sony", 48000);
			break;
		case 4:
			electronicSection();
			break;
		case 5:
			homeSection();
			break;
		case 6:
			exitSection();
			break;
		default:
			System.out.println("Enter valid input");
			cameraSection();
			break;
		}
	}

}
