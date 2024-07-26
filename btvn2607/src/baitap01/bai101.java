package baitap01;

import java.util.Scanner;

public class bai101 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Vui lòng nhập vào số nguyên: ");
		while (true) {
			n = sc.nextInt();
			if(n>=0) {
				break;
			}else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
			
		}
		if(n%2==1) {
			System.out.println("Số lẻ: " +n);
		}else if (n%2==0) {
			System.out.println("Số chẵn: " +n);
		}else {
			System.out.println("không phải số chẵn, số lẻ");
		}
	}
}
