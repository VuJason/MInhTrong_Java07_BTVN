package baitap01;

import java.util.Scanner;

public class PhanSo {
	private double tuSo;
	private double mauSo;

	public PhanSo() {
		// TODO Auto-generated constructor stub
	}

	public double getTuSo() {
		return tuSo;
	}

	public void setTuSo(double tuSo) {
		this.tuSo = tuSo;
	}

	public double getMauSo() {
		return mauSo;
	}

	public void setMauSo(double mauSo) {
		this.mauSo = mauSo;
	}

	public void displayInfo(double result, String op) {
		System.out.printf("|Phép tính: %s|Tử số: %4.1f|Mẫu số: %4.1f|Kết quả:%4.1f|", op, this.tuSo, this.mauSo,
				result);
		System.out.println("");
	}

	public double Cong(double a, double b) {
		double sum = a + b;
		return sum;
	}

	public double Tru(double a, double b) {
		double sum = a - b;
		return sum;
	}

	public double Nhan(double a, double b) {
		double mul = a * b;
		return mul;
	}

	public double Chia(double a, double b) {
		double divide = a / b;
		if (b == 0) {
			System.err.println("không chia được cho 0");

		}
		return divide;

	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Nhập tử số: ");
				this.tuSo = Double.parseDouble(sc.nextLine());
				System.out.println("Nhập mẫu số: ");
				this.mauSo = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.err.println("Ai cho nhập chữ!!!");
			}
		}
		
		
	}
}
