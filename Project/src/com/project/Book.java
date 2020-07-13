package com.project;

import java.util.Scanner;

public class Book extends home{

	public static void bookSection() {
		System.out.println("BOOK\r\n" + "1. Novels\r\n" + "2. Fiction\r\n"
				+ "3. E-books\r\n" + "4. Previous Page\r\n" + "5. Home Page\r\n" + "select choice:");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			Novel.novelSection();
			break;
		case 2:
			Fiction.fictionSection();
			break;
		case 3:
			Ebooks.eBookSection();
			break;
		case 4:
			homeSection();
			break;
		case 5:
			homeSection();
			break;

		default:
			System.out.println("Enter valid input");
			bookSection();
			break;
		}
	}

}
