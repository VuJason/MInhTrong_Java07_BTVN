package baitap01;

import java.util.Iterator;
import java.util.Scanner;

public class Bai8 {
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

		if (checkDuplicate(n, arr)) {
			System.out.println("Mảng ban đầu: ");
			printArray(n, arr);
			System.out.println("Nhập số trùng lặp muốn xóa: ");
			int soTrung = sc.nextInt();
			arr = deleteDuplicateNumber(n, arr, soTrung);
			System.out.println("Sau khi xóa số trùng nhau:");
			printArray(n, arr);
		} else {
			printArray(n, arr);
			System.out.println("Không có số trùng nhau!!");
		}

	}

	public static void printArray(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static boolean checkDuplicate(int n, int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static int countDuplicate(int n, int[] arr, int soTrung) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == soTrung) {
				count++;
			}
		}
		return count;
	}

	public static int[] deleteDuplicateNumber(int n, int[] arr, int soTrung) {
		int[] arrNew = new int[n - countDuplicate(n, arr, soTrung)];
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == soTrung && arr[j] != soTrung) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arrNew.length; i++) {
			if (arr[i] != soTrung) {
				arrNew[i] = arr[i];
			}
		}
		return arrNew;
	}

}
