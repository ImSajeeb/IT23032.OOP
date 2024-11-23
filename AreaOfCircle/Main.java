package AreaOfCircle;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double radius ; 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the radius of the circle: "); 
		radius = input.nextDouble(); 
		Radius obj = new Radius(); 
		double area = obj.area(radius);
		System.out.println("The area is "+area);
		

	}

}
