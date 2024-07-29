package baitap01;

import java.util.Iterator;
import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			System.out.println("Nhập vào số lượng phần tử bạn muốn nhập: ");
			n = sc.nextInt();
			if(n > 0) {
				break;
			}else {
				System.out.println("Mảng không được âm!!");
			}
		}
		
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Nhập số #" +(i+1)+"/"+n);
			arr[i] = sc.nextInt();
		}
		sumOddNumber(n, arr);
		

	}

	public static void sumOddNumber(int n, int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 1) {
				sum+=arr[i];
			}
		}
		System.out.println("Tổng số lẻ trong mảng: " +sum);
	}

}
