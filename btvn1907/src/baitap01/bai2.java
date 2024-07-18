package baitap01;

public class bai2 {
	public static void main(String[] args) {
		int n =0 , sum = 0;
		
		while (sum < 10000) {
			n++;
			sum+=n;
		}
		System.out.println("Số nguyên dương n nhỏ nhất là:" +n);
	}
}
