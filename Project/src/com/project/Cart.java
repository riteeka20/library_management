package com.project;

import java.util.Scanner;

public class Cart extends home {
	public static void cartSection() {
		Scanner scan = new Scanner(System.in);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  ");
		System.out.printf("%-10s%-28s%-15s%-17s%-17s\n", "SI No.", "| Item Name", "| Cost", "| Quantity", "| Total");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  ");
		for (Bill bl : home.bill) {
			System.out.printf("%-10s%-28s%-15s%-17s%-17s\n", home.bill.indexOf(bl) + 1, "| " + bl.name, "| " + bl.cost,
					"| " + bl.quantity, "| " + bl.quantity*bl.cost);
		}
		removeItems();

	}
}
