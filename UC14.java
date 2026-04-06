// 1. Define a Custom Exception class
// Extending Exception makes this a "Checked Exception"
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 2. Encapsulate validation inside the Bogie class
class PassengerBogie {
    String type;
    int capacity;

    // The constructor now enforces business rules
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            // "Fail-Fast": Stop the object from being created
            throw new InvalidCapacityException("Capacity must be greater than zero. Provided: " + capacity);
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + " (" + capacity + " seats)";
    }
}

public class TrainValidationExceptionManager {
    public static void main(String[] args) {
        System.out.println("--- UC14: Custom Exception Handling (Invalid Capacity) ---");

        // 3. Test Case: Valid Bogie Creation
        try {
            System.out.println("\nAttempting to create a valid bogie...");
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("✔ Success: " + validBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("✘ Error: " + e.getMessage());
        }

        // 4. Test Case: Zero Capacity (Invalid)
        try {
            System.out.println("\nAttempting to create a bogie with 0 capacity...");
            PassengerBogie zeroBogie = new PassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.err.println("✘ Caught Expected Exception: " + e.getMessage());
        }

        // 5. Test Case: Negative Capacity (Invalid)
        try {
            System.out.println("\nAttempting to create a bogie with -10 capacity...");
            PassengerBogie negativeBogie = new PassengerBogie("First Class", -10);
        } catch (InvalidCapacityException e) {
            System.err.println("✘ Caught Expected Exception: " + e.getMessage());
        }
    }
}