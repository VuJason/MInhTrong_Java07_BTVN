package demo01;

import java.util.Scanner;
import java.lang.Math;

public class demobuoi1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("input height: ");
		double height = sc.nextDouble();
		System.out.print("input bottom: ");
		double bot = sc.nextDouble();
		
		System.out.println("Caculate hypotenuse......");
		double result = Math.sqrt(Math.pow(height, 2.0) + Math.pow(bot, 2.0));
		System.out.println(result);
		
//		
		
	}
}
