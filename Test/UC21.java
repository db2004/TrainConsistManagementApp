import java.util.Arrays;

public class BogieSearchManager {

    /**
     * Performs Binary Search on Bogie IDs.
     * Precondition: The array must be sorted.
     */
    public boolean binarySearchBogie(String[] bogies, String searchKey) {
        // Defensive check for empty or null arrays
        if (bogies == null || bogies.length == 0) {
            return false;
        }

        // Requirement: Ensure data is sorted for Binary Search
        Arrays.sort(bogies);

        int low = 0;
        int high = bogies.length - 1;

        while (low <= high) {
            // Find the middle index
            int mid = low + (high - low) / 2;

            // Compare searchKey with middle element lexicographically
            int comparison = searchKey.compareTo(bogies[mid]);

            if (comparison == 0) {
                return true; // Match Found
            } else if (comparison > 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return false; // Range exhausted, element not found
    }

    public static void main(String[] args) {
        BogieSearchManager manager = new BogieSearchManager();
        String[] inventory = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String target = "BG309";

        System.out.println("--- UC19: Binary Search for Bogie ID ---");
        boolean found = manager.binarySearchBogie(inventory, target);

        System.out.println("Search Key: " + target);
        System.out.println("Result: " + (found ? "Bogie Found in System" : "Bogie Not Found"));
    }
}