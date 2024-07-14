package baitap01;

import java.util.Iterator;
import java.util.Scanner;

public class bai4 {
	
	final static double UNIVERSITY_X = 3.0;
	final static double UNIVERSITY_Y = 4.0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3];
		double[] x = new double[3];
		double[] y = new double[3];
		
		for (int i = 0; i < name.length; i++) {
			System.out.println("List of student #" +(i+1)+ "/3");
			System.out.println("Input student name: ");
			name[i] = sc.nextLine();
			System.out.println("Home coordinate (point x): ");
			x[i] = Double.parseDouble(sc.nextLine());
			System.out.println("Home coordinate (point y): ");
			y[i] = Double.parseDouble(sc.nextLine());
		}
		
		
		String fathestStudent = "";
		double maxDistance = 0;
		for (int i = 0; i < name.length; i++) {
			double distance = Math.sqrt(Math.pow(x[i]-UNIVERSITY_X, 2)+(Math.pow(y[i]-UNIVERSITY_Y,	2)));
			if(distance > maxDistance) {
				maxDistance = distance;
				fathestStudent = name[i];
			}
		}
		
		System.out.println("The student farthest from the university: " +fathestStudent);
		
	}
	
	
	
	
	
}
