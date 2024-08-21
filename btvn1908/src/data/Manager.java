package data;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	private List<Staff> staffList;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String id, String fullName, String telNum, int workDay) {
		super(id, fullName, telNum, workDay, 200);
		this.staffList = new ArrayList<>();
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	@Override
	public double calculateSalary() {
		return getSalaryPerDay() * getWorkDay() + 100 * staffList.size();
	}

	public void assignEmployee(Staff staff) {
		staffList.add(staff);
	}

	@Override
	public void displayInfo() {
		StringBuilder staffAssignedInfo = new StringBuilder();
		for (Staff staff : staffList) {
			staffAssignedInfo.append(staff.getFullName()).append(", ");
		}
		String staffAssignedString = staffList.isEmpty() ? null
				: staffAssignedInfo.substring(0, staffAssignedInfo.length() - 2);
		System.out.printf("|%-4d|%-6s|%-15s|%-15s|%-10d|%-4.1f|%-10s|%-15s|%-15s|%-15s|", index, super.getId(),
				super.getFullName(), super.getTelNum(), super.getWorkDay(), calculateSalary(), "Manager", "", "",
				staffAssignedString);
		System.out.println("");
		index++;
	}
	
	public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

}
