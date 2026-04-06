import java.util.*;
import java.util.stream.Collectors;

// Reusing the Bogie class structure
class Bogie {
    String type; // e.g., "Sleeper", "AC Chair"
    int id;      // Unique ID for each physical bogie

    Bogie(String type, int id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bogie[ID=" + id + "]";
    }
}

public class TrainGroupingManager {
    public static void main(String[] args) {
        // 1. Initialize a list with multiple bogies of the same type
        List<Bogie> trainYard = new ArrayList<>();
        trainYard.add(new Bogie("Sleeper", 101));
        trainYard.add(new Bogie("Sleeper", 102));
        trainYard.add(new Bogie("AC Chair", 201));
        trainYard.add(new Bogie("First Class", 301));
        trainYard.add(new Bogie("AC Chair", 202));

        System.out.println("--- UC9: Grouping Bogies by Type (Collectors.groupingBy) ---");

        // 2. Apply Grouping Logic using Streams
        // Key: Bogie Type (String), Value: List of Bogies of that type
        Map<String, List<Bogie>> groupedBogies = trainYard.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        // 3. Display the structured output
        System.out.println("\nGenerated Railway Category Report:");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type + " | Total Units: " + list.size());
            System.out.println("   Inventory: " + list);
        });

        // 4. Verification: Original List Integrity
        System.out.println("\nVerification: Original yard count remains " + trainYard.size());
    }
}