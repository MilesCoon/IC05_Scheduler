public class TimeInUseException extends Exception {
    public TimeInUseException() {
        super("Time slot is already taken. Please try another.");
    }
}
