package baitap01;

import java.util.Scanner;

public class bai8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			
			System.out.println("Nhập vào số lần bạn muốn nhập: ");
			n = sc.nextInt();
			if(n>0) {
				break;
			}else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Nhập phần tử số nguyên #" +(i+1));
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Số chẵn: ");
		for (int i = 0; i < arr.length; i++) {
			if(i%2==0) {
				System.out.println(arr[i] + " ");
			}
		}
		
	}
}
