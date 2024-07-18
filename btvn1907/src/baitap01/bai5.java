package baitap01;

import java.util.Scanner;


public class bai5 {
	public static final double LAI_SUAT = 0.08;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double von, tuonglai; 
		while (true) {
			System.out.println("Số tiền cần gửi ngân hàng với lãi suất 8%/tháng: ");
			von = sc.nextDouble();
			if(von > 0) {
				break;
			}else {
				System.out.println("Tiền không âm!!!! Vui lòng nhập lại.");
			}
		}
		while (true) {
			System.out.println("Số tiền mong muốn có trong tương lai: ");
			tuonglai = sc.nextDouble();
			if(tuonglai > 0) {
				break;
			}else {
				System.out.println("Tiền không âm!!!! Vui lòng nhập lại.");
			}
		}
		
		
		int soNamItNhat = (int)(tuonglai / (von + tienLaiTheoNam(von)));
		System.out.println("Số năm ít nhất để đạt được số tiền mong muốn: " +soNamItNhat+" năm");
	}
	
	
	public static double tienLaiTheoNam(double n) {
		double tienLai = (n*LAI_SUAT)*12;
		return tienLai;
	}
}
