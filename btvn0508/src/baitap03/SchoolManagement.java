package baitap03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SchoolManagement {
	private static List<Student> list = new ArrayList<>();
	private static List<Course> courseList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	private static List<Teacher> teacherList = new ArrayList<>();
	private final static Pattern ID_PATTERN = Pattern.compile("^SD[0-9]{4}");
	private final static Pattern TEACHER_PATTERN = Pattern.compile("^TC[0-9]{4}");
	private final static Pattern COURSE_PATTERN = Pattern.compile("^[A-Z]{3}[0-9]{3}");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Student Management");
			System.out.println("2. Teacher Management");
			System.out.println("3. Course Management");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			System.out.println("");
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid choice! Please try again.");
			}

			switch (choice) {
			case 1:
				int studentChoice = 0;

				do {
					System.out.println("");
					System.out.println("Student Management:");
					System.out.println("1. Add student ");
					System.out.println("2. Show student profile");
					System.out.println("3. Enroll course");
					System.out.println("4. Exit");
					System.out.print("Enter your choice:");
					studentChoice = Integer.parseInt(sc.nextLine());
					System.out.println("");

					if (studentChoice == 1) {
						inputStudent();
					} else if (studentChoice == 2) {
						showProfile();
					} else if (studentChoice == 3) {
						enrollCourse();
					}
				} while (studentChoice != 4);

				break;
			case 2:
				int teacherChoice = 0;
				do {
					System.out.println("");
					System.out.println("Teacher Management:");
					System.out.println("1. Add teacher");
					System.out.println("2. Show teacher profile");
					System.out.println("3. Assign teacher");
					System.out.println("4. Exit");
					System.out.print("Enter your choice:");
					teacherChoice = Integer.parseInt(sc.nextLine());
					System.out.println("");

					if (teacherChoice == 1) {
						inputTeacher();
					} else if (teacherChoice == 2) {
						showTeacher();
					} else if (teacherChoice == 3) {
						assign();
					}
				} while (teacherChoice != 4);

				break;
			case 3:
				int courseChoice = 0;

				do {
					System.out.println("");
					System.out.println("Course Management:");
					System.out.println("1. Add course");
					System.out.println("2. View Course");
					System.out.println("3. Exit ");
					System.out.print("Enter your choice:");
					courseChoice = Integer.parseInt(sc.nextLine());
					System.out.println("");

					if (courseChoice == 1) {
						inputCourse();
					} else if (courseChoice == 2) {
						showCourse();
					}

				} while (courseChoice != 3);

				break;
			case 4:
				System.out.println("Exiting...");
				break;
			}
		} while (choice != 4);
	}

	// Input Student
	public static void inputStudent() {
		String name, address, id;
		int age;

		System.out.println("Input student's name:");
		name = sc.nextLine();
		while (true) {
			System.out.println("Input student's age:");
			try {
				age = Integer.parseInt(sc.nextLine());
				if (age > 0) {
					break;
				} else {
					System.err.println("Age must be positive number!!");
				}
			} catch (Exception e) {
				System.err.println("Invalid Format!!!");
			}

		}

		System.out.println("Input student's address:");
		address = sc.nextLine();
		do {
			System.out.println("Input id student:");
			id = sc.nextLine();
			if (ID_PATTERN.matcher(id).find()) {
				if (checkIdDuplicate(id)) {
					System.err.println("This student id already existed!!");
					return;
				}else {
					break;
				}
			} else {
				System.err.println("You should input in the following format - SDxxxx ");
			}
		} while (true);

		Student student = new Student(name, age, address, id);
		list.add(student);

	}

	public static void showProfile() {
		for (Student student : list) {
			student.displayInfo();
		}
	}

	public static void enrollCourse() {

		System.out.println("Enter student ID: ");
		String studentId = sc.nextLine();
		Student student = findStudentById(studentId);
		if (student != null) {
			showCourse();
			System.out.println("Enter course code to enroll: ");
			String courseCode = sc.nextLine();
			Course courseCheck = findCourseByCode(courseCode);
			if (courseCheck != null) {
				student.enroll(courseCheck);
				System.out.println("Course enrolled successfully!");
			} else {
				System.out.println("Course not found!");
			}
		} else {
			System.out.println("Student not found!");
		}
	}

	public static void enroll(Course course) {
		for (Student student : list) {
			student.enroll(course);
		}
	}

	public static void showCourse() {
		for (Course course : courseList) {
			course.displayInfo();
		}
	}

	// input Course
	public static void inputCourse() {
		String courseName, courseCode;
		System.out.println("Input course name: ");
		courseName = sc.nextLine();

		while (true) {
			System.out.println("Input course code: ");
			courseCode = sc.nextLine();
			if (COURSE_PATTERN.matcher(courseCode).find()) {
				break;
			} else {
				System.err.println("You should input in following format - (first three letter)xxx");
			}
		}

		Course courses = new Course(courseName, courseCode);
		courseList.add(courses);

	}

	public static Student findStudentById(String id) {
		for (Student student : list) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		return null;

	}

	public static Course findCourseByCode(String courseCode) {
		for (Course course : courseList) {
			if (course.getCourseCode().equals(courseCode)) {
				return course;
			}
		}
		return null;
	}

	// Input teacher
	public static void inputTeacher() {
		String name, address, id, subjects;
		int age;
		try {
			System.out.println("Input teacher's name: ");
			name = sc.nextLine();
			while (true) {
				System.out.println("Input teacher's age: ");
				age = Integer.parseInt(sc.nextLine());
				if (age > 0) {
					break;
				} else {
					System.err.println("Age must be positive number!!");
				}
			}

			System.out.println("Input teacher's address: ");
			address = sc.nextLine();

			while (true) {
				System.out.println("Input teacher's id: ");
				id = sc.nextLine();
				if (TEACHER_PATTERN.matcher(id).find()) {
					if (checkIdDuplicate(id)) {
						System.err.println("This teacher id already existed!!!");
						return;
					} else {
						break;
					}
				} else {
					System.err.println("You should input in following format - TCxxxx ");
				}

			}

			System.out.println("Input teacher's subject: ");
			subjects = sc.nextLine();
			Teacher teacher = new Teacher(name, age, address, id);
			teacherList.add(teacher);
			System.out.println("Add Teacher Successfully!!!");
		} catch (Exception e) {
			System.err.println("Invalid format!!");
		}

	}

	// Find Teacher ID
	public static Teacher findTeacherById(String id) {
		for (Teacher teacher : teacherList) {
			if (teacher.getId().equals(id)) {
				return teacher;
			}
		}
		return null;
	}

	// Assign
	public static void assign() {
		System.out.println("Enter teacher ID: ");
		String teacherId = sc.nextLine();
		Teacher teacher = findTeacherById(teacherId);
		if (teacher != null) {
			showCourse();
			System.out.println("Enter course name to assign: ");
			String courseName = sc.nextLine();
			Course courseCheck = findCourseByName(courseName);
			if (courseCheck != null) {
				if (courseCheck.getTeacher() != null) {
					System.err.println("Course already has a teacher assigned. Cannot assign another teacher.");
				} else {
					teacher.assign(courseCheck);
					courseCheck.assignTeacher(teacher);
					System.out.println("Teacher assigned successfully!");
				}

			} else {
				System.err.println("Course not found");

			}

		} else {
			System.out.println("Teacher not found!!!");
		}
	}

	public static void findTeacherByName() {
		for (Course course : courseList) {

		}
	}

	public static void showTeacher() {
		for (Teacher teacher : teacherList) {
			teacher.displayInfo();
		}
	}

	public static Course findCourseByName(String courseName) {
		for (Course course : courseList) {
			if (course.getCourseName().equals(courseName)) {
				return course;
			}
		}
		return null;
	}

	public static boolean checkIdDuplicate(String id) {
		for (Student student : list) {
			if (student.getId().equals(id)) {
				return true;
			}
		}

		for (Teacher teacher : teacherList) {
			if (teacher.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
}
