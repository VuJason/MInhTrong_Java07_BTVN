package baitap01;

import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int n;
		do {
			System.out.println("Please, input positive number that you want: ");
			n = sc.nextInt();
			if(n>0) {
				break;
			}else {
				System.out.println("Please, input positive number!!!");
			}
		} while (true);
		
		for (int i = 0; i < n; i++) {
			if(i%2 == 1) {
				sum+=i;
			}
		}
		System.out.println("Sum of odd number in range 0 to "+n+": " +sum);
	}
}
