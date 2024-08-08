package baitap03;

import java.util.ArrayList;

public class Student extends Person {
	private String id;
	private ArrayList<Course> courses;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, String address, String id) {
		super(name, age, address);
		this.id = id;
		this.courses = new ArrayList<Course>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public void displayInfo() {
		System.out.printf("|%-12s|%4d|%-12s|%6s|%-12s|", super.getName(), super.getAge(), super.getAddress(), this.id,
				getCourse());

	}

	public void enroll(Course course) {
		courses.add(course);
	}

	public String getCourse() {
		for (Course course : courses) {
			return course.getCourseName();
		}
		return null;
	}
	
	

}
