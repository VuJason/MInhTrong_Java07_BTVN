package data;

import java.util.ArrayList;
import java.util.List;

public class Staff extends Employee {
	private List<Manager> managerList;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String id, String fullName, String telNum, int workDay) {
		super(id, fullName, telNum, workDay, 100);
		this.managerList = new ArrayList<>();
	}

	public List<Manager> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<Manager> managerList) {
		this.managerList = managerList;
	}

	public void assignToManager(Manager manager) {
		managerList.add(manager);
	}

	@Override
	public double calculateSalary() {
		return getSalaryPerDay() * getWorkDay();
	}

	@Override
	public void displayInfo() {
		System.out.printf("|%-4d|%-6s|%-15s|%-15s|%-10d|%-4.1f|%-10s|%-15s|%-15s|%-15s|",index, super.getId(), super.getFullName(), super.getTelNum(),
				super.getWorkDay(), calculateSalary(),"Staff","", getManager(), "");
		System.out.println("");
		index++;
	}

	public String getManager() {
		for (Manager manager : managerList) {
			return manager.getFullName();
		}
		
		return null;
	}
	
	public void removeManager() {
		managerList.removeAll(managerList);
	}
}
