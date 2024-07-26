package baitap01;

import java.util.Scanner;

public class bai6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {

			System.out.println("Nhập vào chiều rộng của hình vuông: ");
			n = sc.nextInt();
			if (n > 0) {
				break;
			} else {
				System.out.println("Vui lòng nhập số nguyên dương!!");
			}
		}

		int dienTich = n * n;
		int chuvi = 4 * n;
		System.out.println("Diện tích hình vuông: " + dienTich);
		System.out.println("Chu vi hình vuông: " + chuvi);

	}
}
