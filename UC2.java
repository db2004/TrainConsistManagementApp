import java.util.ArrayList;

public class TrainConsistManager {
    public static void main(String[] args) {
        // 1. Create an ArrayList to store passenger bogies
        ArrayList<String> passengerBogies = new ArrayList<>();

        System.out.println("--- UC2: Train Consist Management (ArrayList Operations) ---");

        // 2. Add bogies: Sleeper, AC Chair, First Class
        // Demonstrates the add() method and Insertion Order Preservation
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion
        System.out.println("Initial Train Consist: " + passengerBogies);

        // 4. Remove one bogie (AC Chair)
        // Demonstrates the remove() method
        System.out.println("\nAction: Removing 'AC Chair' for maintenance...");
        passengerBogies.remove("AC Chair");

        // 5. Use contains() to check if 'Sleeper' exists
        System.out.println("Checking existence of 'Sleeper' bogie...");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Result: Sleeper bogie is present in the consist.");
        } else {
            System.out.println("Result: Sleeper bogie not found.");
        }

        // 6. Print final list state
        System.out.println("\nFinal Train Consist: " + passengerBogies);
        System.out.println("Total Bogies Attached: " + passengerBogies.size());
    }
}