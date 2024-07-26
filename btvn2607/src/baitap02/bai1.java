package baitap02;

import java.util.Iterator;
import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int choice;

		while (true) {
			System.out.print("Vui lòng nhập vào số phần tử có thể chứa trong mảng: ");
			try {
				n = Integer.parseInt(sc.nextLine());
				if (n > 0) {
					break;
				} else {
					System.out.println("Vui lòng nhập số dương !!!");
				}

			} catch (Exception e) {
				System.out.println("Vui lòng nhập số!!!");
			}
		}
		;

		int[] arr = new int[n];
		System.out.println("");

		do {

			menu();

			System.out.print("Nhập lựa chọn của bạn: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				inputData(n, arr);
				break;

			case 2:
				exportData(n, arr);
				break;
			case 3:
				maxNumber(n, arr);
				break;

			case 4:
				negativeNumber(n, arr);
				break;
			case 5:
				negativeMaxNumber(n, arr);
				break;
			case 6:
				sumEvenNumber(n, arr);
				break;
			case 7:
				countNegativeNumber(n, arr);
				break;
			case 8:
				sumOfNegativeNumber(n, arr);
				break;
			case 9:
				search(n, arr);
				break;

			}
		} while (choice > 0 && choice < 10);

	}

	public static void inputData(int n, int[] arr) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Input element #" + (i + 1) + "/" + n);
			arr[i] = sc.nextInt();
		}
	}

	public static void exportData(int n, int[] arr) {
		for (int i = 0; i < n; i++) {
			System.out.print("|" + arr[i] + " ");

		}
	}

	public static void maxNumber(int n, int[] arr) {
		int max = arr[0];
		int pos = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				pos = i;
			}
		}
		System.out.println("Số lớn nhất: " + max + " Vị trí: " + (pos + 1));

	}

	public static void negativeNumber(int n, int[] arr) {
		int firstNumber = 0;
		int pos = 0;
		if (checkNegativeExistence(n, arr)) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0) {
					firstNumber = arr[i];
					pos = i;
					break;
				}
			}
			System.out.println("Số âm đầu tiên: " + firstNumber + " Vị trí: " + (pos + 1));
		} else {
			System.out.println("Không có số âm nào trong mảng!!!");
		}

	}

	public static void negativeMaxNumber(int n, int[] arr) {
		int max = 0;
		int pos = 0;
		if (checkNegativeExistence(n, arr)) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < 0) {
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[j] < 0) {
							if (arr[i] > arr[j]) {
								max = arr[i];
								pos = i;
							} else {
								max = arr[j];
								pos = j;
							}
						}
					}
				}

			}
			System.out.println("Số âm lớn nhất: " + max + " Vị trí: " + (pos + 1));
		} else {
			System.out.println("Không có số âm nào trong mảng!!");
		}

	}

	public static void sumEvenNumber(int n, int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println("Tổng các số chẵn: " + sum);
	}

	public static void countNegativeNumber(int n, int[] arr) {
		int count = 0;
		if (checkNegativeExistence(n, arr)) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0) {
					count++;
				}
			}
			System.out.println("Có " + count + " số âm");
		} else {
			System.out.println("Không có số âm nào trong mảng!!!");
		}

	}

	public static void sumOfNegativeNumber(int n, int[] arr) {
		int sum = 0;
		if (checkNegativeExistence(n, arr)) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0) {
					sum += arr[i];
				}
			}
			System.out.println("Tổng các số âm: " + sum);
		} else {
			System.out.println("Không có số âm nào trong mảng!!!");
		}

	}

	public static void search(int n, int[] arr) {
		Scanner sc = new Scanner(System.in);
		int pos = 0;
		System.out.println("Vui lòng nhập số bạn muốn tìm: ");
		int search = sc.nextInt();
		exportData(n, arr);
		System.out.println("");

		for (int i = 0; i < arr.length; i++) {
			if (search == arr[i]) {
				pos = i;
			}
		}
		if (search == pos) {
			System.out.println("Vị trí số của bạn muốn tìm trong mảng: " + (pos + 1));
		} else {
			System.out.println("Số bạn tìm không có trong mảng!!!");
		}

	}

	public static boolean checkNegativeExistence(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				return true;
			}
		}
		return false;

	}

	public static void menu() {
		System.out.println("");
		System.out.println("Menu xử lý mảng");
		System.out.println("---------------------------------------------------");
		System.out.println("1. Nhập số vào trong  mảng");
		System.out.println("2. In các phần tử mảng");
		System.out.println("3. Tìm số lớn nhất và vị trí của số đó");
		System.out.println("4. Tìm số âm đầu tiên và vị trí của số đó");
		System.out.println("5. Tìm số âm lớn nhất và vị trí của số đó");
		System.out.println("6. Tính tổng các số chẵn");
		System.out.println("7. Đếm số âm");
		System.out.println("8. Tổng các số âm");
		System.out.println("9. Tìm số trong mảng");
		System.out.println("10. Thoát");
		System.out.println("---------------------------------------------------");

	}

}
