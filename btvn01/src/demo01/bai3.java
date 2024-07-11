package demo01;

import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số A: ");
		double soA = sc.nextDouble();
		System.out.println("Nhập vào số B: ");
		double soB = sc.nextDouble();
		double sum = soA + soB;
		System.out.printf("Tổng của 2 số là: %.2f", sum);
	}
}
