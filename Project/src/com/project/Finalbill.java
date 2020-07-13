package com.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Finalbill extends home{
	public static void billSection() {
		int totalQnty = 0;
		double subTotal = 0;
		System.out.println("\n\t      ***********    ShoppingAdda Bill   ************\r\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println(new SimpleDateFormat("  E, dd-mm-yyyy \t\t\t\t\t hh:mm:ss a z").format(new Date()));
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%-10s%-28s%-15s%-17s%-17s\n", "SI No.", "Item Name", "Cost", "Quantity", "Total");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		for (Bill bl : home.bill) {
			totalQnty += bl.quantity;
			subTotal += (bl.quantity*bl.cost);
			System.out.println(bl);

		}
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%-10s%61s\n", "Total Quantity:", totalQnty);
		System.out.printf("%-10s%66s", "Sub Total:", subTotal);
		System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%-10s%4s%62s\n", "CGST:  ", "@9%", String.format("%.2f", subTotal * .09));
		System.out.printf("%-10s%4s%62s\n", "SGST:  ", "@9%", String.format("%.2f", subTotal * .09));
		System.out.printf("%-10s%4s%61s\n", "Total GST: ", "@18%", String.format("%.2f", subTotal * .18));
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%-10s%63s", " Grand Total:", "Rs." + String.format("%.2f", (subTotal * 1.18)));
		System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("\t\t  Thank you for visiting *SHOPPINGADDA*\r\n" + "\t\t\t   Have a Nice Day !\r\n"
				+ "\t\t\t    Visit again....\r\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
	}
}
