package baitap01;

public class DemoApplication {
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setName("Nguyen Van A");
		emp1.setAge(12);
		emp1.setSalary(5000);
		emp1.displayInfo();
		
		FullTimeEmployee emp2 = new FullTimeEmployee();
		emp2.setName("Nguyen Van B");
		emp2.setAge(15);
		emp2.setSalary(30000);
		emp2.setBenefits("Thich gi duoc nay");
		emp2.displayInfo();
	}
}
