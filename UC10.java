import java.util.ArrayList;
import java.util.List;

// Reusing the Bogie class structure
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainCapacityAggregator {
    public static void main(String[] args) {
        // 1. Initialize the list of bogies (The Train Consist)
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainYard.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair Car", 56));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("General", 90));

        System.out.println("--- UC10: Total Seat Aggregation (Stream.reduce) ---");
        System.out.println("Current Train Consist: " + trainConsist);

        // 2. Perform Reduction Pipeline
        // Step A: stream() - Start the pipeline
        // Step B: map() - Extract only the capacity (Integer) from the Bogie object
        // Step C: reduce() - Sum all extracted integers starting from 0
        int totalSeats = trainConsist.stream()
                .map(b -> b.capacity)           // Transformation
                .reduce(0, Integer::sum);       // Aggregation (Identity, Accumulator)

        // 3. Display the final metric
        System.out.println("\n--- Operational Analytics ---");
        System.out.println("Total Passenger Capacity: " + totalSeats + " seats");

        // 4. Verification: Original List Integrity
        System.out.println("Verification: Original consist count remains " + trainConsist.size());
    }
}