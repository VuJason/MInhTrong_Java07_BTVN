package baitap01;

import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3];
		int[] yob = new int[3];
		String[] gender = new String[3];

		for (int i = 0; i < name.length; i++) {

			System.out.println("Danh sách cán bộ #" + (i + 1) + "/3");
			System.out.print("Tên: ");
			name[i] = sc.nextLine();
			do {
				System.out.print("Năm sinh: ");
				yob[i] = Integer.parseInt(sc.nextLine());
				if (yob[i] < 0) {
					System.out.println("Năm sinh không hợp lệ. Vui lòng nhập lại.");
				}
			} while (yob[i] < 0);
			do {
				System.out.print("Giới tính: ");
				gender[i] = sc.nextLine();
				if (gender[i].equalsIgnoreCase("Nam") || gender[i].equalsIgnoreCase("Nữ")) {
					break;
				} else {
					System.out.println("Vui lòng nhập đúng giới tính Nam/Nữ !!!");
				}
			} while (true);
		}

		for (int i = 0; i < gender.length; i++) {
			for (int j = i + 1; j < gender.length; j++) {
				if (yob[i] > yob[j]) {
					String t = name[i];
					name[i] = name[j];
					name[j] = t;

					int tempYob = yob[i];
					yob[i] = yob[j];
					yob[j] = tempYob;

					String tempGen = gender[i];
					gender[i] = gender[j];
					gender[j] = tempGen;

				}
			}
		}

		int youngestMaleIndex = 0;
		for (int i = 0; i < gender.length; i++) {
			for (int j = i + 1; j < gender.length; j++) {
				if (gender[i].equalsIgnoreCase("Nam") && gender[j].equalsIgnoreCase("Nam")) {
					youngestMaleIndex = i;
				} else if (gender[i].equalsIgnoreCase("Nam") && gender[j].equalsIgnoreCase("Nữ")) {
					youngestMaleIndex = i;
				} else if (gender[i].equalsIgnoreCase("Nữ") && gender[j].equalsIgnoreCase("Nam")) {
					youngestMaleIndex = j;
				}

			}
		}
		if (gender[youngestMaleIndex].equalsIgnoreCase("Nam")) {
			System.out.println("Cán bộ Nam trẻ nhất: " + name[youngestMaleIndex]);
		} else {
			System.out.println("Không có cán bộ Nam");
		}

	}
}
