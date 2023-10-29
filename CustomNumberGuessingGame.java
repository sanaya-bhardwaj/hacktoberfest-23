import java.util.Random;
import java.util.Scanner;

public class CustomNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxTries = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Custom Number Guessing Game!");
        System.out.println("You have " + maxTries + " tries to guess the number.");

        while (playAgain) {
            System.out.println("Choose a difficulty level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-200)");
            System.out.print("Enter your choice (1/2/3): ");

            int choice = scanner.nextInt();
            int upperBound;

            if (choice == 1) {
                upperBound = 50;
            } else if (choice == 2) {
                upperBound = 100;
            } else {
                upperBound = 200;
            }

            int secretNumber = random.nextInt(upperBound) + 1;
            int numberOfTries = 0;

            System.out.println("I've selected a number between 1 and " + upperBound + ". Try to guess it.");

            while (numberOfTries < maxTries) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess < 1 || guess > upperBound) {
                    System.out.println("Please enter a number between 1 and " + upperBound + ".");
                } else if (guess < secretNumber) {
                    System.out.println("Try a higher number.");
                } else if (guess > secretNumber) {
                    System.out.println("Try a lower number.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
                    score++;
                    break;
                }

                if (numberOfTries == maxTries) {
                    System.out.println("Sorry, you've run out of tries. The correct number was " + secretNumber + ".");
                }
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("yes");

            if (playAgain) {
                System.out.println("Your score: " + score);
            }
        }

        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}
