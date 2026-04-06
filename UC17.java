import java.util.Arrays;

public class TrainTypeSorter {
    public static void main(String[] args) {
        // 1. Initialize an array of bogie type names
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("--- UC17: Sorting Bogie Names (Arrays.sort) ---");
        System.out.println("Initial Bogie Types (Unsorted): " + Arrays.toString(bogieTypes));

        // 2. Use Java's built-in optimized sorting utility
        // This replaces the nested loops and swap logic from UC16
        Arrays.sort(bogieTypes);

        // 3. Display the sorted result (Natural Alphabetical Order)
        System.out.println("\nSorted Bogie Types (Alphabetical): " + Arrays.toString(bogieTypes));

        // 4. Verification with a mixed/duplicate list
        String[] mixedBogies = {"Sleeper", "AC Chair", "Sleeper", "General"};
        System.out.println("\nHandling Duplicates:");
        System.out.println("Before: " + Arrays.toString(mixedBogies));
        Arrays.sort(mixedBogies);
        System.out.println("After : " + Arrays.toString(mixedBogies));

        System.out.println("\nProgram continues safely...");
    }
}