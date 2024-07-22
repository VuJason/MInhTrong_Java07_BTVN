package baitap01;

import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		while (true) {
			System.out.println("Nhập vào số A: ");
			a = sc.nextInt();
			if (a > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}
		while (true) {
			System.out.println("Nhập vào số B: ");
			b = sc.nextInt();
			if (b > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}
		while (true) {
			System.out.println("Nhập vào số C: ");
			c = sc.nextInt();
			if (c > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}

		}

		System.out.println(maxNumber(a, b, c));
	}

	public static int maxNumber(int a, int b, int c) {
		int max = a;

		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}
}
