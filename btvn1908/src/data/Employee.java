package data;

public abstract class Employee {
	private String id;
	private String fullName;
	private String telNum;
	private int workDay;
	private double salaryPerDay;
	protected int index = 1;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String fullName, String telNum, int workDay, double salaryPerDay) {
		this.id = id;
		this.fullName = fullName;
		this.telNum = telNum;
		this.workDay = workDay;
		this.salaryPerDay = salaryPerDay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

	public double getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(double salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}

	public abstract double calculateSalary();

	public double getSalary() {
		return calculateSalary();
	}

	public void displayInfo() {
		System.out.printf("|%8s|%-15s|%10s|%4d|%4.1f|", this.id, this.fullName, this.telNum, this.workDay,
				this.salaryPerDay);
		System.out.println("");
	}

}
