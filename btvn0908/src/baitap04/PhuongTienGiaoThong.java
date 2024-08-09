package baitap04;

import java.util.Scanner;

public class PhuongTienGiaoThong {
	private String hangSanXuat;
	private String tenPhuongTien;
	private int namSanXuat;
	private double vanTocToiDa;
	protected Scanner sc = new Scanner(System.in);

	public PhuongTienGiaoThong() {
		// TODO Auto-generated constructor stub
	}

	public PhuongTienGiaoThong(String hangSanXuat, String tenPhuongTien, int namSanXuat, double vanTocToiDa) {
		this.hangSanXuat = hangSanXuat;
		this.tenPhuongTien = tenPhuongTien;
		this.namSanXuat = namSanXuat;
		this.vanTocToiDa = vanTocToiDa;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public String getTenPhuongTien() {
		return tenPhuongTien;
	}

	public void setTenPhuongTien(String tenPhuongTien) {
		this.tenPhuongTien = tenPhuongTien;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public double getVanTocToiDa() {
		return vanTocToiDa;
	}

	public void setVanTocToiDa(double vanTocToiDa) {
		this.vanTocToiDa = vanTocToiDa;
	}

	public void displayInfo() {
		System.out.printf("|Hãng sản xuất: %-15s|Tên phương tiện: %-12s|Năm sản xuất: %4d|Vận tốc tối đa:%4.1fKM|",
				this.hangSanXuat, this.tenPhuongTien, this.namSanXuat, this.vanTocToiDa);
		System.out.println("");
	}

	public void inputData() {
		System.out.println("Nhập hãng sản xuất: ");
		this.hangSanXuat = sc.nextLine();
		System.out.println("Nhập tên phương tiện: ");
		this.tenPhuongTien = sc.nextLine();
		while (true) {
			System.out.println("Nhập năm sản xuất: ");
			try {
				this.namSanXuat = Integer.parseInt(sc.nextLine());
				if (this.namSanXuat > 0) {
					break;
				} else {
					System.err.println("Năm không âm!!!");
				}
			} catch (Exception e) {
				System.err.println("Ai cho nhập chữ!!!");
			}

		}

		while (true) {
			System.out.println("Nhập vận tốc tối đa: ");
			try {
				this.vanTocToiDa = Double.parseDouble(sc.nextLine());
				if (this.vanTocToiDa > 0) {
					break;
				} else {
					System.err.println("Vận tốc không âm!!!");
				}
			} catch (Exception e) {
				System.err.println("Ai cho nhập chữ!!!");
			}

		}

	}

}
