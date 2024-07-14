package baitap02;

import java.util.Scanner;

public class bai01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Product Name: ");
		String proName = sc.nextLine();
		int quantity;
		while (true) {
			System.out.println("Quantity: ");
			quantity = Integer.parseInt(sc.nextLine());
			if(quantity > 0) {
				break;
			}else {
				 System.out.println("quantity must be positive number.");
			}
		}
		
		double unitPrice;
		while(true) {
			System.out.println("Unit Price: ");
			unitPrice = Double.parseDouble(sc.nextLine());
			if(unitPrice > 0) {
				break;
			}else {
				 System.out.println("Unit price must be positive number.");
			}
		}
		
		
		double total;
		if(quantity >= 50 && quantity <= 100) {
			 total = (quantity * unitPrice) - (0.08*(quantity * unitPrice));
		}else if(quantity > 100) {
			total = (quantity * unitPrice) - (0.12*(quantity * unitPrice));
		}else {
			total = quantity * unitPrice;
		}
		
		System.out.println("Total price of product: " +total);
		
	}
}
