package baitap01;

import java.util.Scanner;

public class bai5 {
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
			System.out.println("Nhập phần tử số nguyên #" + (i + 1));
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("Số lớn nhất: " + arr[n - 1]);
		System.out.println("Số nhỏ nhất: " + arr[0]);
	}
}
