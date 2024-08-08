package baitap01;

public class Employee {
	private String name;
	private int age;
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void displayInfo() {
		System.out.println("Tên: " + this.name + "Tuổi: " + this.age + "Lương: " + this.salary);
	}

	public void calculate_salary() {
		System.out.println("Lương: ");
	}

}
