package baitap01;

import java.util.Scanner;

public class Bai4 {
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

		printArray(n, arr);
		System.out.println("");
		countNegativeNumber(n, arr);
		countPositiveNumber(n, arr);
		countZero(n, arr);

	}

	public static void printArray(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void countNegativeNumber(int n, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				count++;
			}
		}

		System.out.println("Có " + count + " số âm.");

	}

	public static void countPositiveNumber(int n, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				count++;
			}
		}

		System.out.println("Có " + count + " số dương.");
	}

	public static void countZero(int n, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count++;
			}
		}

		System.out.println("Có " + count + " số 0.");
	}
}
