package demo01;

import java.util.Scanner;

public class bai6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input USD: ");
		double usd = sc.nextDouble();
		double convert = usd * 23500;
		System.out.println("Convert USD to VND....");
		System.out.printf("%.2f", convert);
	}
}
