package baitap5;

import java.util.Scanner;

public class ThietBiDien {
	private String thuongHieu;
	private double congSuat;
	private String chucNang;

	public ThietBiDien() {
		// TODO Auto-generated constructor stub
	}

	public ThietBiDien(String thuongHieu, double congSuat, String chucNang) {
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
		this.chucNang = chucNang;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) {
		this.congSuat = congSuat;
	}

	public String getChucNang() {
		return chucNang;
	}

	public void setChucNang(String chucNang) {
		this.chucNang = chucNang;
	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên hãng: ");
		this.thuongHieu = sc.nextLine();
		while (true) {
			System.out.println("Nhập công suất tiêu thụ: ");
			try {
				this.congSuat = Double.parseDouble(sc.nextLine());
				if (this.congSuat > 0) {
					break;
				} else {
					System.out.println("Công suát tiêu thụ không âm!!!");
				}
			} catch (Exception e) {
				System.out.println("Invalid format!!!");
			}

		}

		System.out.println("Nhập chức năng sản phẩm: ");
		this.chucNang = sc.nextLine();

	}

	public void showInfo() {
		System.out.printf("|%-12s|%4.1fW|%-12s|", this.thuongHieu, this.congSuat, this.chucNang);
		System.out.println("");
	}

}
