package baitap02;

import java.util.Scanner;

public class Student {
	String name;
	String id;
	double math;
	double physic;
	double chemistry;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String id, double math, double physic, double chemistry) {
		super();
		this.name = name;
		this.id = id;
		this.math = math;
		this.physic = physic;
		this.chemistry = chemistry;
	}

	String classify() {
		if (average() >= 9 && average() <= 10) {
			return "Xuất sắc";
		} else if (average() < 9 && average() >= 8) {
			return "Giỏi";
		} else if (average() < 8 && average() >= 5) {
			return "Khá";
		} else {
			return "Yếu";
		}
	}

	double average() {
		return (this.math + this.physic + this.chemistry) / 3;
	}

	void showProfile() {
		System.out.printf("|%-10s|%6s|%3.1f|%3.1f|%3.1f|%3.1f|%8s|", this.name, this.id, this.math, this.physic, this.chemistry, average(), classify());
		System.out.println("");
	}
}
