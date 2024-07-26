package baitap01;

import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		while (true) {
			System.out.println("Vui lòng nhập vào số nguyên: ");
			num = sc.nextInt();
			if(num > 0) {
				break;
			}else {
				System.out.println("phải là số nguyên dương!!!");
			}
		}

		if (num >= 0) {
			System.out.println("Đây là số nguyên dương.");
		} else {
			System.out.println("Đây là số nguyên âm");
		}
	}
}
