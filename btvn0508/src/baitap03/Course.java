package baitap03;

import java.util.ArrayList;

public class Course {
	private String courseName;
	private String courseCode;
	private ArrayList<Teacher> teachers;

	public Course(String courseName, String courseCode) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.teachers = new ArrayList<Teacher>();

	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void assignTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void displayInfo() {

		System.out.printf("|%-20s|%-12s|%-12s|", this.courseName, this.courseCode, this.getTeacher());
		System.out.println("");
	}

	public String getTeacher() {
		for (Teacher teacher : teachers) {
			return teacher.getName();
		}
		return null;
	}
	
	public boolean hasTeacher() {
		return getTeacher()!=null;
		
	}

}
