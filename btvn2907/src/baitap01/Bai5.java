package baitap01;

import java.util.Scanner;

public class Bai5 {
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
		int choice;
		do {

			System.out.println("1. Thêm");
			System.out.println("2. Xóa");
			System.out.println("3. Sửa");
			System.out.print("Chọn chức năng:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Nhập số muốn thêm: ");
				int soThem = sc.nextInt();
				arr = insert(n, arr, soThem);
				printArray(n, arr);
				n++;
				break;
			case 2:
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
				n--;
				break;
			case 3:
				int pos;
				System.out.println("Mảng trước khi cập nhât: ");
				printArray(n, arr);
				while (true) {
					System.out.println("Nhập vị trí bạn muốn cập nhập: ");
					pos = sc.nextInt();
					if (pos > 0 && pos <= arr.length) {
						break;

					} else {
						System.out.println("Bạn nhập sai cú pháp!!Vui lòng nhập lại vị trí bạn muốn cập nhật.");
					}
				}

				System.out.println("Mảng sau khi cập nhật: ");
				update(n, pos, arr);

				break;
			default:

			}

		} while (choice > 0 && choice < 4);
	}

	public static void printArray(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static int[] insert(int n, int[] arr, int soThem) {
		int[] arrNew = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[i];
		}
		arrNew[arr.length] = soThem;

		return arrNew;

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

	public static void update(int n, int pos, int[] arr) {
		Scanner sc = new Scanner(System.in);
		int viTriCapNhat = pos - 1;
		for (int i = 0; i < arr.length; i++) {
			if (i == viTriCapNhat) {
				System.out.println("Nhập số mới: ");
				arr[i] = sc.nextInt();
			}
		}
		printArray(n, arr);

	}

}
