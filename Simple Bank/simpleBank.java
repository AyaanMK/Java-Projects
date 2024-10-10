import java.util.Scanner; // Import the Scanner class for user input

public class simpleBank {
    public static void main(String[] args) {
		
        // Constants for user options
        final byte CHECK_BALANCE 	= 1; // Option to check balance
        final byte DEPOSIT_MONEY 	= 2; // Option to deposit money
        final byte WITHDRAW_MONEY 	= 3; // Option to withdraw money
        final byte VIEW_HISTORY		= 4; // Option to view transaction history
        final byte EXIT 			= 5; // Option to exit the program

        Scanner scan = new Scanner(System.in); // Create a Scanner object for user input
        byte userOption; // Variable to store the user's menu choice
        byte numOfTransactions = 0; // Counter for the number of transactions made
        double bankBalance = 0; // Variable to hold the current bank balance
        boolean continueLoop = true; // Control variable for the main loop
        String banner = "=========================================="; // Banner for user interface
        double[] transactionHistory = new double[100]; // Array to store transaction history

        // Main loop to keep the program running until the user decides to exit
        while (continueLoop) {
			
            // Check if the limit of transactions has been reached
            if (numOfTransactions == 100) {
                System.out.println("Limit of transactions reached. Exiting program...");
                continueLoop = false; // Exit the loop
            }

            // Display banking options to the user
            System.out.println(banner + "\nChoose an option:");
            System.out.println("1 = Check balance");
            System.out.println("2 = Deposit money");
            System.out.println("3 = Withdraw money");
            System.out.println("4 = View transaction history");
            System.out.println("5 = Exit");
		
            userOption = scan.nextByte(); // Get user's choice

            // Switch statement to handle user's choice
            switch (userOption) {
                case CHECK_BALANCE:
                    System.out.printf("Bank balance: $%.2f%n", bankBalance); // Display the current bank balance
                    break;

                case DEPOSIT_MONEY:
                    System.out.print("Enter amount: $"); // Prompt user to enter amount to deposit
                    double moneyDeposited = scan.nextDouble(); // Get deposit amount

                    // Check if the entered amount is positive
                    if (moneyDeposited > 0) {
                        transactionHistory[numOfTransactions] = moneyDeposited; // Store transaction in history
                        bankBalance += moneyDeposited; // Update bank balance
                        numOfTransactions++; // Increment transaction counter
                    } else {
                        System.out.println("Please enter a positive amount."); // Error message for non-positive amount
                    }
                    break;

                case WITHDRAW_MONEY:
                    System.out.print("Enter amount: $"); // Prompt user to enter amount to withdraw
                    double moneyWithdrawn = scan.nextDouble(); // Get withdrawal amount

                    // Validate withdrawal amount against bank balance
                    if (moneyWithdrawn > bankBalance) {
                        System.out.println("Insufficient funds. Withdrawal denied."); // Insufficient funds message
                    } else if (moneyWithdrawn < 0) {
                        System.out.println("Please enter a positive amount."); // Error message for non-positive amount
                    } else {
                        transactionHistory[numOfTransactions] = -moneyWithdrawn; // Store negative transaction in history
                        bankBalance -= moneyWithdrawn; // Update bank balance
                        numOfTransactions++; // Increment transaction counter
                    }
                    break;

                case VIEW_HISTORY:
                    System.out.println("Transaction history (oldest to latest):"); // Display transaction history
                    for (int i = 0; i < numOfTransactions; i++) { // Loop through transaction history and display each entry
                        System.out.println(transactionHistory[i]);
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting program..."); // Inform user that the program is ending
                    continueLoop = false; // Set the loop control variable to false to exit
                    break;

                default:
                    System.out.println("Invalid option. Try again."); // Error message for invalid option
                    break;
            }
        }

        scan.close(); // Close the Scanner to prevent resource leaks
    }
}