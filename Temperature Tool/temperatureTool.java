import java.util.Scanner; // Import Scanner class for user input

public class temperatureTool {
    public static void main(String[] args) {
        // Constants to define the minimum and maximum temperatures suitable for a walk
        final double MIN_WALK_TEMP = 15.0;
        final double MAX_WALK_TEMP = 30.0;

        Scanner scan = new Scanner(System.in); // Create a Scanner object for input
        byte day, toolOption = 0, i; // Declare variables for day, tool option, and loop index
        double[] temperatures = new double[7]; // Array to store temperatures for 7 days
        double averageTemperature = 0, totalTemperature = 0; // Variables for average and total temperature
        boolean continueTool = true; // Flag to control the tool usage loop
        char continueResponse; // Variable to store user response for continuing
        String banner = "=========================================="; // String for visual separation in output
        
        // Loop to collect temperatures for 7 days
		for (day = 0; day < 7; day += 1) {
			boolean validInput = false;
			System.out.println("Enter temperature for day #" + (day + 1));
			while (!validInput) {
				if (scan.hasNextDouble()) {
					temperatures[day] = scan.nextDouble();
					validInput = true;
				}
				else {
					System.out.println("Invalid input. Please enter a valid temperature:");
					scan.next();
				}
			}
		}	

        // Calculate total temperature by summing up values in the temperatures array
        for (i = 0; i < 7; i += 1) {
            totalTemperature += temperatures[i]; // Accumulate total temperature
        }
        
        // Calculate average temperature
        averageTemperature = totalTemperature / 7; // Compute average

        // Initialize minimum and maximum temperatures to the first day's temperature
        double minimumTemperature = temperatures[0];
        double maximumTemperature = temperatures[0];

        // Loop to find the minimum temperature from the array
        for (int min = 1; min < 7; min += 1) {
            if (temperatures[min] < minimumTemperature) { // Check if current temperature is less than the current minimum
                minimumTemperature = temperatures[min]; // Update minimum temperature
            }
        }

        // Loop to find the maximum temperature from the array
        for (int max = 1; max < 7; max += 1) {
            if (temperatures[max] > maximumTemperature) { // Check if current temperature is greater than the current maximum
                maximumTemperature = temperatures[max]; // Update maximum temperature
            }
        }
        
        // Prompt the user to select a tool option
        System.out.println(banner + "\nEnter the tool you would like to use\nWeekly average \t\t\t\t\t= 1\nMaximum temperature \t\t\t\t= 2\nMinimum temperature \t\t\t\t= 3\nSuitable for a walk \t\t\t\t= 4");
        toolOption = scan.nextByte(); // Read the user's choice of tool option
        
        // Use switch statement to handle user input for tool options
        switch (toolOption) {
            case 1: // Weekly average
                System.out.println("The average temperature for the week was " + averageTemperature + " degrees Celsius");
                break;

            case 2: // Maximum temperature
                System.out.println("The highest temperature for the week was " + maximumTemperature + " degrees Celsius");
                break;
                
            case 3: // Minimum temperature
                System.out.println("The lowest temperature for the week was " + minimumTemperature + " degrees Celsius");
                break;
                
            case 4: // Check if suitable for a walk
                if (averageTemperature >= MIN_WALK_TEMP && averageTemperature <= MAX_WALK_TEMP) {
                    System.out.println("It is a nice day to go outside"); // Output suitable for a walk
                } else {
                    System.out.println("It is not a nice day to go outside"); // Output not suitable for a walk
                }
                break;

            default: // Handle invalid tool option (not required but can be added for completeness)
                System.out.println("Invalid option selected.");
                break;
        }
        
        // Ask user if they want to use a different tool
        System.out.println(banner + "\nWould you like to use a different tool? y/n");
        continueResponse = scan.next().charAt(0); // Read user response

        // Loop to handle user response
        while (continueResponse == 'y') { // Continue if user wants to use a different tool
            // Prompt the user to select a tool option again
            System.out.println(banner + "\nEnter the tool you would like to use\nWeekly average \t\t\t\t\t= 1\nMaximum temperature \t\t\t\t= 2\nMinimum temperature \t\t\t\t= 3\nSuitable for a walk \t\t\t\t= 4");
            toolOption = scan.nextByte(); // Read the user's choice of tool option

            // Repeat the switch statement to handle the selected tool option
            switch (toolOption) {
                case 1:
                    System.out.println("The average temperature for the week was " + averageTemperature + " degrees Celsius");
                    break;

                case 2:
                    System.out.println("The highest temperature for the week was " + maximumTemperature + " degrees Celsius");
                    break;

                case 3:
                    System.out.println("The lowest temperature for the week was " + minimumTemperature + " degrees Celsius");
                    break;

                case 4:
                    if (averageTemperature >= MIN_WALK_TEMP && averageTemperature <= MAX_WALK_TEMP) {
                        System.out.println("It is a nice day to go outside");
                    } else {
                        System.out.println("It is not a nice day to go outside");
                    }
                    break;

                default:
                    System.out.println("Invalid option selected.");
                    break;
            }

            // Ask user if they want to use a different tool again
            System.out.println(banner + "\nWould you like to use a different tool? y/n");
            continueResponse = scan.next().charAt(0); // Read user response
        }

        System.out.println("Exiting program..."); // Inform user that the program is ending
		
        scan.close(); // Close the scanner to release resources
    }
}
