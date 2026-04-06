import java.util.ArrayList;
import java.util.List;

public class DefensiveSearchManager {
    public static void main(String[] args) {
        // 1. Initialize an empty list to simulate an unassigned train
        List<String> emptyConsist = new ArrayList<>();

        System.out.println("--- UC20: Defensive State Validation (Fail-Fast) ---");

        try {
            System.out.println("Attempting to search in an empty consist...");
            // 2. Trigger the search operation
            findBogieInTrain(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            // 3. Catch the state-related error
            System.err.println("CRITICAL ERROR: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely after handling the state error.");
    }

    /**
     * Searches for a bogie ID but validates the train state first.
     * @throws IllegalStateException if the train has no bogies.
     */
    public static void findBogieInTrain(List<String> consist, String targetId) {
        // 4. State Validation (Defensive Programming)
        if (consist == null || consist.isEmpty()) {
            throw new IllegalStateException("Search Operation Denied: The train consist is empty. " +
                    "Please attach bogies before searching.");
        }

        // 5. If state is valid, search logic proceeds (Linear Search example)
        for (String id : consist) {
            if (id.equals(targetId)) {
                System.out.println("Bogie found!");
                return;
            }
        }
        System.out.println("Bogie not found.");
    }
}