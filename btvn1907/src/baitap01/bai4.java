package baitap01;

import java.util.Scanner;

public class bai4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		double x;
		while (true) {
			System.out.println("Vui lòng nhập x lớn hơn 0: ");
			x = sc.nextDouble();
			if(x>0) {
				break;
			}else {
				System.out.println("x là số âm. Vui lòng nhập lại x!!");
			}
		}
		while (true) {
			System.out.println("Vui lòng nhập n lớn hơn 0: ");
			n = sc.nextInt();
			if(n>0) {
				break;
			}else {
				System.out.println("n là số âm. Vui lòng nhập lại n!!");
			}
		}
		
		System.out.println("Tổng lũy thừa: " +tongLuyThua(x, n));
	}
	
	
	public static double tongLuyThua(double x, int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum+= Math.pow(x, i);
		}
		return sum;
	}
}
