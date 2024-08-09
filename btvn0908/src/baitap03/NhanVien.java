package baitap03;

import java.util.Scanner;

public abstract class NhanVien {
	private String hoTen;
	private String ngaySinh;
	protected Scanner sc = new Scanner(System.in);

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String hoTen, String ngaySinh) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;

	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void displayInfo() {
		System.out.printf("|%-12s|%-12s|", this.hoTen, this.ngaySinh);
		System.out.println("");
	}

	public void inputData() {

		System.out.println("Nhập họ và tên: ");
		this.hoTen = sc.nextLine();
		System.out.println("Nhập ngày tháng năm sinh: ");
		this.ngaySinh = sc.nextLine();

	}

}
