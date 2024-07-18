package baitap02;

public class bai3 {
	public static void main(String[] args) {
		countWhile();
		System.out.println("");
		countFor();
	}
	
	
	public static void countWhile() {
		int i = 0;
		int count = 0;
		while (i < 1000) {
			if(i%3 == 0) {
				count++;
			}
			i++;
		}
		System.out.print("Có " +count+ " số chia hết cho 3 từ 0-1000");
	}
	
	public static void countFor() {
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			if(i%3 == 0) {
				count++;
			}
		}
		System.out.println("Có " +count+ " số chia hết cho 3 từ 0-1000");
	}
}
