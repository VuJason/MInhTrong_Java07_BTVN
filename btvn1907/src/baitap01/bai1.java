package baitap01;

import java.util.Random;
import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int choice;
		int n;
		int countUserWin = 0;
		int countComWin = 0;

		do {

			System.out.println("1. Start rob, paper, scissors.");
			System.out.println("2. Show total result.");
			System.out.println("3. Exit.");
			System.out.print("Choose option you want: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("1. Scissors");
				System.out.println("2. Rock");
				System.out.println("3. Paper");
				int randomNum = rand.nextInt(3) + 1;
				do {
					System.out.print("Please, choose Scissors/Rock/Paper to gain opponents: ");
					n = sc.nextInt();
					if (n > 0 && n < 4) {
						break;
					} else {
						System.out.println("Please, input available option above!!");
					}

				} while (true);

				if (randomNum == n) {
					System.out.println("Draw!!");
				} else if ((randomNum == 1 && n == 2) || (randomNum == 2 && n == 3) || (randomNum == 3 && n == 1)) {
					System.out.println("You win !!!");
					countUserWin++;

				} else {
					System.out.println("Computer win!!!");
					countComWin++;
				}

				break;
			case 2:

				if (countUserWin > countComWin) {
					System.out.println("The winner is User with the score " + countUserWin + ":" + countComWin);
					System.out.println("");
				} else {
					System.out.println("The winner is Computer with the score " + countComWin + ":" + countUserWin);
					System.out.println("");
				}

			default:
				break;
			}
		} while (choice > 0 && choice < 3);
	}

}
