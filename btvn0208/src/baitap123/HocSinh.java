package baitap123;

import java.util.Scanner;

public class HocSinh {
	String name;
	int age;
	double math;
	double physic;
	double chemistry;

	public HocSinh() {
		// TODO Auto-generated constructor stub
	}
	public HocSinh(String name, int age, double math, double physic, double chemistry) {
		super();
		this.name = name;
		this.age = age;
		this.math = math;
		this.physic = physic;
		this.chemistry = chemistry;
	}

	void exportInformation() {
		System.out.println("Name:" + this.name + " Age:" + this.age);
	}

	void caculateAverage() {
		double avg = (math + physic + chemistry) / 3;
		System.out.printf("Avg: %.2f",avg);
	}

	void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your name:");
		this.name = sc.nextLine();
		System.out.println("Input your age: ");
		this.age = sc.nextInt();
		System.out.println("Input math score: ");
		this.math = sc.nextDouble();
		System.out.println("Input physic score: ");
		this.physic = sc.nextDouble();
		System.out.println("Input chemistry score: ");
		this.chemistry = sc.nextDouble();
	}

}
