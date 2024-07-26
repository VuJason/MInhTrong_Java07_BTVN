package baitap01;

import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			System.out.print("Nhập só từ 1-10: ");
			n = sc.nextInt();
			if(n>=1 && n<=10) {
				break;
			}else {
				System.out.println("Chỉ nhập từ 1-10");
			}
		}
		
		switch (n) {
		case 1:
			System.out.println(n+"--> Một");
			break;
		case 2:
			System.out.println(n+"--> Hai");
			break;
		case 3:
			System.out.println(n+"--> Ba");
			break;
		case 4:
			System.out.println(n+"--> Bốn");
			break;
		case 5:
			System.out.println(n+"--> Năm");
			break;
		case 6:
			System.out.println(n+"--> Sáu");
			break;
		case 7:
			System.out.println(n+"--> Bảy");
			break;
		case 8:
			System.out.println(n+"--> Tám");
			break;
		case 9:
			System.out.println(n+"--> Chín");
			break;
		case 10:
			System.out.println(n+"--> Mười");
			break;
			
		default:
			System.out.println("Vui lòng nhập số");
		}
	}
}
