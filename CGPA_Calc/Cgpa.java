

import java.util.Scanner;

public class Cgpa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		 
		System.out.print("Enter your name: ");
		String name = input.nextLine(); 
		System.out.print("Enter the number of subjects: ");
		int NoOfSub = input.nextInt(); 
		double[] SubGrade = new double[NoOfSub]; 
		double sum = 0 ;
		for(int i = 0 ;i<NoOfSub;i++) {
			System.out.print("Enter the grade points for subject "+(i+1)+": ");
			SubGrade[i]=input.nextDouble(); 
			sum+=SubGrade[i];
		}
		int flag = 0 ;
		double cg = sum/NoOfSub; 
		System.out.println();
		System.out.print(name+", Your CGPA is ");
		System.out.printf("%.2f ",cg);
		String grade; 
		if(cg==4) {
			grade = "A+";
		}
		else if(cg>=3.75) {
			grade = "A";
		}
		else if(cg>=3.5) {
			grade = "A-";
		}
		else if(cg>=3.25) {
			grade = "B+";
		}
		else if(cg>=3.00) {
			grade = "B";
		}
		else if(cg>=2.75) {
			grade = "B-";
		}
		else if(cg>=2.5) {
			grade = "C+";
		}
		else if(cg>=2.25) {
			grade = "C";
		}
		else if(cg>=2.0) {
			grade = "D";
		}
		else {
			grade = "Fail";
			flag = 1 ; 
		}
		
		System.out.println("and your Grade is "+grade);
		if(flag==1) {
			System.out.println("Better Luck next time !");
		}
	

	}

}
