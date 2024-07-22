package baitap01;

import java.util.Scanner;

public class bai4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		double a, b;
		while (true) {
			System.out.print("Input a: ");
			a = sc.nextDouble();
			if (a >= 0) {
				break;
			} else {
				System.out.println("Please, input positive number!!");
			}
		}

		while (true) {
			System.out.print("Input b: ");
			b = sc.nextDouble();
			if (b >= 0) {
				break;
			} else {
				System.out.println("Please, input positive number!!");
			}
		}
		do {

			System.out.println("1. Sum");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("Input operator: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				sum(a, b);
				break;

			case 2:
				minus(a, b);
				break;

			case 3:
				multiple(a, b);
				break;
			case 4:
				while (true) {
					if (b > 0) {
						break;
					} else {
						System.out.println("Can't be divided by Zero");
						System.out.print("Please, input b again: ");
						b = sc.nextDouble();
					}
				}
				division(a, b);
				break;
			}

		} while (choice < 5);
	}

	public static void sum(double a, double b) {

		double sum = a + b;
		System.out.println("Sum of 2 number: " + sum);
	}

	public static void minus(double a, double b) {

		double minus = a - b;
		System.out.println("Difference of two numbers: " + minus);
	}

	public static void multiple(double a, double b) {

		double product = a * b;
		System.out.println("Product of two numbers: " + product);
	}

	public static void division(double a, double b) {

		double division = a / b;
		System.out.printf("Quotient of two numbers: %.2f", division);
		System.out.println("");

	}
}
