package baitap02;

import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			System.out.print("Vui lòng nhập một số n tùy thích lớn hơn 0: ");
			n = sc.nextInt();
			if(n>0) {
				break;
			}else {
				System.out.println("Bạn nhập sai yêu cầu!! Vui lòng nhập lại.");
			}
		}
		sumWhile(n);
		System.out.println("");
		sumFor(n);
	}
	
	public static void sumWhile(int n) {
		int i = 1;
		int sum = 0;
		while (i <= n) {
			if(i%2 == 0) {
				sum+=i;
			}
			i++;
		}
		System.out.print("Tổng các số chẵn: " +sum);
	}
	
	public static void sumFor(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if(i%2 == 0) {
				sum+=i;
			}
		}
		System.out.println("Tổng các số chẵn: " +sum);
	}
}
