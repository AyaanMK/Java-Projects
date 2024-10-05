import java.util.Scanner; // Imports Scanner for user input

public class calculator {
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in); // Creates a Scanner object for reading user input
		boolean continueCalculating = true; // Initializes a boolean value to control the while loop
		
		// Main loop for performing calculations
		while (continueCalculating == true) {
			
			double sum = 0; // Initializes the sum variable
		
			// Gets operator from user
			System.out.println("Choose an operator (+, -, *, /, %): ");
			char operator = scan.next().charAt(0);
			
			// Handles invalid operator input
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                // Prints error message for invalid operator
                System.out.println("Error: invalid operator");
                continue; // Skips the rest of the loop and prompts for the operator again
            }
			
			// Gets first number from user
			System.out.println("Pick the first number");
			double numOne = scan.nextDouble();
			
			// Gets second number from user
			System.out.println("Pick the second number");
			double numTwo = scan.nextDouble();
		
			// Checks the chosen operator and performs the corresponding calculation
			switch (operator) {
				case '+': // Addition
					sum = numOne + numTwo;
					break;
				case '-': // Subtraction
					sum = numOne - numTwo;
					break;
				case '*': // Multiplication
					sum = numOne * numTwo;
					break;
				case '/': // Division
					if (numOne == 0 || numTwo == 0) { // Checks for division by zero
						System.out.println("Error: cannot divide by zero"); // Print error message
						continue; // Skip the rest of the loop
                    }
					sum = numOne / numTwo;
					break;
				case '%': // Modulus
					sum = numOne % numTwo;
					break;
			}
			
			// Prints the formatted answer to the user
			System.out.printf("\nThe answer to %.2f %c %.2f is %.2f\n", numOne, operator, numTwo, sum);
			
			// Ask if the user wants to perform another calculation
			System.out.println("\n===================================================\n" + "Do you want to perform another operation? (yes/no): ");
			String response = scan.next().toLowerCase();
			if (response.equals("no")) { // Closes the while loop if user enters no
				continueCalculating = false;
			}
		}
		
		// Closes the Scanner object
		scan.close();
		
	}
}
