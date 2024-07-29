package baitap02;

import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		while (true) {
			System.out.println("Nhập số sinh viên số sinh viên bạn muốn điền thông tin: ");
			n = Integer.parseInt(sc.nextLine());

			if (n > 0) {
				break;
			} else {
				System.out.println("Mảng không được âm!!");
			}
		}

		String[] tenSinhVien = new String[n];
		String[] maSV = new String[n];
		double[] diemToan = new double[n];
		double[] diemLy = new double[n];
		double[] diemHoa = new double[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập sinh viên #" + (i + 1) + "/" + n);
			System.out.println("Tên: ");
			tenSinhVien[i] = sc.nextLine();
			System.out.println("MSSV: ");
			maSV[i] = sc.nextLine();
			while (true) {
				System.out.println("Điểm Toán: ");
				diemToan[i] = Double.parseDouble(sc.nextLine());
				if (diemToan[i] > 0 && diemToan[i] <=10) {
					break;
				} else {
					System.out.println("Điểm số không âm!!");
				}
			}
			while (true) {
				System.out.println("Điểm Lý: ");
				diemLy[i] = Double.parseDouble(sc.nextLine());
				if (diemLy[i] > 0 && diemLy[i] <=10) {
					break;
				} else {
					System.out.println("Điểm số không âm!!");
				}
			}
			while (true) {
				System.out.println("Điểm Hóa: ");
				diemHoa[i] = Double.parseDouble(sc.nextLine());
				if (diemHoa[i] > 0 && diemHoa[i] <=10) {
					break;
				} else {
					System.out.println("Điểm số không âm!!");
				}
			}

		}
		
		double[] avg = new double[n];
		for (int i = 0; i < diemHoa.length; i++) {
			avg[i] = (diemToan[i] + diemLy[i] + diemHoa[i]) / 3;
			System.out.println("Điểm trung bình của sinh viên #" + (i+1) + "/" + n + ": " + avg[i]);
		}
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] >= 9 && avg[i] <= 10) {
				System.out.println(tenSinhVien[i] + " xếp loại Xuất sắc");
			} else if (avg[i] < 9 && avg[i] >= 8) {
				System.out.println(tenSinhVien[i] + " xếp loại Giỏi");
			} else if (avg[i] < 8 && avg[i] >= 5) {
				System.out.println(tenSinhVien[i] + " xếp loại Khá");
			} else {
				System.out.println(tenSinhVien[i] + " xếp loại Yếu");
			}
		}

	}

	
}
