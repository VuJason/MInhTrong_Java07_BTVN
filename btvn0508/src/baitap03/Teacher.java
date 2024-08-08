package baitap03;

import java.util.ArrayList;

public class Teacher extends Person {
	private String id;
	private ArrayList<Course> subjects;


	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, int age, String address, String id) {
		super(name, age, address);
		this.id = id;
		this.subjects = new ArrayList<Course>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void assign(Course subject) {
		subjects.add(subject);
	}

	public ArrayList<Course> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Course> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void displayInfo() {
		System.out.printf("|%-12s|%4d|%-12s|%8s|%-12s|", super.getName(), super.getAge(), super.getAddress(), this.id,
				this.getSubject());
		System.out.println("");
	}
	
	public String getSubject() {
		for (Course course : subjects) {
			return course.getCourseName();
		}
		return null;
	}

}
