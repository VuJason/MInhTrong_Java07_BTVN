package baitap01;

public class FullTimeEmployee extends Employee {
	private String benefits;

	public FullTimeEmployee() {
		// TODO Auto-generated constructor stub
	}

	public FullTimeEmployee(String benefits) {
		super();
		this.benefits = benefits;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		super.displayInfo();
		System.out.println("Benefits: " + this.benefits);
	}

	@Override
	public void calculate_salary() {
		// TODO Auto-generated method stub
		super.calculate_salary();
	}
}
