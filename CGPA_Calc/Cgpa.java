import java.util.Scanner;

public class Cgpa {
	 public static double GradePoint(double totalMarks) {
	        if (totalMarks >= 80) return 4.0;
	        else if (totalMarks >= 75) return 3.75;
	        else if (totalMarks >= 70) return 3.5;
	        else if (totalMarks >= 65) return 3.25;
	        else if (totalMarks >= 60) return 3.0;
	        else if (totalMarks >= 55) return 2.75;
	        else if (totalMarks >= 50) return 2.5;
	        else if (totalMarks >= 45) return 2.25;
	        else if (totalMarks >= 40) return 2.0;
	        else return 0.0; 
	    }

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	 
		System.out.print("Enter your name: ");
		String name = input.nextLine(); 
		System.out.print("Enter the number of subjects: ");
		int NoOfSub = input.nextInt(); 
		//double[] SubGrade = new double[NoOfSub]; 
		double sum = 0 ;
		double credits = 0; 
		for(int i = 0 ;i<NoOfSub;i++) {
			double c=0,ct=0,at=0,fe=0; 
			System.out.print("Enter the Credit(Max 3) for the course "+(i+1)+": ");
			 c = input.nextDouble(); credits+=c ; 
			 System.out.print("Enter the CT Marks(Max 30) for the course "+(i+1)+": ");
			 ct = input.nextDouble();  
			 System.out.print("Enter the Attendence Marks(Max 10) for the course "+(i+1)+": ");
			 at = input.nextDouble();  
			 System.out.print("Enter the Final Exam Marks(Max 60) for the course "+(i+1)+": ");
			 fe = input.nextDouble();  
			 double p = ct+at+fe;
			 double ok = GradePoint(p);
			 sum += (ok*c); 	
		}
		double cg = sum/credits;
		int flag = 0 ;
	 
		System.out.println();
		System.out.print(name+", Your CGPA is ");
		System.out.printf("%.2f ",cg);
		String grade; 
		if(cg>=4) {
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
		input.close();
	

	}

}
