package baitap02;

public class bai1 {
	public static void main(String[] args) {
		printWhile();
		System.out.println("");
		printFor();
	}
	
	
	public static void printWhile() {
		int n = 0;
		while (n < 100) {
			if(n%2 == 0) {
				System.out.print(n+" ");
			}
			n++;
		}
	}
	
	public static void printFor() {
		for (int i = 0; i < 100; i++) {
			if(i%2 == 0) {
				System.out.print(i+" ");
			}
		}
	}
}
