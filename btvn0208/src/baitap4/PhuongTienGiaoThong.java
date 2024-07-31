package baitap4;

import java.util.Scanner;

public class PhuongTienGiaoThong {
	private String manufacturer;
	private String color;
	private int year;
	
	
	public PhuongTienGiaoThong() {
		// TODO Auto-generated constructor stub
	}

	public PhuongTienGiaoThong(String manufacturer, String color, int year) {
		this.manufacturer = manufacturer;
		this.color = color;
		this.year = year;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập hãng sản xuất: ");
		this.manufacturer = sc.nextLine();
		System.out.println("Nhập màu xe: ");
		this.color = sc.nextLine();
		while (true) {
			System.out.println("Nhập năm sản xuất: ");
			this.year = Integer.parseInt(sc.nextLine());
			if(this.year > 0) {
				System.out.println("Không có năm âm!!!");
			}
		}
		
		
	}

	public void showInfo() {
		System.out.printf("|%-15s|%-15s|%4d|", this.manufacturer, this.color, this.year);
		System.out.println("");
	}

}
