import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Declare an array that can hold exactly 6 Strings,
    // one for each name of the person who will be scheduled for the appointment at a particular hour.
    public static void main(String[] args) {
        int time, min = 1, max = 6, count = 6;
        String[] names = new String[count];
        Scanner keyboard = new Scanner(System.in);
        // Initialize all slots in array to "[empty]" instead of "null"
        Arrays.fill(names, "[empty]");

            // Print out the array (should be empty) just so they can see the slots
            printArray(names);
            for (int i = 0; i < count; i++) {
                try {
                    System.out.println("\nWhat time (1-6) would you like to schedule an appointment? ");
                    time = keyboard.nextInt();
                    if (time < 1 || time > 6)
                        throw new InvalidTimeException();
                    if (!names[time - 1].equals("[empty]"))
                        throw new TimeInUseException();
                    System.out.print("Enter the name of the person reserving this appointment: ");
                    keyboard.nextLine();
                    names[time - 1] = keyboard.nextLine();
                    // Print the array so the user can see their name in the timeslot
                    printArray(names);
                }
                catch (InvalidTimeException | TimeInUseException | InputMismatchException e) {
                    if (e instanceof InputMismatchException) {
                        System.err.println("Invalid input type. Please try another.");
                    }
                    else { System.out.println(e.getMessage()); }
                }
            }
        }

    // Method to print names just to make main method less cluttered
    public static void printArray(String[] array) {
        System.out.println("\nHere are the current appointments: " +
                "\n[1:00]: " + array[0] +
                "\n[2:00]: " + array[1] +
                "\n[3:00]: " + array[2] +
                "\n[4:00]: " + array[3] +
                "\n[5:00]: " + array[4] +
                "\n[6:00]: " + array[5]);
    }
}