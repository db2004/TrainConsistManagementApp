import java.util.Arrays;

public class TrainBogieBinarySearcher {
    public static void main(String[] args) {
        // 1. PRECONDITION: The array MUST be sorted for Binary Search to work
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550", "BG601", "BG700"};

        System.out.println("--- UC19: Optimized Lookup (Binary Search) ---");
        System.out.println("Sorted Consist IDs: " + Arrays.toString(bogieIDs));

        String searchKey = "BG550";
        System.out.println("\nSearching for Bogie ID: " + searchKey);

        // 2. Execute Binary Search Logic
        int resultIndex = performBinarySearch(bogieIDs, searchKey);

        // 3. Display Results
        if (resultIndex != -1) {
            System.out.println("RESULT: Bogie " + searchKey + " found at Index " + resultIndex);
        } else {
            System.out.println("RESULT: Bogie " + searchKey + " not found in the consist.");
        }
    }

    /**
     * Binary Search Logic
     * Time Complexity: O(log n)
     */
    public static int performBinarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        int steps = 0;

        while (low <= high) {
            steps++;
            // Find the middle index
            int mid = low + (high - low) / 2;

            // Compare the key with the middle element lexicographically
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                System.out.println("Log: Match found in " + steps + " steps.");
                return mid; // Key found
            } else if (comparison > 0) {
                // Key is in the upper half
                low = mid + 1;
            } else {
                // Key is in the lower half
                high = mid - 1;
            }
        }

        System.out.println("Log: Search exhausted after " + steps + " steps.");
        return -1; // Key not found
    }
}