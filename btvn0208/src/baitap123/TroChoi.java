package baitap123;

import java.util.Scanner;

public class TroChoi {
	private String name;
	private int turn;

	public TroChoi() {
		// TODO Auto-generated constructor stub
	}

	public TroChoi(String name, int turn) {
		this.name = name;
		this.turn = turn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void batDau() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Chào mừng bạn đến với " + this.name + ".");
		int batDau = 0;
		try {
			do {
				System.out.print("Nhấn 1 để bắt đầu trò chơi: ");
				batDau = sc.nextInt();
			} while (batDau != 1);
			System.out.println("Số lượt chơi: " + this.turn);
		} catch (Exception e) {
			System.out.println("Invalid format!!");
		}

	}

	public void ketThuc() {
		System.out.println("Trò chơi đã kết thúc!!");
	}
}
