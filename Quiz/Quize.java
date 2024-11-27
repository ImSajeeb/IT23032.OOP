import java.util.Scanner;

public class Quize {

	public static void main(String[] args) {
		System.out.println("Hello! Welcome to the quize."); 
		Scanner sc = new Scanner(System.in);
		String name ; 
		System.out.print("Enter Your Name: ");
		name = sc.nextLine();
		Questions obj = new Questions();
		int result = obj.qq();
		
		 System.out.println( name+ ", Your final score is: " + result);
		
		
		sc.close();
		
		

	}

}
