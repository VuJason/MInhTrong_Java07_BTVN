package baitap01;

import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Nhập vào một sô n bất kỳ: ");
			n = sc.nextInt();
			if (n > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập lại một số nguyên dương!");
			}
		}

		if (checkOddOrEven(n)) {
			System.out.println("Đây là số chẵn!!");
		} else {
			System.out.println("Đây là số lẻ!!");
		}
	}

	public static boolean checkOddOrEven(int n) {
		if (n % 2 == 0) {
			return true;
		}
		return false;

	}
}
