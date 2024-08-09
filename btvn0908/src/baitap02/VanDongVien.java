package baitap02;

import java.util.Scanner;

public class VanDongVien {
	private String hoTen;
	private int tuoi;
	private String monThiDau;
	private double canNang;
	private double chieuCao;

	public VanDongVien() {
		// TODO Auto-generated constructor stub
	}

	public VanDongVien(String hoTen, int tuoi, String monThiDau, double canNang, double chieuCao) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.monThiDau = monThiDau;
		this.canNang = canNang;
		this.chieuCao = chieuCao;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getMonThiDau() {
		return monThiDau;
	}

	public void setMonThiDau(String monThiDau) {
		this.monThiDau = monThiDau;
	}

	public double getCanNang() {
		return canNang;
	}

	public void setCanNang(double canNang) {
		this.canNang = canNang;
	}

	public double getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(double chieuCao) {
		this.chieuCao = chieuCao;
	}

	public void displayInfo() {
		System.out.printf("|%-12s|%2d|%-12s|%4.1fkg|%4.1fcm|", this.hoTen, this.tuoi, this.monThiDau, this.canNang,
				this.chieuCao);
		System.out.println("");
	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập họ và tên: ");
		this.hoTen = sc.nextLine();
		while (true) {
			System.out.println("Nhập tuổi: ");
			try {
				this.tuoi = Integer.parseInt(sc.nextLine());
				if (this.tuoi > 0) {
					break;
				} else {
					System.err.println("Tuổi không âm!!!");
				}
			} catch (Exception e) {
				System.err.println("Ai cho nhập chữ!!!");
			}

		}

		System.out.println("Nhập môn thi đấu: ");
		this.monThiDau = sc.nextLine();
		while (true) {
			System.out.println("Nhập cân nặng: ");
			try {
				this.canNang = Double.parseDouble(sc.nextLine());
				if (this.canNang > 0) {
					break;
				} else {
					System.err.println("Cân nặng không âm!!!");
				}
			} catch (Exception e) {
				System.err.println("Ai cho nhập chữ!!!");
			}

		}
		while (true) {
			System.out.println("Nhập chiều cao: ");
			try {
				this.chieuCao = Double.parseDouble(sc.nextLine());
				if (this.chieuCao > 0) {
					break;
				} else {
					System.err.println("Chiều cao không âm!!!");
				}
			} catch (Exception e) {
				System.err.println("Ai cho nhập chữ!!!");
			}

		}

	}

	public boolean lonHon(VanDongVien vdvKhac) {
		if (this.chieuCao > vdvKhac.chieuCao) {
			return true;
		} else if (this.chieuCao == vdvKhac.chieuCao) {
			return this.canNang > vdvKhac.canNang;
		}

		return false;
	}
}
