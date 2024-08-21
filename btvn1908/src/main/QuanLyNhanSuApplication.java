package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import data.Company;
import data.Director;
import data.Employee;
import data.Manager;
import data.Staff;

public class QuanLyNhanSuApplication {
	private static Company comp;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			System.out.println("Vui lòng nhập lựa chọn của bạn: ");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				inputCompany();

				break;
			case 2:
				if (comp != null) {
					assign();
				} else {
					System.err.println("Company not found!!");
				}

				break;
			case 3:
				if (comp != null) {
					int option;
					do {
						System.out.println("1. Add Employee");
						System.out.println("2. Remove Employee");
						System.out.println("3. Back");
						option = Integer.parseInt(sc.nextLine());
						if (option == 1) {
							addEmployee();
						} else if (option == 2) {
							removeEmployee();
						}
					} while (option != 3);

				} else {
					System.err.println("Company not found!!");
				}

				break;
			case 4:
				if (comp != null) {
					displayInfo();
				} else {
					System.err.println("Company not found!!");
				}

				break;
			case 5:
				if (comp != null) {
					calculateAndDisplayTotalSalary();
				} else {
					System.err.println("Company not found!!");
				}
				break;
			case 6:
				if (comp != null) {
					findHighestPaidNormalEmployee();
				} else {
					System.err.println("Company not found!!");
				}

