package baitap01;

import java.util.Iterator;
import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, soXoa;
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
		System.out.println("Mảng trước khi xóa: ");
		printArray(n, arr);
		System.out.println("");

		int viTriSoXoa;
		do {
			System.out.print("Số cần xóa: ");
			soXoa = sc.nextInt();
			viTriSoXoa = positionDeletedNumber(arr, soXoa);
			if (viTriSoXoa == -1) {
				System.out.println("Không tìm thấy số cần xóa trong mảng!!");
			}
		} while (viTriSoXoa == -1);

		arr = delete(n, soXoa, arr);
		System.out.println("Mảng sau khi xóa: ");
		printArray(n, arr);

	}

	public static void printArray(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] delete(int n, int soXoa, int[] arr) {
		int viTriSoXoa = positionDeletedNumber(arr, soXoa);
		int[] arrNew = new int[n - 1];

		for (int i = 0; i < viTriSoXoa; i++) {
			arrNew[i] = arr[i];
		}
		for (int i = viTriSoXoa + 1; i < arr.length; i++) {
			arrNew[i - 1] = arr[i];
		}

		return arrNew;

	}

	public static int positionDeletedNumber(int[] arr, int soXoa) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == soXoa) {
				return i;
			}
		}
		return -1;

	}
}
