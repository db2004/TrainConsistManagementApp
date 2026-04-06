// 1. Custom Runtime Exception for operational safety violations
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String id;
    String shape; // "Cylindrical" or "Rectangular"
    String assignedCargo;

    GoodsBogie(String id, String shape) {
        this.id = id;
        this.shape = shape;
    }

    // 2. Method to assign cargo with integrated safety logic
    public void assignCargo(String cargo) {
        System.out.println("\n>>> Initiating cargo assignment for Bogie: " + id + " (" + shape + ")");

        try {
            // Safety Rule: Petroleum MUST be in a Cylindrical bogie
            if (cargo.equalsIgnoreCase("Petroleum") && !shape.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException("CRITICAL SAFETY VIOLATION: Petroleum cannot be loaded into a " + shape + " bogie!");
            }

            this.assignedCargo = cargo;
            System.out.println("SUCCESS: " + cargo + " successfully loaded into " + id);

        } catch (CargoSafetyException e) {
            // 3. Catch block: Handle the error gracefully without crashing the app
            System.err.println("ALARM: " + e.getMessage());
            System.out.println("ACTION: Assignment aborted. Please check hazardous materials protocols.");

        } finally {
            // 4. Finally block: Mandatory execution (logging/sensor reset)
            System.out.println("SYSTEM LOG: Safety check sequence completed for " + id + ".");
        }
    }
}

public class CargoSafetyManager {
    public static void main(String[] args) {
        System.out.println("--- UC15: Safe Cargo Assignment (try-catch-finally) ---");

        // Create different bogie types
        GoodsBogie tankCar = new GoodsBogie("TNK-501", "Cylindrical");
        GoodsBogie boxCar = new GoodsBogie("BOX-902", "Rectangular");

        // Test Case 1: Valid Assignment
        tankCar.assignCargo("Petroleum");

        // Test Case 2: Unsafe Assignment (Triggers Exception)
        boxCar.assignCargo("Petroleum");

        // Test Case 3: Valid Assignment to prove program didn't crash
        boxCar.assignCargo("Coal");

        System.out.println("\n--- Final Operational Summary ---");
        System.out.println("All tasks processed. System Status: ONLINE");
    }
}