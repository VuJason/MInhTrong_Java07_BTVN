package baitap01;

import java.util.Iterator;
import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		int countOddNumber = 0;
		int countEvenNumber = 0;
		for (int i = 0; i < arr.length; i++) {
			do {
				System.out.print("Please, input your favourite number " + (i + 1) + "/3: ");
				arr[i] = sc.nextInt();
				if(arr[i] < 0) {
					System.out.println("You need to input positive number!!!");
				}
			}while(arr[i] < 0);
			
		}
		System.out.println("Your three favourite number:");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);

			if (arr[i] % 2 == 0) {
				countEvenNumber++;
			} else {
				countOddNumber++;
			}
		}
		System.out.println("");

		System.out.println("There is/are " + countEvenNumber + " even number.");
		System.out.println("There is/are " + countOddNumber + " odd number.");
	}
}
