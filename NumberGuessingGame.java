import java.util.Scanner;
import java.util.Random;
/**
 * A class representing a number guessing game where the user has a limited number of trials
 * to guess a randomly generated number between 1 and 100.
 * Reference: GeeksforGeeks (2021) https://www.geeksforgeeks.org/number-guessing-game-in-java/?ref=ml_lbp
 */
public class NumberGuessingGame {
    private int numberToGuess;
    private int maxTrials;
    private final int epsilon = 2; // epsilon value of 2

    /**
     * Constructs a NumberGuessingGame with the specified maximum number of trials.
     *
     * @param maxTrials the maximum number of trials allowed
     */
    public NumberGuessingGame(int maxTrials) {
        this.maxTrials = maxTrials;
        Random generator = new Random();
        this.numberToGuess = generator.nextInt(100) + 1; // Random number between 1 and 100
    }

    /**
     * Starts the game and allows the user to guess the number within the number of trials.
     * 
     * @return true if the user guessed the number correctly, false otherwise
     */
    public boolean playGame() {
        Scanner in = new Scanner(System.in);
        int trials = 0;
        boolean guessedCorrectly = false;

        while (trials < maxTrials) {
            System.out.println("Enter your guess (between 1 and 100): ");
            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                in.next(); // takes invalid input
            }
            int userGuess = in.nextInt();

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Guess must be between 1 and 100.");
                continue;
            }

            trials++;
            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the number within " + maxTrials + " trials.");
                guessedCorrectly = true;
                break;
            } else if (Math.abs(userGuess - numberToGuess) <= epsilon) {
                System.out.println("Very close! But the number is still different.");
                if (userGuess > numberToGuess) {
                    System.out.println("The number is less than your guess.");
                } else {
                    System.out.println("The number is greater than your guess.");
                }
            } else if (userGuess > numberToGuess) {
                System.out.println("The number is less than your guess.");
            } else {
                System.out.println("The number is greater than your guess.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've run out of trials. The number was: " + numberToGuess);
        }

        return guessedCorrectly;
    }

    // returns maximum number of trials
    public int getMaxTrials() {
        return maxTrials;
    }

    // returns maxTraials the maximum number of trials
    public void setMaxTrials(int maxTrials) {
        this.maxTrials = maxTrials;
    }

    // returns the epsilon value
    public int getEpsilon() {
        return epsilon;
    }
}