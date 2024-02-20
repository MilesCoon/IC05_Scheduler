public class InvalidTimeException extends Exception {
    public InvalidTimeException () {
        super("This time slot is invalid. Please try another.");
    }
}
