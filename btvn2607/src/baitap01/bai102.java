package baitap01;

import java.util.Scanner;

public class bai102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		while (true) {
			System.out.println("Vui lòng nhập vào số nguyên: ");
			n = sc.nextInt();
			if (n >= 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}

		if (soNguyenTo(n)) {
			System.out.println("Đây là số nguyên tố");
		}else {
			System.out.println("Đây không phải số nguyên tố");
		}

	}

	public static boolean soNguyenTo(int n) {
		if (n <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
