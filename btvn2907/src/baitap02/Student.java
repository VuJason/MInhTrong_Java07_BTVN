package baitap02;

import java.util.Scanner;

public class Student {
	private String name;
	private String id;
	private double math;
	private double physic;
	private double chemistry;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getPhysic() {
		return physic;
	}

	public void setPhysic(double physic) {
		this.physic = physic;
	}

	public double getChemistry() {
		return chemistry;
	}

	public void setChemistry(double chemistry) {
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

	public double average() {
		return (this.math + this.physic + this.chemistry) / 3;
	}

	public void showProfile() {
		System.out.printf("|%-10s|%6s|%3.1f|%3.1f|%3.1f|%3.1f|%8s|", this.name, this.id, this.math, this.physic,
				this.chemistry, average(), classify());
		System.out.println("");
	}
}
