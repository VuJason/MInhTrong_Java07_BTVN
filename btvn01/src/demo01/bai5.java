package demo01;

import java.util.Scanner;

public class bai5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input C degree: ");
		double celcius = sc.nextDouble();
		double fah = (celcius * 1.8) + 32;
		System.out.println("Convert C to F ....");
		System.out.println(fah);
	}
}
