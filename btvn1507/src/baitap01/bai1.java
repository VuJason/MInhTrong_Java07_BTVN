package baitap01;

import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] name = new String[3];
		int[] yob = new int[3];
		
		for (int i = 0; i < yob.length; i++) {
			System.out.println("Please, input student's name: ");
			name[i] = sc.nextLine();
			do {
				System.out.println("Please, input year of birth: ");
				yob[i] = Integer.parseInt(sc.nextLine());
				if(yob[i] < 0) {
					System.out.println("Year of birth must be a positive number!!!");
				}
			}while(yob[i] < 0);
			
		}
		
		int youngestIndex = 0;
        for (int i = 1; i < yob.length; i++) {
            if (yob[i] > yob[youngestIndex]) {
                youngestIndex = i;
            }
        }

        System.out.println("The youngest student: " + name[youngestIndex]+ " " +yob[youngestIndex]);
		
	}
}
