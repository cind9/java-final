import java.util.Scanner;
/**
* The main method to run the number guessing game. The game consists of three rounds
* with different numbers of trials: 10, 5, and 3.
*
*/
public class NumberGuessingGameTester {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You will have 3 games with 10, 5, and 3 trials respectively to guess a number between 0 and 100");
        System.out.println("Press Enter to start the game...");
        
        // Press enter to start
        in.nextLine();

        // for loop to repeat the game for the number of trials
        for (int i = 1; i <= 3; i++) {
            int trials;
            switch (i) {
                case 1:
                    trials = 10;
                    break;
                case 2:
                    trials = 5;
                    break;
                case 3:
                    trials = 3;
                    break;
                default:
                    trials = 10;
            }

            System.out.println("\nStarting game with " + trials + " trials:");
            NumberGuessingGame game = new NumberGuessingGame(trials);
            game.playGame();
        }
        System.out.println("\nThank you for playing the Number Guessing Game!");
    
    }
}
