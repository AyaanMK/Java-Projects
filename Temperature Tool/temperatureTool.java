import java.util.Scanner; // Import Scanner class for user input

public class temperatureTool {
    public static void main(String[] args) {
		
        final double MIN_WALK_TEMP = 15.0; // Minimum temperature suitable for a walk
        final double MAX_WALK_TEMP = 30.0; // Maximum temperature suitable for a walk

        Scanner scan = new Scanner(System.in); // Create a Scanner object for input
        byte day, toolOption; // Declare variables for day and tool option
        double totalTemperature, averageTemperature; // Variables for average and total temperature
        char continueResponse; // Variable to store user response for continuing
        boolean temperaturesEntered = false; // Flag to check if temperatures are entered
		String banner = "=========================================="; // String for visual separation in output
		double[] temperatures = new double[7]; // Array to store temperatures for 7 days

        do {
            // Prompt for temperatures if they haven't been entered yet
            if (!temperaturesEntered) {
                // Loop to collect temperatures for 7 days
				
                for (day = 0; day < 7; day++) {
                    boolean validInput = false;
                    System.out.println("Enter temperature for day #" + (day + 1));
					
                    while (!validInput) {
						
                        if (scan.hasNextDouble()) {
                            temperatures[day] = scan.nextDouble();
                            validInput = true;
							
                        } else {
                            System.out.println("Invalid input. Please enter a valid temperature:");
                            scan.next();
                        }
                    }
                }
				
                temperaturesEntered = true; // Set the flag to true after entering temperatures
            }

            // Calculate total temperature by summing up values in the temperatures array
            totalTemperature = 0; // Initialize the value of total temperature
            double lowestTemperature = temperatures[0]; // Initialize to first day's temperature
            double highestTemperature = temperatures[0]; // Initialize to first day's temperature

            // Loop to calculate total temperature, and find lowest and highest temperatures
            for (int i = 0; i < 7; i++) {
				
                totalTemperature += temperatures[i]; // Add temperatures to get total temperature
                if (temperatures[i] < lowestTemperature) { // Update lowest temperature
                    lowestTemperature = temperatures[i];
                }
				
                if (temperatures[i] > highestTemperature) { // Update highest temperature
                    highestTemperature = temperatures[i];
                }
            }

            // Calculate average temperature
            averageTemperature = totalTemperature / 7;

            // Prompt the user to select a tool option
            System.out.println(banner + "\nEnter the tool you would like to use\nWeekly average \t\t\t\t\t= 1\nMaximum temperature \t\t\t\t= 2\nMinimum temperature \t\t\t\t= 3\nSuitable for a walk \t\t\t\t= 4");
            toolOption = scan.nextByte(); // Read the user's choice of tool option
            
            // Use switch statement to handle user input for tool options
            switch (toolOption) {
				
                case 1: // Weekly average
                    System.out.printf("The average temperature for the week was %.2f degrees Celsius%n", averageTemperature);
                    break;

                case 2: // Maximum temperature
                    System.out.printf("The highest temperature for the week was %.2f degrees Celsius%n", highestTemperature);
                    break;
                
                case 3: // Minimum temperature
                    System.out.printf("The lowest temperature for the week was %.2f degrees Celsius%n", lowestTemperature);
                    break;
                
                case 4: // Check if suitable for a walk
                    if (averageTemperature >= MIN_WALK_TEMP && averageTemperature <= MAX_WALK_TEMP) {
                        System.out.println("It is a nice day to go outside"); // Output suitable for a walk
                    } else {
                        System.out.println("It is not a nice day to go outside"); // Output not suitable for a walk
                    }
                    break;

                default: // Handle invalid tool option
                    System.out.println("Invalid option selected.");
                    break;
            }

            // Ask if user wants to continue
            System.out.println("Would you like to use the tool again? (y/n)");
            continueResponse = scan.next().charAt(0); // Read user response
        }
		
		while (continueResponse == 'y'); // Continue if user wants to use the tool again

        System.out.println("Exiting program..."); // Inform user that the program is ending
		
        scan.close(); // Close the scanner to free computer memory
		
    }
}
