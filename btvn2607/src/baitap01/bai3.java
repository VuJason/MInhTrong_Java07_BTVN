package baitap01;

import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			
			System.out.println("Nhập vào số nguyên n: ");
			n = sc.nextInt();
			if(n>0) {
				break;
			}else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}
		for (int i = 0; i < n; i++) {
			if(i%2 == 0) {
				System.out.print(i+ " ");
			}
		}
	}
}
