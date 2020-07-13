package com.project;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Bill {
	String name;
	static int i = 0;
	int quantity;
	double cost;

	public Bill(String name, int quantity, double cost) {
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-28s%-17s%-15s%-15s\n", ++i, name, cost, quantity, quantity * cost);

	}
}

public class home {
	static ArrayList<Bill> bill = new ArrayList<Bill>();
	static LinkedHashMap<String, String> map ;

	public static void mapPut(String name, String amount) {
		map.put(name, amount);

	}

	public static void mapDisp() {
		int i = 1;
		System.out.printf("%-10s%-25s%-30s\n", "Sno.", "Name", "Rate");
		Set<String> set = map.keySet();
		for (String st : set) {
			System.out.printf("%-10s%-25s%-30s\n", i, st, map.get(st));
			i++;
		}
	}

	public static void exitSection() {
		Scanner in = new Scanner(System.in);
		System.out.println("Do you want to exit?\r\n" + "1. Bill\r\n" + "2. Home page\r\n" + "3. Exit");
		int choice1 = in.nextInt();
		switch (choice1) {
		case 1:
			if (home.bill.size() != 0) {
				Finalbill.billSection();
				System.exit(0);
			} else {
				System.out.println("\n\tNo item in cart\n");
				home.homeSection();
			}
		case 2:
			home.homeSection();
			break;
		case 3:
			System.exit(0);
		}

	}

	public static void addItems(String name, double cost) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Quantity");
		int quantity = in.nextInt();
		if( quantity>0) {
		System.out.println("are you sure want to add " + quantity + " items to cart\nDo you want to continue? Y/N");
		if (in.next().equalsIgnoreCase("y") ) {
			bill.add(new Bill(name, quantity, cost));
			System.out.println(quantity + " Item Added to Cart");

		} else {
			System.out.println("Item not added to cart\n");
			homeSection();
		}
		}else {
			System.out.println("Enter Valid Quantity\n");
		}
	}

	public static void removeItems() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nDo you want to remove from Cart? Y/N");
		if (in.next().equalsIgnoreCase("y")) {
			System.out.println("1.Remove item \n2.Modify Quantity of item\n3.Range Remove");
			switch (in.nextInt()) {
			case 1:
				System.out.println("Enter SI no of item to be removed");
				int index = in.nextInt();
				if (index <= home.bill.size()) {
					home.bill.remove(index - 1);
					System.out.println("Item removed Successfully");
				} else {
					System.out.println("Enter a valid input");
				}
				break;
			case 2:
				System.out.println("Enter SI no of item ");
				index = in.nextInt();
				System.out.println("Enter modified quantity");
				int newQty = in.nextInt();
				if (newQty > 0) {
					home.bill.get(index - 1).setQuantity(newQty);
					System.out.println("Successufully Modified\n");
				} else {
					home.bill.remove(index - 1);
				}
				break;
			case 3:
				System.out.println("Range to romove");
				int start=in.nextInt()-1;
				int end =in.nextInt();
				if(start<=bill.size() && end <=bill.size()) {
				bill.removeAll(bill.subList(start, end));
				System.out.println("Successufully Removed");
				}else {
					System.out.println("Enter a valid range");
				}
				break;
			default:
				System.out.println("Enter a valid input\n");
				break;
			}
		}

	}

	public static void homeSection() {
		Scanner in = new Scanner(System.in);
		System.out.println("\t\t\t*****WELCOME TO HOME PAGE*****");
		System.out
				.println("\nCATEGORIES\n" + "1. Clothes\n" + "2. Electronics\n" + "3. Home Application\n" + "4. Books\n"
						+ "5. FootWears\n" + "6. View Cart\n" + "7. Remove Cart\n" + "8. Exit\n" + "Select choice:");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			Clothes.clothesSection();
			break;
		case 2:
			Electronic.electronicSection();
			break;
		case 3:
			HomeApp.homeApplianceSection();
			break;
		case 4:
			Book.bookSection();
			break;
		case 5:
			Footwear.footWearSection();
			break;
		case 6:
			if (bill.size() != 0) {
				Cart.cartSection();
			} else {
				System.out.println("\n\tCart is empty\n");
			}
			break;
		case 7:
			removeItems();
			break;
		case 8:
			exitSection();
			break;
		default:
			System.out.println("Enter a valid input");
			break;
		}
	}

}
