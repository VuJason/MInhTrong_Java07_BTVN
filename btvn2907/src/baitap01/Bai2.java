package baitap01;

import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, soTrung;
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
		
		System.out.println("Nhập số bạn muốn đếm: ");
		soTrung = sc.nextInt();
		countSameNumber(n, soTrung, arr);
		
		
		
		
		
	}
	
	public static void countSameNumber(int n, int soTrung, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(soTrung == arr[i]) {
				count++;
			}
		}
		System.out.println("Số "+soTrung+" xuất hiện "+count+" lần");
	}
}
