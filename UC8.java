import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Reusing the Bogie class structure from UC7
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("%-15s : %d seats", name, capacity);
    }
}

public class TrainStreamFilter {
    public static void main(String[] args) {
        // 1. Initialize the list of passenger bogies
        List<Bogie> allBogies = new ArrayList<>();
        allBogies.add(new Bogie("Sleeper", 72));
        allBogies.add(new Bogie("AC Chair Car", 56));
        allBogies.add(new Bogie("First Class", 24));
        allBogies.add(new Bogie("General", 90));

        System.out.println("--- UC8: Filtering Bogies using Streams ---");
        System.out.println("Full Consist:");
        allBogies.forEach(System.out::println);

        // 2. Define the Capacity Threshold
        int threshold = 60;
        System.out.println("\nAction: Filtering bogies with capacity > " + threshold + "...");

        // 3. Apply Stream Pipeline: stream() -> filter() -> collect()
        List<Bogie> highCapacityBogies = allBogies.stream()
                .filter(b -> b.capacity > threshold) // The condition (Predicate)
                .collect(Collectors.toList());      // Converting back to a List

        // 4. Display the Filtered Results
        if (highCapacityBogies.isEmpty()) {
            System.out.println("Result: No bogies match the criteria.");
        } else {
            System.out.println("Filtered High-Capacity Bogies:");
            highCapacityBogies.forEach(System.out::println);
        }

        // 5. Verify Original List Integrity (Requirement)
        System.out.println("\nVerification: Original list size is still " + allBogies.size());
    }
}