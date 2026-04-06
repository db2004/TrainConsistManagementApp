import java.util.HashMap;
import java.util.Map;

public class BogieCapacityMapper {
    public static void main(String[] args) {
        // 1. Create a HashMap to store Bogie Name (Key) and Capacity (Value)
        // Key: String (Bogie Name), Value: Integer (Seat/Load Capacity)
        HashMap<String, Integer> bogieCapacities = new HashMap<>();

        System.out.println("--- UC6: Bogie Capacity Mapping (HashMap) ---");

        // 2. Use put() to map bogies to their respective capacities
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair Car", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("General", 90);

        // 3. Fast Lookup Example
        // HashMap allows O(1) retrieval of values using the key
        String searchBogie = "Sleeper";
        System.out.println("Checking capacity for: " + searchBogie);
        System.out.println("Capacity: " + bogieCapacities.get(searchBogie) + " seats.");

        // 4. Iterate over the map using entrySet()
        // This allows us to see both the Key and the Value at the same time
        System.out.println("\n--- Current Inventory & Capacities ---");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue() + " seats");
        }

        // 5. Final State Summary
        System.out.println("\nTotal Unique Bogie Types Tracked: " + bogieCapacities.size());
    }
}