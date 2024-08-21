package data;

public class Director extends Employee {
	private double share;

	public Director() {
		// TODO Auto-generated constructor stub
	}
	
	public Director(String id, String fullName, String telNum, int workDay, double share) {
		super(id, fullName, telNum, workDay, 300);
		this.share = share;
	}

	public double getShare() {
		return share;
	}

	public void setShare(double share) {
		this.share = share;
	}
	
	

	@Override
	public double calculateSalary() {
		return getSalaryPerDay()*getWorkDay();
	}

	@Override
	public void displayInfo() {
		System.out.printf("|%-4d|%-6s|%-15s|%-15s|%-10d|%-4.1f|%-10s|",index, super.getId(), super.getFullName(), super.getTelNum(),
				super.getWorkDay(), calculateSalary(),"Director");
		System.out.println("");
		index++;
	}
	
	
	
	
}
