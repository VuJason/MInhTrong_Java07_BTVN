package baitap01;

public class PartTimeEmployee extends Employee {
	private String hours;
	private String hourlyrate;

	public PartTimeEmployee() {
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(String hours, String hourlyrate) {
		super();
		this.hours = hours;
		this.hourlyrate = hourlyrate;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getHourlyrate() {
		return hourlyrate;
	}

	public void setHourlyrate(String hourlyrate) {
		this.hourlyrate = hourlyrate;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		super.displayInfo();
		System.out.println("Hours: " + this.hours + " Hourly Rate: " + this.hourlyrate);

	}

	@Override
	public void calculate_salary() {
		// TODO Auto-generated method stub
		super.calculate_salary();
	}
}
