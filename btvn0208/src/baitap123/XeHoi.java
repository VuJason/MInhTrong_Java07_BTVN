package baitap123;

import java.util.Scanner;

public class XeHoi {
	String brand;
	String manufacturer;
	String color;
	int year;
	
	public XeHoi() {
		// TODO Auto-generated constructor stub
	}
	
	public XeHoi(String brand, String manufacturer, String color, int year) {
		this.brand = brand;
		this.manufacturer = manufacturer;
		this.color = color;
		this.year = year;
	}
	
	void showInformation() {
		System.out.println("Brand:"+this.brand+" Manufacturer:"+this.manufacturer+" Color:"+this.color+" Year:" +this.year);
	}
	
	void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input brand:");
		this.brand = sc.nextLine();
		System.out.println("Input manufacturer:");
		this.manufacturer = sc.nextLine();
		System.out.println("Input color:");
		this.color = sc.nextLine();
		System.out.println("Input year of manufacture:");
		this.year = sc.nextInt();
	}
	
}
