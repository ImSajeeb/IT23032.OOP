import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EquationSolverGame {

    static class EqnSolver {
        public int score;

        public int computeResult(String input) {
            String[] parts = input.split("#");
            String equation = parts[0];
            score = Integer.parseInt(parts[1]);

            String[] numberParts = equation.split("([+\\-*/=])");
            ArrayList<Integer> numbers = new ArrayList<>();
            for (String num : numberParts) {
                if (!num.isEmpty() && !num.equals("?")) {
                    numbers.add(Integer.parseInt(num));
                }
            }

            String operators = equation.replaceAll("[^+\\-*/]", "");
            int answer = numbers.get(0);
            for (int i = 0; i < operators.length(); i++) {
                char operator = operators.charAt(i);
                int nextNumber = numbers.get(i + 1);
                switch (operator) {
                    case '+':
                        answer += nextNumber;
                        break;
                    case '-':
                        answer -= nextNumber;
                        break;
                    case '*':
                        answer *= nextNumber;
                        break;
                    case '/':
                        if (nextNumber != 0) {
                            answer /= nextNumber;
                        } else {
                            System.out.println("Error: Division by zero.");
                        }
                        break;
                    default:
                        System.out.println("Error: Unsupported operator.");
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = scanner.nextLine();
        System.out.println("Welcome, " + playerName + "!");

        while (true) {
            int score = 0;
            System.out.println("Choose difficulty level: (1/2/3)");
            System.out.println("1. Beginner\n2. Medium\n3. Advanced");
            int difficulty = scanner.nextInt();

            String filePath = "";
            switch (difficulty) {
                case 1:
                    filePath = "D:\\2nd Year 1st Semester\\OOP(ICT-2107) [Zia Sir]\\CODE\\ok/Beginner.txt";
                    break;
                case 2:
                    filePath = "D:\\2nd Year 1st Semester\\OOP(ICT-2107) [Zia Sir]\\CODE\\ok/Medium.txt";
                    break;
                case 3:
                    filePath = "D:\\2nd Year 1st Semester\\OOP(ICT-2107) [Zia Sir]\\CODE\\ok/Advance.txt";
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            try (Scanner fileScanner = new Scanner(new File(filePath))) {
                EqnSolver solver = new EqnSolver();

                while (fileScanner.hasNextLine()) {
                    String equation = fileScanner.nextLine();
                    System.out.println("Solve: " + equation.substring(0, equation.length() - 2));

                    int correctAnswer = solver.computeResult(equation);
                    int userAnswer = scanner.nextInt();

                    if (userAnswer == correctAnswer) {
                        score += solver.score;
                        System.out.println("Correct!");
                    } else {
                        System.out.println("Incorrect! Correct answer: " + correctAnswer);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error: Unable to read the file.");
                e.printStackTrace();
            }

            System.out.println(playerName + ", your score is: " + score + "/" + (difficulty * 10));
            saveScore(playerName, score, difficulty);

            System.out.println("Do you want to play again? (1. Yes / 2. No)");
            int playAgain = scanner.nextInt();
            if (playAgain == 2) break;
        }

        System.out.println("Thank you for playing, " + playerName + "!");
        scanner.close();
    }

    private static void saveScore(String playerName, int score, int difficulty) {
        String difficultyLevel = switch (difficulty) {
            case 1 -> "Beginner";
            case 2 -> "Medium";
            case 3 -> "Advanced";
            default -> "Unknown";
        };

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(timeFormatter);

        String filePath = "D:\\2nd Year 1st Semester\\OOP(ICT-2107) [Zia Sir]\\CODE\\ok/History.txt";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(playerName + "    " + score + "    " + currentDate + "    " + formattedTime + "    " + difficultyLevel + "\n");
            System.out.println("Score saved successfully!");
        } catch (IOException e) {
            System.out.println("Error: Unable to save the score.");
            e.printStackTrace();
        }
    }
}
