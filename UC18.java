import java.util.Scanner;

public class TrainBogieSearcher {
    public static void main(String[] args) {
        // 1. Initialize an array of Bogie IDs (Unsorted)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.println("--- UC18: Locating Bogie ID (Linear Search) ---");
        System.out.println("Current Consist IDs: " + java.util.Arrays.toString(bogieIDs));

        // 2. Define the search key (In a real app, this could come from Scanner)
        String searchKey = "BG309";
        System.out.println("\nSearching for Bogie ID: " + searchKey);

        // 3. Perform Linear Search
        boolean isFound = performLinearSearch(bogieIDs, searchKey);

        // 4. Display Results
        if (isFound) {
            System.out.println("RESULT: Bogie " + searchKey + " located in the consist.");
        } else {
            System.out.println("RESULT: Bogie " + searchKey + " not found. Check the ID and try again.");
        }

        // 5. Test Case: Searching for a non-existent ID
        String missingKey = "BG999";
        System.out.println("\nSearching for Bogie ID: " + missingKey);
        if (performLinearSearch(bogieIDs, missingKey)) {
            System.out.println("RESULT: Bogie " + missingKey + " located.");
        } else {
            System.out.println("RESULT: Bogie " + missingKey + " not found.");
        }
    }

    /**
     * Linear Search Logic
     * Time Complexity: O(n)
     */
    public static boolean performLinearSearch(String[] arr, String key) {
        // Sequential Traversal: Visit every element from index 0 to n-1
        for (int i = 0; i < arr.length; i++) {
            // Equality Comparison using equals() for Strings
            if (arr[i].equals(key)) {
                System.out.println("Log: Match found at position " + (i + 1));
                return true; // Early Termination: Stop as soon as we find it
            }
        }
        return false; // Traversed entire list without a match
    }
}