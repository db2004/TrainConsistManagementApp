import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Reusing the Bogie class from previous UCs
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainPerformanceBenchmarker {
    public static void main(String[] args) {
        // 1. Prepare a large dataset (e.g., 10,000 bogies) to make measurements meaningful
        List<Bogie> largeConsist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeConsist.add(new Bogie("Bogie-" + i, (i % 100))); // Capacities 0-99
        }

        System.out.println("--- UC13: Performance Comparison (Loops vs Streams) ---");
        System.out.println("Dataset Size: " + largeConsist.size() + " bogies");

        // 2. Benchmarking Loop-Based Filtering
        long startTimeLoop = System.nanoTime();
        List<Bogie> filteredByLoop = new ArrayList<>();
        for (Bogie b : largeConsist) {
            if (b.capacity > 60) {
                filteredByLoop.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 3. Benchmarking Stream-Based Filtering
        long startTimeStream = System.nanoTime();
        List<Bogie> filteredByStream = largeConsist.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // 4. Display Results
        System.out.println("\n--- Benchmarking Results ---");
        System.out.println("Loop Execution Time   : " + durationLoop + " ns");
        System.out.println("Stream Execution Time : " + durationStream + " ns");

        // 5. Verification: Result Consistency
        if (filteredByLoop.size() == filteredByStream.size()) {
            System.out.println("\nSUCCESS: Both methods produced identical results ("
                    + filteredByLoop.size() + " bogies).");
        }

        // 6. Analysis
        double factor = (double) durationStream / durationLoop;
        System.out.printf("Stream was %.2fx slower/faster than Loop in this run.%n", factor);
    }
}