				break;
			case 7:
				if (comp != null) {
					findManagerWithMostSubordinates();
				} else {
					System.err.println("Company not found!!");
				}
				break;
			case 8:
				if (comp != null) {
					sortEmployeesByName();
				} else {
					System.err.println("Company not found!!");
				}
				break;
			case 9:
				if (comp != null) {
					sortEmployeesBySalaryDesc();
				} else {
					System.err.println("Company not found!!");
				}
				break;
			case 10:
				if (comp != null) {
					findDirectorWithMostShares();
				} else {
					System.err.println("Company not found!!");
				}
				break;
			case 11:
				if (comp != null) {
					calculateAndDisplayDirectorIncome();
				} else {
					System.err.println("Company not found!!");
				}
				break;

			}
		} while (choice != 12);
	}

	public static void printMenu() {
		System.out.println("1. Nhập thông tin công ty");
		System.out.println("2. Phân bố nhân viên vào Trường phòng");
		System.out.println("3. Thêm, xóa thông tin một nhân sự");
		System.out.println("4. Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("5. Tính vầ xuất tổng lương cho toàn công ty");
		System.out.println("6. Tìm nhân viên thường có lương cao nhất");
		System.out.println("7. Tìm trưởng phòng có sos lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("8. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("8. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("10. Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("11. Tính và xuất tổng thu nhập của từng giám đóc");
		System.out.println("12. Thoát");
	}

//	Input Company Information
	public static void inputCompany() {
		String name, taxCode;
		double monthlyRevenue;
		System.out.println("Nhập tên công ty: ");
		name = sc.nextLine();
		System.out.println("Nhập mã số thuế: ");
		taxCode = sc.nextLine();
		System.out.println("Nhập doanh thu tháng: ");
		monthlyRevenue = Double.parseDouble(sc.nextLine());

		comp = new Company(name, taxCode, monthlyRevenue);

		System.out.println("Add successfully!!");

	}

	// addEmployee
	public static void addEmployee() {
		String id, fullName, telNum;
		int workDay, type;
		double share;
		do {
			System.out.println("1. Add Staff");
			System.out.println("2. Add Mananger");
			System.out.println("3. Add Director");
			System.out.println("4. Back");
			System.out.println("Please, choose option:");
			type = Integer.parseInt(sc.nextLine());

			switch (type) {
			case 1:
				System.out.println("Input id: ");
				id = sc.nextLine();
				System.out.println("Input fullname: ");
				fullName = sc.nextLine();
				System.out.println("Input phone number: ");
				telNum = sc.nextLine();
				System.out.println("Input workday: ");
				workDay = Integer.parseInt(sc.nextLine());
				comp.addEmployee(new Staff(id, fullName, telNum, workDay));
				break;

			case 2:
				System.out.println("Input id: ");
				id = sc.nextLine();
				System.out.println("Input fullname: ");
				fullName = sc.nextLine();
				System.out.println("Input phone number: ");
				telNum = sc.nextLine();
				System.out.println("Input workday: ");
				workDay = Integer.parseInt(sc.nextLine());
				comp.addEmployee(new Manager(id, fullName, telNum, workDay));
				break;
			case 3:
				System.out.println("Input id: ");
				id = sc.nextLine();
				System.out.println("Input fullname: ");
				fullName = sc.nextLine();
				System.out.println("Input phone number: ");
				telNum = sc.nextLine();
				System.out.println("Input workday: ");
				workDay = Integer.parseInt(sc.nextLine());
				System.out.println("Input share: ");
				share = Double.parseDouble(sc.nextLine());
				comp.addEmployee(new Director(id, fullName, telNum, workDay, share));
				break;

			}
		} while (type != 4);

	}

//	displayInfo

	public static void displayInfo() {
		System.out.printf("%-4s %-6s %-15s %-15s %-10s %-6s %-10s %-15s %-15s %-15s\n", "Index", "ID", "FullName",
				"Phone Number", "WorkDay", "Salary", "Role", "Share(Manager)", "Superior(Staff)",
				"Subordinates(Manager)");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Staff) {

				emp.displayInfo();

			}

			if (emp instanceof Manager) {

				emp.displayInfo();

			}

			if (emp instanceof Director) {

				emp.displayInfo();
			}
		}
	}

	public static void removeEmployee() {
		System.out.println("Enter employee ID to remove:");
		String id = sc.nextLine();
		Employee emp = findEmployeeByID(id);
		if (emp != null) {
			if (emp instanceof Staff) {
				for (Manager manager : ((Staff) emp).getManagerList()) {
					manager.removeStaff((Staff) emp);
				}
			} else if (emp instanceof Manager) {

				for (Staff staff : ((Manager) emp).getStaffList()) {
					staff.assignToManager(null);
				}
				((Manager) emp).getStaffList().clear();
			}
			comp.removeEmployee(emp);
			System.out.println("Employee removed successfully!");
		} else {
			System.err.println("Employee not found!");
		}
	}

	public static void assign() {
		System.out.println("Staff List:");
		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Staff) {
				emp.displayInfo();
			}
		}
		System.out.println("Enter staff id you want to assign to manger: ");
		String staffCheck = sc.nextLine();
		Employee staff = findStaffByID(staffCheck);
		if (staff != null) {
			System.out.println("Manager List:");
			for (Employee emp : comp.getEmployeeList()) {
				if (emp instanceof Manager) {
					emp.displayInfo();

				}
			}
			System.out.println("Enter manager id to assign staff: ");
			String managerCheck = sc.nextLine();
			Employee manager = findManagerByID(managerCheck);
			if (manager != null && manager instanceof Manager) {
				if (staff instanceof Staff) {
					if (((Staff) staff).getManager() != null) {
						System.err.println("This staff was assigned!!!");
					} else {
						((Staff) staff).assignToManager((Manager) manager);
						((Manager) manager).assignEmployee((Staff) staff);
						System.out.println("Assigned successfully!!");
					}

				}
			} else {
				System.err.println("Manager not found!!");
			}
		} else {
			System.err.println("Staff not found!!!");
		}
	}

	public static Employee findEmployeeByID(String id) {
		for (Employee emp : comp.getEmployeeList()) {
			if (emp.getId().equals(id)) {
				return emp;
			}
		}
		return null;
	}

	public static Employee findStaffByID(String id) {
		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Staff) {
				if (emp.getId().equals(id)) {
					return emp;
				}

			}
		}
		return null;
	}

	public static Employee findManagerByID(String id) {
		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Manager) {
				if (emp.getId().equals(id)) {
					return emp;
				}

			}
		}
		return null;
	}

	public static void calculateAndDisplayTotalSalary() {
		double totalSalary = 0;
		for (Employee emp : comp.getEmployeeList()) {
			totalSalary += emp.calculateSalary();
		}
		System.out.printf("Total salary for the company: %4.1f\n", totalSalary);
	}

	public static void findHighestPaidNormalEmployee() {
		Staff highestPaidStaff = null;
		double maxSalary = 0;

		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Staff) {
				Staff staff = (Staff) emp;
				double salary = staff.calculateSalary();
				if (salary > maxSalary) {
					maxSalary = salary;
					highestPaidStaff = staff;
				}
			}
		}

		if (highestPaidStaff != null) {
			highestPaidStaff.displayInfo();
		} else {
			System.err.println("No normal employees found.");
		}
	}

	public static void findManagerWithMostSubordinates() {
		Manager topManager = null;
		int maxSubordinates = 0;

		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Manager) {
				Manager manager = (Manager) emp;
				int numSubordinates = manager.getStaffList().size();
				if (numSubordinates > maxSubordinates) {
					maxSubordinates = numSubordinates;
					topManager = manager;
				}
			}
		}

		if (topManager != null) {
			topManager.displayInfo();
		} else {
			System.err.println("No managers found.");
		}
	}

	public static void sortEmployeesByName() {
		List<Employee> employeeList = comp.getEmployeeList();
		employeeList.sort((e1, e2) -> e1.getFullName().compareToIgnoreCase(e2.getFullName()));

		System.out.println("Employees sorted by name:");
		displayInfo();
	}

	public static void sortEmployeesBySalaryDesc() {
		List<Employee> employeeList = comp.getEmployeeList();
		employeeList.sort((e1, e2) -> Double.compare(e2.calculateSalary(), e1.calculateSalary()));

		System.out.println("Employees sorted by salary (descending):");
		displayInfo();
	}

	public static void findDirectorWithMostShares() {
		Director topDirector = null;
		double maxShares = 0;

		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Director) {
				Director director = (Director) emp;
				double shares = director.getShare();
				if (shares > maxShares) {
					maxShares = shares;
					topDirector = director;
				}
			}
		}

		if (topDirector != null) {
			topDirector.displayInfo();
		} else {
			System.err.println("No directors found.");
		}
	}

	public static void calculateAndDisplayDirectorIncome() {
		double totalCompanyRevenue = comp.getMonthlyRevenue();
		double totalSalary = 0;

		for (Employee emp : comp.getEmployeeList()) {
			totalSalary += emp.calculateSalary();
		}

		for (Employee emp : comp.getEmployeeList()) {
			if (emp instanceof Director) {
				Director director = (Director) emp;
				double salary = director.calculateSalary();
				double share = director.getShare();
				double income = salary + (share / 100.0) * (totalCompanyRevenue - totalSalary);
				System.out.printf("Director ID: %s, Total Income: %.2f\n", director.getId(), income);
			}
		}
	}

}
