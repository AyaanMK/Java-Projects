import java.util.Scanner; // Imports Scanner for user input
import java.util.Random;  // Imports Random to generate a random number

public class higherOrLower {
    public static void main (String [] args) {
		// Constants used to check if user inputs within 1-100 range
		final byte LOWER_RANGE = 1;
		final byte UPPER_RANGE = 100;
		
        // Creates a Scanner object for reading user input
        Scanner scan = new Scanner(System.in);
        
        // Creates a Random object to generate a random number
        Random rand = new Random();
        
        // Variable initialization
        byte userGuess; // Stores the user's guess
		byte attempts = 7; // The amount of attempts the user has to guess correctly
        boolean guessedCorrectly = false; // Boolean value to check if the user has guessed correctly
		int correctNumber = rand.nextInt(100) + 1; // Generates a random number between 1 and 100
        
        // Asks the user for their name and displays a welcome message
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        System.out.println("\nHello " + name + ", and welcome to the higher or lower game.\nYou will have 7 attempts to guess a number from 1-100.\nThe program will tell you if your guess is higher or lower than the correct answer.\nHave fun!\n");
        
        // Main game loop, runs until the user guesses correctly or runs out of attempts
        while (!guessedCorrectly) {
            
            // Check if the user has any attempts left
            if (attempts > 0) {
                System.out.println("==========================" + "\nPick a number from 1-100");
                
                // Reads the user's guess
                userGuess = scan.nextByte();
                
                // Check if the guess is within the valid range (1-100)
                if (userGuess >= LOWER_RANGE && userGuess <= UPPER_RANGE) {
                    
                    // If the guess is correct, prints victory message
                    if (userGuess == correctNumber) {
                        System.out.println("==========================" + "\nYou guessed correctly! The number was " + correctNumber + ".");
                        guessedCorrectly = true; // Changes boolean value to true to stop the loop
                    }
                    
					// If the guess is higher than the correct number
                    else if (userGuess > correctNumber) {
                        System.out.println("The number is lower than " + userGuess);
                        attempts -= 1; // Decreases the attempts counter
                        System.out.println("Attempts left: " + attempts);
                    }
                    
					// If the guess is lower than the correct number
                    else if (userGuess < correctNumber) {
                        System.out.println("The number is higher than " + userGuess);
                        attempts -= 1; // Decreases the attempts counter
                        System.out.println("Attempts left: " + attempts);
                    }
                    
                } 
                
				// If the guess is outside the valid range (1-100)
                else {
                    System.out.println("Your guess is outside of the range (1-100). Try again.");
                }
                
            } 
            
			// If no attempts are left, ends the game
            else {
                System.out.println("==========================" + "\nNo more attempts left. The number was " + correctNumber);
                break; // Exits the loop
            }
        }
		
		// Closes the Scanner object
		scan.close();
    }
}