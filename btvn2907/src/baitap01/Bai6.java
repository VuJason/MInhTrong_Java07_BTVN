package baitap01;

import java.util.Scanner;

public class Bai6 {
	final static double LAI_SUAT = 0.05;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double tienVon;
		int nam;
		while (true) {
			System.out.println("Nhập tiền vốn: ");
			tienVon = sc.nextDouble();
			if (tienVon > 0) {
				break;
			} else {
				System.out.println("Tiền không âm !!!");
			}
		}

		while (true) {
			System.out.println("Nhập số năm bạn muốn gửi: ");
			nam = sc.nextInt();
			if (nam > 0) {
				break;
			} else {
				System.out.println("Năm không âm !!!");
			}
		}

		double A = tienVon * (1 + LAI_SUAT * nam);
		System.out.printf("Lãi suất sau %d năm: %.2f", nam, A);
	}
}
