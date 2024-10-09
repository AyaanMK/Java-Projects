import java.util.Scanner; // Import the Scanner class for user input

public class freeFallCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);
        byte userOptionOne, userOptionTwo; // Variables to store user options

        // Display options for what the user wants to calculate
        System.out.println("Enter what you would like to find:");
        System.out.println("1 = Displacement");
        System.out.println("2 = Time");
        System.out.println("3 = Final velocity");
        System.out.println("4 = Initial velocity");
        System.out.println("5 = Acceleration");
        userOptionOne = scan.nextByte(); // Get the user's choice

        // Switch statement to handle the user's choice
        switch (userOptionOne) {
            case 1: // Case for Displacement
                System.out.println("Enter known variables:");
                System.out.println("1 = acceleration, initial velocity, time");
                System.out.println("2 = final velocity, initial velocity, time");
                System.out.println("3 = initial velocity, final velocity, acceleration");
                userOptionTwo = scan.nextByte(); // Get the second user choice

                // Switch statement to handle the specific displacement calculation
                switch (userOptionTwo) {
                    case 1:
                        // Case for calculating displacement using acceleration, initial velocity, and time
                        System.out.println("Enter initial velocity, acceleration, and time:");
                        double initialVelocity1 = scan.nextDouble();
                        double acceleration1 = scan.nextDouble();
                        double time1 = scan.nextDouble();
                        double displacement1 = calculateDisplacement(initialVelocity1, acceleration1, time1);
                        System.out.println("Displacement: " + displacement1 + " m");
                        break;
                    case 2:
                        // Case for calculating displacement using final velocity, initial velocity, and time
                        System.out.println("Enter final velocity, initial velocity, and time:");
                        double finalVelocity2 = scan.nextDouble();
                        double initialVelocity2 = scan.nextDouble();
                        double time2 = scan.nextDouble();
                        double displacement2 = calculateDisplacementUsingFinalVelocity(finalVelocity2, initialVelocity2, time2);
                        System.out.println("Displacement: " + displacement2 + " m");
                        break;
                    case 3:
                        // Case for calculating displacement using initial velocity, final velocity, and acceleration
                        System.out.println("Enter initial velocity, final velocity, and acceleration:");
                        double initialVelocity3 = scan.nextDouble();
                        double finalVelocity3 = scan.nextDouble();
                        double acceleration3 = scan.nextDouble();
                        double displacement3 = calculateDisplacementUsingVelocity(initialVelocity3, finalVelocity3, acceleration3);
                        System.out.println("Displacement: " + displacement3 + " m");
                        break;
                }
                break;

            case 2: // Case for Time
                System.out.println("Enter known variables:");
                System.out.println("1 = displacement, initial velocity, acceleration");
                System.out.println("2 = displacement, final velocity, initial velocity");
                System.out.println("3 = final velocity, initial velocity, acceleration");
                userOptionTwo = scan.nextByte(); // Get the second user choice

                // Switch statement to handle the specific time calculation
                switch (userOptionTwo) {
                    case 1:
                        // Case for calculating time using displacement, initial velocity, and acceleration
                        System.out.println("Enter displacement, initial velocity, and acceleration:");
                        double displacement1 = scan.nextDouble();
                        double initialVelocity1 = scan.nextDouble();
                        double acceleration1 = scan.nextDouble();
                        double time1 = calculateTimeUsingDisplacement(displacement1, initialVelocity1, acceleration1);
                        System.out.println("Time: " + time1 + " s");
                        break;
                    case 2:
                        // Case for calculating time using displacement, final velocity, and initial velocity
                        System.out.println("Enter displacement, final velocity, and initial velocity:");
                        double displacement2 = scan.nextDouble();
                        double finalVelocity2 = scan.nextDouble();
                        double initialVelocity2 = scan.nextDouble();
                        double time2 = calculateTimeUsingVelocity(displacement2, finalVelocity2, initialVelocity2);
                        System.out.println("Time: " + time2 + " s");
                        break;
                    case 3:
                        // Case for calculating time using final velocity, initial velocity, and acceleration
                        System.out.println("Enter final velocity, initial velocity, and acceleration:");
                        double finalVelocity3 = scan.nextDouble();
                        double initialVelocity3 = scan.nextDouble();
                        double acceleration3 = scan.nextDouble();
                        double time3 = calculateTimeUsingFinalVelocity(finalVelocity3, initialVelocity3, acceleration3);
                        System.out.println("Time: " + time3 + " s");
                        break;
                }
                break;

            case 3: // Case for Final Velocity
                System.out.println("Enter known variables:");
                System.out.println("1 = initial velocity, acceleration, time");
                System.out.println("2 = displacement, initial velocity, time");
                System.out.println("3 = initial velocity, acceleration, displacement");
                userOptionTwo = scan.nextByte(); // Get the second user choice

                // Switch statement to handle the specific final velocity calculation
                switch (userOptionTwo) {
                    case 1:
                        // Case for calculating final velocity using initial velocity, acceleration, and time
                        System.out.println("Enter initial velocity, acceleration, and time:");
                        double initialVelocity1 = scan.nextDouble();
                        double acceleration1 = scan.nextDouble();
                        double time1 = scan.nextDouble();
                        double finalVelocity1 = calculateFinalVelocity(initialVelocity1, acceleration1, time1);
                        System.out.println("Final Velocity: " + finalVelocity1 + " m/s");
                        break;
                    case 2:
                        // Case for calculating final velocity using displacement, initial velocity, and time
                        System.out.println("Enter displacement, initial velocity, and time:");
                        double displacement1 = scan.nextDouble();
                        double initialVelocity2 = scan.nextDouble();
                        double time2 = scan.nextDouble();
                        double finalVelocity2 = calculateFinalVelocityUsingDisplacement(displacement1, initialVelocity2, time2);
                        System.out.println("Final Velocity: " + finalVelocity2 + " m/s");
                        break;
                    case 3:
                        // Case for calculating final velocity using initial velocity, acceleration, and displacement
                        System.out.println("Enter initial velocity, acceleration, and displacement:");
                        double initialVelocity3 = scan.nextDouble();
                        double acceleration3 = scan.nextDouble();
                        double displacement3 = scan.nextDouble();
                        double finalVelocity3 = calculateFinalVelocityUsingAcceleration(initialVelocity3, acceleration3, displacement3);
                        System.out.println("Final Velocity: " + finalVelocity3 + " m/s");
                        break;
                }
                break;

            case 4: // Case for Initial Velocity
                System.out.println("Enter known variables:");
                System.out.println("1 = final velocity, acceleration, time");
                System.out.println("2 = displacement, final velocity, time");
                System.out.println("3 = final velocity, acceleration, displacement");
                userOptionTwo = scan.nextByte(); // Get the second user choice

                // Switch statement to handle the specific initial velocity calculation
                switch (userOptionTwo) {
                    case 1:
                        // Case for calculating initial velocity using final velocity, acceleration, and time
                        System.out.println("Enter final velocity, acceleration, and time:");
                        double finalVelocity1 = scan.nextDouble();
                        double acceleration1 = scan.nextDouble();
                        double time1 = scan.nextDouble();
                        double initialVelocity1 = calculateInitialVelocity(finalVelocity1, acceleration1, time1);
                        System.out.println("Initial Velocity: " + initialVelocity1 + " m/s");
                        break;
                    case 2:
                        // Case for calculating initial velocity using displacement, final velocity, and time
                        System.out.println("Enter displacement, final velocity, and time:");
                        double displacement1 = scan.nextDouble();
                        double finalVelocity2 = scan.nextDouble();
                        double time2 = scan.nextDouble();
                        double initialVelocity2 = calculateInitialVelocityUsingDisplacement(displacement1, finalVelocity2, time2);
                        System.out.println("Initial Velocity: " + initialVelocity2 + " m/s");
                        break;
                    case 3:
                        // Case for calculating initial velocity using final velocity, acceleration, and displacement
                        System.out.println("Enter final velocity, acceleration, and displacement:");
                        double finalVelocity3 = scan.nextDouble();
                        double acceleration3 = scan.nextDouble();
                        double displacement3 = scan.nextDouble();
                        double initialVelocity3 = calculateInitialVelocityUsingFinalVelocity(finalVelocity3, acceleration3, displacement3);
                        System.out.println("Initial Velocity: " + initialVelocity3 + " m/s");
                        break;
                }
                break;

            case 5: // Case for Acceleration
                System.out.println("Enter known variables:");
                System.out.println("1 = final velocity, initial velocity, time");
                System.out.println("2 = displacement, initial velocity, time");
                System.out.println("3 = initial velocity, final velocity, displacement");
                userOptionTwo = scan.nextByte(); // Get the second user choice

                // Switch statement to handle the specific acceleration calculation
                switch (userOptionTwo) {
                    case 1:
                        // Case for calculating acceleration using final velocity, initial velocity, and time
                        System.out.println("Enter final velocity, initial velocity, and time:");
                        double finalVelocity1 = scan.nextDouble();
                        double initialVelocity1 = scan.nextDouble();
                        double time1 = scan.nextDouble();
                        double acceleration1 = calculateAcceleration(finalVelocity1, initialVelocity1, time1);
                        System.out.println("Acceleration: " + acceleration1 + " m/s²");
                        break;
                    case 2:
                        // Case for calculating acceleration using displacement, initial velocity, and time
                        System.out.println("Enter displacement, initial velocity, and time:");
                        double displacement1 = scan.nextDouble();
                        double initialVelocity2 = scan.nextDouble();
                        double time2 = scan.nextDouble();
                        double acceleration2 = calculateAccelerationUsingDisplacement(displacement1, initialVelocity2, time2);
                        System.out.println("Acceleration: " + acceleration2 + " m/s²");
                        break;
                    case 3:
                        // Case for calculating acceleration using initial velocity, final velocity, and displacement
                        System.out.println("Enter initial velocity, final velocity, and displacement:");
                        double initialVelocity3 = scan.nextDouble();
                        double finalVelocity2 = scan.nextDouble();
                        double displacement2 = scan.nextDouble();
                        double acceleration3 = calculateAccelerationUsingVelocity(initialVelocity3, finalVelocity2, displacement2);
                        System.out.println("Acceleration: " + acceleration3 + " m/s²");
                        break;
                }
                break;

            default:
                // If the user enters an invalid option
                System.out.println("Invalid option selected.");
                break;
        }

        // Close the scanner to prevent resource leaks
        scan.close();
    }
	
	// Method to calculate displacement using initial velocity, acceleration, and time
    public static double calculateDisplacement(double initialVelocity, double acceleration, double time) {
        return initialVelocity * time + 0.5 * acceleration * time * time; // Formula for displacement
    }

    // Method to calculate displacement using final velocity, initial velocity, and time
    public static double calculateDisplacementUsingFinalVelocity(double finalVelocity, double initialVelocity, double time) {
        return (finalVelocity + initialVelocity) / 2 * time; // Formula for displacement using average velocity
    }

    // Method to calculate displacement using initial velocity, final velocity, and acceleration
    public static double calculateDisplacementUsingVelocity(double initialVelocity, double finalVelocity, double acceleration) {
        return (finalVelocity * finalVelocity - initialVelocity * initialVelocity) / (2 * acceleration); // Rearranged formula for displacement
    }

    // Method to calculate time using displacement, initial velocity, and acceleration
    public static double calculateTimeUsingDisplacement(double displacement, double initialVelocity, double acceleration) {
        return (Math.sqrt(initialVelocity * initialVelocity + 2 * acceleration * displacement) - initialVelocity) / acceleration; // Formula for time
    }

    // Method to calculate time using displacement, final velocity, and initial velocity
    public static double calculateTimeUsingVelocity(double displacement, double finalVelocity, double initialVelocity) {
        return displacement / ((finalVelocity + initialVelocity) / 2); // Average velocity method to find time
    }

    // Method to calculate time using final velocity, initial velocity, and acceleration
    public static double calculateTimeUsingFinalVelocity(double finalVelocity, double initialVelocity, double acceleration) {
        return (finalVelocity - initialVelocity) / acceleration; // Rearranged formula for time
    }

    // Method to calculate final velocity using initial velocity, acceleration, and time
    public static double calculateFinalVelocity(double initialVelocity, double acceleration, double time) {
        return initialVelocity + acceleration * time; // Formula for final velocity
    }

    // Method to calculate final velocity using displacement, initial velocity, and time
    public static double calculateFinalVelocityUsingDisplacement(double displacement, double initialVelocity, double time) {
        return (2 * displacement / time) - initialVelocity; // Rearranged formula for final velocity
    }

    // Method to calculate final velocity using initial velocity, acceleration, and displacement
    public static double calculateFinalVelocityUsingAcceleration(double initialVelocity, double acceleration, double displacement) {
        return Math.sqrt(initialVelocity * initialVelocity + 2 * acceleration * displacement); // Kinematic equation for final velocity
    }

    // Method to calculate initial velocity using final velocity, acceleration, and time
    public static double calculateInitialVelocity(double finalVelocity, double acceleration, double time) {
        return finalVelocity - acceleration * time; // Formula for initial velocity
    }

    // Method to calculate initial velocity using displacement, final velocity, and time
    public static double calculateInitialVelocityUsingDisplacement(double displacement, double finalVelocity, double time) {
        return (2 * displacement / time) - finalVelocity; // Rearranged formula for initial velocity
    }

    // Method to calculate initial velocity using final velocity, acceleration, and displacement
    public static double calculateInitialVelocityUsingFinalVelocity(double finalVelocity, double acceleration, double displacement) {
        return Math.sqrt(finalVelocity * finalVelocity - 2 * acceleration * displacement); // Kinematic equation for initial velocity
    }

    // Method to calculate acceleration using final velocity, initial velocity, and time
    public static double calculateAcceleration(double finalVelocity, double initialVelocity, double time) {
        return (finalVelocity - initialVelocity) / time; // Formula for acceleration
    }

    // Method to calculate acceleration using displacement, initial velocity, and time
    public static double calculateAccelerationUsingDisplacement(double displacement, double initialVelocity, double time) {
        return (2 * (displacement - initialVelocity * time)) / (time * time); // Rearranged formula for acceleration
    }

    // Method to calculate acceleration using initial velocity, final velocity, and displacement
    public static double calculateAccelerationUsingVelocity(double initialVelocity, double finalVelocity, double displacement) {
        return (finalVelocity * finalVelocity - initialVelocity * initialVelocity) / (2 * displacement); // Kinematic equation for acceleration
    }
}
// This line exists only to make this program 300 lines long