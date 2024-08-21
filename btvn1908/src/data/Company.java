package data;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String companyName;
	private String taxCode;
	private double monthlyRevenue;
	private List<Employee> employeeList;
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String companyName, String taxCode, double monthlyRevenue) {
		this.companyName = companyName;
		this.taxCode = taxCode;
		this.monthlyRevenue = monthlyRevenue;
		this.employeeList = new ArrayList<>();
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public double getMonthlyRevenue() {
		return monthlyRevenue;
	}

	public void setMonthlyRevenue(double monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}
	
	public void addEmployee(Employee emp) {
		employeeList.add(emp);
	}
	
	public void removeEmployee(Employee emp) {
		employeeList.remove(emp);
	}
	
	
	
}
