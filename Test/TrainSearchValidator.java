import java.util.ArrayList;
import java.util.List;

public class TrainSearchValidator {

    /**
     * Searches for a bogie ID with defensive state validation.
     * @param bogieList The current consist of the train.
     * @param targetId The ID to look for.
     * @return true if found, false if not found.
     * @throws IllegalStateException if the train consist is empty.
     */
    public boolean searchWithValidation(List<String> bogieList, String targetId) {

        // 1. STATE VALIDATION (Guard Clause)
        // Check if the list is null or empty before proceeding
        if (bogieList == null || bogieList.isEmpty()) {
            throw new IllegalStateException("Search Operation Denied: The train consist is empty. " +
                    "Please attach bogies before searching.");
        }

        // 2. SEARCH LOGIC
        // Execution only reaches here if the state is valid (Fail-Fast)
        for (String id : bogieList) {
            if (id.equals(targetId)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TrainSearchValidator validator = new TrainSearchValidator();
        List<String> emptyTrain = new ArrayList<>();

        System.out.println("--- UC20: Defensive State Validation ---");

        try {
            System.out.println("Scenario: Searching an empty train consist...");
            validator.searchWithValidation(emptyTrain, "BG101");
        } catch (IllegalStateException e) {
            // Catching the exception to display a meaningful error
            System.err.println("ALERT: " + e.getMessage());
        }
    }
}