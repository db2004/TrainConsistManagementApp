import java.util.ArrayList;
import java.util.List;

/**
 * UC20: Defensive State Validation
 * Ensures the system fails fast if the train state is invalid.
 */
public class DefensiveSearchManager {

    public static void main(String[] args) {
        // Initialize an empty list (Invalid State for searching)
        List<String> emptyConsist = new ArrayList<>();

        System.out.println("--- UC20: Defensive State Validation (Fail-Fast) ---");

        try {
            System.out.println("Attempting to search in an empty consist...");
            // This call should trigger the guard clause
            findBogieInTrain(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            // Catching the state error defined in the guard clause
            System.err.println("CRITICAL ERROR: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely after handling the state error.");
    }

    /**
     * Searches for a bogie ID but validates the train state first.
     * @param consist List of bogie IDs
     * @param targetId ID to search for
     * @throws IllegalStateException if the train has no bogies.
     */
    public static void findBogieInTrain(List<String> consist, String targetId) {
        // GUARD CLAUSE: Defensive Validation
        if (consist == null || consist.isEmpty()) {
            throw new IllegalStateException("Search Operation Denied: The train consist is empty. " +
                    "Please attach bogies before searching.");
        }

        // Search logic only runs if the state is valid
        for (String id : consist) {
            if (id.equals(targetId)) {
                System.out.println("Bogie " + targetId + " found!");
                return;
            }
        }
        System.out.println("Bogie " + targetId + " not found.");
    }
}