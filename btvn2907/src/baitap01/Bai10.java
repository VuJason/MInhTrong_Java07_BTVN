package baitap01;

import java.util.Scanner;


public class Bai10 {
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
		sumPrimNumber(n, arr);
		
		
	}
	
	public static void printArray(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	public static boolean isPrime(int prime) {
		if(prime < 2) {
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(prime); i++) {
			if(prime % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void sumPrimNumber(int n, int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(isPrime(arr[i]) && arr[i] < n) {
				sum+=arr[i];
			}
		}
		System.out.println("Tổng các số nguyên tố nhỏ hơn n: " +sum);
	}
	
	
}
