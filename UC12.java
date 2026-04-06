import java.util.ArrayList;
import java.util.List;

// 1. Define the GoodsBogie class with safety-critical attributes
class GoodsBogie {
    String type;  // e.g., "Cylindrical", "Rectangular", "Open"
    String cargo; // e.g., "Petroleum", "Coal", "Grain"

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "[" + type + " carrying " + cargo + "]";
    }
}

public class TrainSafetyInspector {
    public static void main(String[] args) {
        // 2. Prepare a list of goods bogies (The Freight Consist)
        List<GoodsBogie> freightTrain = new ArrayList<>();
        freightTrain.add(new GoodsBogie("Rectangular", "Coal"));
        freightTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        freightTrain.add(new GoodsBogie("Open", "Grain"));

        System.out.println("--- UC12: Safety Compliance Check (allMatch) ---");
        System.out.println("Inspecting Consist: " + freightTrain);

        // 3. Apply Safety Rule Logic using allMatch()
        // Rule: IF type is "Cylindrical", THEN cargo MUST be "Petroleum"
        boolean isSafe = freightTrain.stream().allMatch(bogie -> {
            if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                return bogie.cargo.equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies pass this specific rule automatically
        });

        // 4. Display Results
        System.out.println("\n--- Safety Inspection Report ---");
        if (isSafe) {
            System.out.println("STATUS: COMPLIANT");
            System.out.println("RESULT: All bogies meet safety standards. Train is cleared for departure.");
        } else {
            System.out.println("STATUS: CRITICAL VIOLATION");
            System.out.println("RESULT: Safety breach detected! Unsafe cargo assignment in cylindrical bogie.");
        }

        // 5. Demonstrate a failure case
        System.out.println("\n[Simulating Unsafe Loading...]");
        freightTrain.add(new GoodsBogie("Cylindrical", "Coal")); // Illegal combination!

        boolean isSafeNow = freightTrain.stream().allMatch(bogie ->
                !bogie.type.equalsIgnoreCase("Cylindrical") || bogie.cargo.equalsIgnoreCase("Petroleum")
        );

        System.out.println("Updated Status: " + (isSafeNow ? "COMPLIANT" : "VIOLATION DETECTED"));
    }
}