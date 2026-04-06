import java.util.Arrays;

public class TrainBogieSorter {
    public static void main(String[] args) {
        // 1. Initialize an array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 90, 40};

        System.out.println("--- UC16: Manual Sorting (Bubble Sort Algorithm) ---");
        System.out.println("Initial Capacities (Unsorted): " + Arrays.toString(capacities));

        // 2. Perform Bubble Sort Algorithm
        bubbleSort(capacities);

        // 3. Display the final sorted result
        System.out.println("\nFinal Capacities (Sorted): " + Arrays.toString(capacities));
        System.out.println("Program continues...");
    }

    /**
     * Manual implementation of Bubble Sort
     * Time Complexity: O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int swapCount = 0;

        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization flag

            // Inner loop for adjacent comparisons
            // (n - i - 1) because the largest elements "bubble" to the end each pass
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 4. Swapping Logic
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    swapCount++;
                }
            }

            // 5. Optimization: If no two elements were swapped in a pass, array is sorted
            if (!swapped) break;

            System.out.println("After Pass " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println("\nTotal swaps performed: " + swapCount);
    }
}