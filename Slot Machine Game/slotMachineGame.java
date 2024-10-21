import java.util.Scanner;
import java.util.Random;

public class slotMachineGame {

	public static void main (String [] args) {
		// Constants for game settings
		final double INTEREST_RATE = 0.05; // Interest rate for bank balance
		final double QUOTA_AMOUNT = 3.0; // Quota amount to be paid
		final double JACKPOT_MULTIPLIER = 69.0; // Multiplier for jackpot wins
		final double MAX_BEGGING_AMOUNT = 2.0; // Maximum amount that can be begged
		
		// Variable declarations
		byte userOption;
		int day = 0, daysUntilQuota, reelOne, reelTwo, reelThree;
		double wallet = 0, balance = 0, interestEarned, deposited, withdrawn, amountBegged, betAmount;
		boolean exit = false;

		// Banner for display
		String banner = "=================================";

		// Scanner and Random for user input and random number generation
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		// Game introduction
		System.out.println("Welcome to the Slot Machine Game!");
		
		// Main game loop
		do {
			// Calculate days until quota
			if (day == 0) {
				daysUntilQuota = 7;
			} else {
				daysUntilQuota = 7 - (day % 7);
			}
			
			// Calculate days until quota
			if (day > 0 && day % 7 == 0) {
				if (wallet < QUOTA_AMOUNT) {
					System.out.println("Not enough to meet quota... say goodbye!!!");
					exit = true; // Exit if the quota is not met
					continue;
				} else {
					System.out.println("Paid $3 toward quota");
					wallet -= QUOTA_AMOUNT; // Deduct quota from wallet
				}
			}
			// If exit is true, break from the loop
			if (exit == true) {
				break;
			}
			
			// Calculate and apply interest if balance is positive
			if (balance > 0) {
				interestEarned = balance * INTEREST_RATE;
				balance += interestEarned; // Update balance with interest earned
				System.out.printf("\n\n+$%.2f interest to the Bank (5 percent)\n", interestEarned);
			}
			
			// Display current status
			System.out.printf(banner + "\nDay: %d (%d days until quota)", day, daysUntilQuota);
			System.out.printf("\nWallet: $%.2f | Bank: $%.2f\n", wallet, balance);
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. Beg for money");
			System.out.println("2. Play Slot machine");
			System.out.println("3. Deposit money into the bank");
			System.out.println("4. Withdraw money from the bank");
			System.out.println("5. Exit");

			// Get user option
			userOption = scan.nextByte();
			
			// Process user option
			switch(userOption) {
				case 1: // Beg for money
					amountBegged = Math.round(rand.nextDouble(MAX_BEGGING_AMOUNT) * 100) / 100.0;
					wallet += amountBegged; // Add begged amount to wallet
					System.out.printf("You received $%.2f from begging\n", amountBegged);
					break;
					
				case 2: // Play Slot machine
					reelOne = rand.nextInt(4) + 1; // Random value for reel one
					reelTwo = rand.nextInt(4) + 1; // Random value for reel two
					reelThree = rand.nextInt(4) + 1; // Random value for reel three
					
					System.out.print("How much would you like to bet? $");
					betAmount = scan.nextDouble(); // Get bet amount from user
					
					if (betAmount > wallet) {
						System.out.println("Insufficient funds, try again.");
						continue; // If insufficient funds, prompt again
					}
					
					wallet -= betAmount; // Deduct bet amount from wallet
					
					System.out.println("\nSpinning the reels...");
					System.out.printf("[%d] [%d] [%d]%n", reelOne, reelTwo, reelThree);
					
					// Check results of the slot machine
					if (reelOne == reelTwo || reelOne == reelThree) {
						// Jackpot condition
						if (reelTwo == reelThree) {
							betAmount *= JACKPOT_MULTIPLIER; // Calculate jackpot
							wallet += betAmount; // Add jackpot amount to wallet
							System.out.println("$$$ YOU JUST HIT THE JACKPOT $$$");
							System.out.println("EARNED: $" + betAmount);
						} else { // Regular win
							betAmount *= 2; // Double the bet amount
							wallet += betAmount; // Add doubled amount to wallet
							System.out.println("You just doubled your bet!");
							System.out.println("Earned: $" + betAmount);
						}
					} else {
						System.out.println("You lost the bet... Womp womp");
					}
					
					break;
			
				case 3: // Deposit money into the bank
					System.out.print("How much would you like to deposit?: $");
					deposited = scan.nextDouble(); // Get deposit amount from user
					
					if (deposited > wallet) {
						System.out.println("Insufficient funds, try again.");
						continue; // If insufficient funds, prompt again
					}
					
					System.out.printf("$%.2f has been deposited into your bank account.", deposited);
					wallet -= deposited; // Deduct deposit amount from wallet
					balance += deposited; // Add deposit amount to balance
					break;
				
				case 4: // Withdraw money from the bank
					System.out.print("How much would you like to withdraw?: $");
					withdrawn = scan.nextDouble(); // Get withdrawal amount from user
					
					if (withdrawn > balance) {
						System.out.println("Insufficient funds, try again.");
						continue; // If insufficient funds, prompt again
					}
					
					System.out.printf("$%.2f has been withdrawn from your bank account.\n", withdrawn);
					wallet += withdrawn; // Add withdrawn amount to wallet
					balance -= withdrawn; // Deduct withdrawn amount from balance
					break;
				
				case 5: // Exit the game
					System.out.println("Exiting...");
					exit = true; // Set exit flag to true
					break;

				default: // Handle invalid option
					System.out.println("Invalid option, try again.");
					continue; // If invalid option, prompt again
			}
			
			day++; // Increment the day after a valid action
			
		} while (!exit);
		
		// Close the scanner to avoid resource leaks
		scan.close();
		
	}
}

// Future updates:	-Add time feature
//					-Add achievements
//					-Add methods
//					-Add recent transactions