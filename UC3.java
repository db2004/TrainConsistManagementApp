import java.util.HashSet;
import java.util.Set;

public class BogieIDTracker {
    public static void main(String[] args) {
        // 1. Create a HashSet to store unique Bogie IDs
        // HashSet does not allow duplicate values
        Set<String> bogieIDs = new HashSet<>();

        System.out.println("--- UC3: Unique Bogie ID Tracking (HashSet) ---");

        // 2. Adding bogie IDs to the set
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");

        // 3. Intentionally adding a duplicate ID
        System.out.println("Attempting to add duplicate ID: BG101...");
        boolean isAdded = bogieIDs.add("BG101");

        if (!isAdded) {
            System.out.println("Constraint Violated: Bogie BG101 already exists. Entry ignored.");
        }

        // 4. Print the final set
        // Note: The order of output may differ from insertion order (Unordered Storage)
        System.out.println("\nFinal Unique Bogie IDs: " + bogieIDs);
        System.out.println("Total Unique Bogie Count: " + bogieIDs.size());
    }
}