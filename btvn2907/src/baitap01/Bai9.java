package baitap01;

import java.util.Scanner;

public class Bai9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			System.out.println("Nhập vào số lượng phần tử bạn muốn nhập: ");
			n = sc.nextInt();
			if (n > 0) {
				break;
			} else {
				System.out.println("Mảng không được âm!!");
			}
		}

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Nhập số #" + (i + 1) + "/" + n);
			arr[i] = sc.nextInt();
		}

		System.out.println("Nhập vô một giá trị bất kì: ");
		int num = sc.nextInt();
		count(n, arr, num);
	}

	public static void count(int n, int[] arr, int num) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > num) {
				System.out.print(arr[i] + " ");
				count++;
			}
		}
		System.out.println("");
		System.out.println("Có " + count + " lớn hơn số " +num);
	}
}
