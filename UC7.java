import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1. Create a Bogie class to hold multiple attributes
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Overriding toString for easy printing
    @Override
    public String toString() {
        return String.format("%-15s : %d seats", name, capacity);
    }
}

public class TrainCapacitySorter {
    public static void main(String[] args) {
        // 2. Create a List to store Bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();

        System.out.println("--- UC7: Sorting Bogies by Capacity (Comparator) ---");

        // 3. Add passenger bogies with varying capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair Car", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("\nBefore Sorting (Unordered):");
        passengerBogies.forEach(System.out::println);

        // 4. Use Comparator to sort by capacity (Ascending)
        // .comparingInt() creates a rule based on the 'capacity' field
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (Lowest to Highest Capacity):");
        passengerBogies.forEach(System.out::println);

        // 5. Bonus: Sorting in Descending Order (Highest Capacity First)
        passengerBogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("\nAfter Sorting (Highest to Lowest Capacity):");
        passengerBogies.forEach(System.out::println);
    }
}