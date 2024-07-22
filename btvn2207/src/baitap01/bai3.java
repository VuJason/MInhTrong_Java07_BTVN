package baitap01;

import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, c;
		while (true) {
			System.out.println("Nhập vào số A: ");
			a = sc.nextDouble();
			if (a > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}
		while (true) {
			System.out.println("Nhập vào số B: ");
			b = sc.nextDouble();
			if (b > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}
		while (true) {
			System.out.println("Nhập vào số C: ");
			c = sc.nextDouble();
			if (c > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}
		
		System.out.printf("Tổng 3 số: %.2f " ,tinhTong(a, b, c));
	}

	public static double tinhTong(double a, double b, double c) {
		double sum = a + b + c;
		return sum;
	}
}
