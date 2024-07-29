package baitap02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2 {
	public static List<Student> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1. Add Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Display Student with Highest Average Score");
			System.out.println("4. Display All Weak Students");
			System.out.println("5. Search Student by Name");
			System.out.println("6. Search Student by ID");
			System.out.println("7. Delete Student by ID");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				inputStudent();
				break;
			case 2:
				displayAllStudent();
				break;
			case 3:
				displayTopStudent();
				break;
			case 4:
				displayWeakStudent();
				break;
			case 5:
				searchByName();
				break;
			case 6:
				searchByID();
				break;
			case 7:
				deleteById();
				break;
			case 8:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		} while (choice != 8);
	}
	
	public static void inputStudent() {
		Scanner sc = new Scanner(System.in);
		String name;
		String id;
		double math, physic, chemistry;

		

		System.out.println("Input student name: ");
		name = sc.nextLine();
		System.out.println("Input student id: ");
		id = sc.nextLine();
		while (true) {
			System.out.println("Input student math score: ");
			math = Double.parseDouble(sc.nextLine());
			if (math > 0 && math <= 10) {
				break;
			} else {
				System.out.println("Điểm số không âm");
			}
		}
		while (true) {
			System.out.println("Input student physic score: ");
			physic = Double.parseDouble(sc.nextLine());
			if (physic > 0 && physic <= 10) {
				break;
			} else {
				System.out.println("Điểm số không âm");
			}

		}

		while (true) {
			System.out.println("Input student chemistry score: ");
			chemistry = Double.parseDouble(sc.nextLine());
			if (chemistry > 0 && chemistry <= 10) {
				break;
			} else {
				System.out.println("Điểm số không âm");
			}
		}
		
		Student student = new Student(name, id, math, physic, chemistry);
		list.add(student);

	}
	
	public static void displayAllStudent() {
		for (Student student : list) {
			student.showProfile();
		}
	}
	
	public static void displayTopStudent() {
		
		Student topStudent = list.get(0);
		for (Student student : list) {
			if(student.average() > topStudent.average()) {
				topStudent = student;
			}
		}
		
		topStudent.showProfile();
	}
	
	public static void displayWeakStudent() {
		if(list.isEmpty()) {
			System.out.println("No student in list");
			return;
		}
		for (Student student : list) {
			if(student.average() <5) {
				student.showProfile();
			}
		}
	}
	
	public static void searchByName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input student's name you want to find:");
		String searchName = sc.nextLine();
		for (Student student : list) {
			if(searchName == student.name) {
				student.showProfile();
			}
		}
	}
	
	public static void searchByID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input student's name you want to find:");
		String searchId = sc.nextLine();
		for (Student student : list) {
			if(searchId == student.id) {
				student.showProfile();
			}
		}
	}
	
	public static void deleteById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input student's name you want to find:");
		String deletedId = sc.nextLine();
		for (Student student : list) {
			if(deletedId == student.id) {
				list.remove(student);
			}
		}
	}
	
}



