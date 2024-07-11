package baitap;

import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số a: ");
		double a = sc.nextDouble();
		System.out.println("Nhập số n: ");
		int n = sc.nextInt();

		double result = a * Math.pow(8, n);
		System.out.println("Kết quả của biểu thức P(8)=ax^n: " + result);

	}
}
