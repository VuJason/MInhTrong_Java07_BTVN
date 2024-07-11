package baitap;

import java.util.Scanner;

public class bai4 {
	final static int SO_CHIA = 5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input first number: ");
		double so1 = sc.nextDouble();
		System.out.println("Input second number: ");
		double so2 = sc.nextDouble();
		System.out.println("Input third number: ");
		double so3 = sc.nextDouble();
		System.out.println("Input fourth number: ");
		double so4 = sc.nextDouble();
		System.out.println("Input fifth number: ");
		double so5 = sc.nextDouble();
		
		int avg = (int)(so1 + so2 + so3 + so4 + so5) / SO_CHIA;
		System.out.println("Avg : " +avg);
		
	}
}
