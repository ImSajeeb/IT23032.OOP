import java.util.Scanner;

public class Questions{
	Scanner input = new Scanner(System.in);
	int qq() {
		int score =0 ; 
		 String[] questions = {
		            "What is the currency of Bangladesh?",
		            "What is the name of the longest river in Bangladesh?",
		            "What is the largest mammal on Earth?",
		            "What is the national flower of Bangladesh?",
		            "What is the national tree of Bangladesh?"
		        };
		  String[][] options = {
		            {"1. Taka", "2. Dollar", "3. Rupee"},
		            {"1. Padma", "2. Jamuna", "3. Meghna"},
		            {"1. Elephant", "2. Blue Whale", "3. Great White Shark"},
		            {"1. Rose", "2. Water Lily", "3. Lotus"},
		            {"1. Banyan Tree", "2. Neem Tree", "3. Mango Tree"}
		        };
		  int[] correctAnswers = {1, 3, 2, 2, 3};
		  
		  for (int i = 0; i < questions.length; i++) {
	            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
	            
	            for (String option : options[i]) {
	                System.out.println(option);
	            }

	            System.out.print("Your answer (1/2/3): ");
	            int userAnswer = input.nextInt();
	            if (userAnswer == correctAnswers[i]) {
	                System.out.println("Correct!");
	                score += 5;
	            } else {
	                System.out.println("Incorrect.");
	                score -= 1;
	            }
	        }
		 return score ; 
		  
		  
	}

}
