package baitap02;

import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double duongDi;
		int choice, thoiGian;
		System.out.println("1. GrabCar");
		System.out.println("2. Grab SUV");
		System.out.println("3. GrabBlack");
		System.out.print("Booking car service to move: ");
		choice = sc.nextInt();
		switch (choice) {
		case 1:

			while (true) {
				System.out.println("Nhập số km bạn muốn đi: ");
				duongDi = sc.nextDouble();
				if (duongDi > 0) {
					break;
				} else {
					System.out.println("Đường đi không có âm !!!");
				}
			}
			while (true) {
				System.out.println("Nhập thời gian chờ: ");
				thoiGian = sc.nextInt();
				if (thoiGian > 0) {
					break;
				} else {
					System.out.println("Thời gian không có âm !!!");
				}
			}

			tinhTienCar(duongDi, thoiGian);
			break;
		case 2:
			while (true) {
				System.out.println("Nhập số km bạn muốn đi: ");
				duongDi = sc.nextDouble();
				if (duongDi > 0) {
					break;
				} else {
					System.out.println("Đường đi không có âm !!!");
				}
			}
			while (true) {
				System.out.println("Nhập thời gian chờ: ");
				thoiGian = sc.nextInt();
				if (thoiGian > 0) {
					break;
				} else {
					System.out.println("Thời gian không có âm !!!");
				}
			}
			tinhTienSUV(duongDi, thoiGian);
			break;
		case 3:
			while (true) {
				System.out.println("Nhập số km bạn muốn đi: ");
				duongDi = sc.nextDouble();
				if (duongDi > 0) {
					break;
				} else {
					System.out.println("Đường đi không có âm !!!");
				}
			}
			while (true) {
				System.out.println("Nhập thời gian chờ: ");
				thoiGian = sc.nextInt();
				if (thoiGian > 0) {
					break;
				} else {
					System.out.println("Thời gian không có âm !!!");
				}
			}
			tinhTienBlack(duongDi, thoiGian);
			break;

		default:
			System.out.println("Vui lòng chọn những dịch vụ có sẵn!!");
			break;
		}

	}

	public static void tinhTienCar(double duongDi, int thoiGian) {
		double tongTien;
		double tienCho = tinhTienThoiGianCho(thoiGian);

		if (duongDi == 1.0 && thoiGian < 3) {
			tongTien = 8000;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 1 && duongDi <= 19 && thoiGian < 3) {
			tongTien = 8000 + (duongDi - 1.0) * 7500;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 19 && thoiGian < 3) {
			tongTien = 8000 + 18 * 7500 + (duongDi - 19) * 7000;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi == 1.0 && thoiGian >= 3) {
			tongTien = 8000 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 1 && duongDi <= 19 && thoiGian >= 3) {
			tongTien = 8000 + (duongDi - 1.0) * 7500 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 19 && thoiGian >= 3) {
			tongTien = 8000 + 18 * 7500 + (duongDi - 19) * 7000 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		}

	}

	public static void tinhTienSUV(double duongDi, int thoiGian) {
		double tongTien;
		double tienCho = tinhTienThoiGianSUV(thoiGian);

		if (duongDi == 1.0 && thoiGian < 3) {
			tongTien = 9000;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 1 && duongDi <= 19 && thoiGian < 3) {
			tongTien = 9000 + (duongDi - 1.0) * 8500;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 19 && thoiGian < 3) {
			tongTien = 9000 + 18 * 8500 + (duongDi - 19) * 8000;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi == 1.0 && thoiGian >= 3) {
			tongTien = 9000 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 1 && duongDi <= 19 && thoiGian >= 3) {
			tongTien = 9000 + (duongDi - 1.0) * 8500 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 19 && thoiGian >= 3) {
			tongTien = 9000 + 18 * 8500 + (duongDi - 19) * 8000 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		}

	}

	public static void tinhTienBlack(double duongDi, int thoiGian) {
		double tongTien;
		double tienCho = tinhTienThoiGianBlack(thoiGian);

		if (duongDi == 1.0 && thoiGian < 3) {
			tongTien = 10000;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 1 && duongDi <= 19 && thoiGian < 3) {
			tongTien = 10000 + (duongDi - 1.0) * 9500;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 19 && thoiGian < 3) {
			tongTien = 10000 + 18 * 9500 + (duongDi - 19) * 9000;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi == 1.0 && thoiGian >= 3) {
			tongTien = 10000 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 1 && duongDi <= 19 && thoiGian >= 3) {
			tongTien = 10000 + (duongDi - 1.0) * 9500 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		} else if (duongDi > 19 && thoiGian >= 3) {
			tongTien = 10000 + 18 * 9500 + (duongDi - 19) * 9000 + tienCho;
			System.out.println("Tổng tiền bạn cần trả: " + tongTien + "VND");
		}

	}

	public static double tinhTienThoiGianCho(int thoiGian) {

		return (thoiGian / 3.0) * 2000;

	}

	public static double tinhTienThoiGianSUV(int thoiGian) {

		return (thoiGian / 3.0) * 3000;

	}

	public static double tinhTienThoiGianBlack(int thoiGian) {

		return (thoiGian / 3.0) * 3500;

	}
}
