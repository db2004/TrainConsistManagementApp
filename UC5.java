import java.util.LinkedHashSet;
import java.util.Set;

public class TrainFormationManager {
    public static void main(String[] args) {
        // 1. Create a LinkedHashSet for the train formation
        // This ensures uniqueness (Set) + insertion order (Linked)
        Set<String> trainFormation = new LinkedHashSet<>();

        System.out.println("--- UC5: Train Formation (LinkedHashSet) ---");

        // 2. Attach bogies in a specific physical sequence
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. Attempt to attach a duplicate bogie (e.g., Sleeper again)
        System.out.println("Action: Attempting to attach duplicate bogie 'Sleeper'...");
        boolean addedAgain = trainFormation.add("Sleeper");

        if (!addedAgain) {
            System.out.println("Status: Duplicate 'Sleeper' blocked! Bogie already in formation.");
        }

        // 4. Display the final formation
        // Notice the order remains: Engine -> Sleeper -> Cargo -> Guard
        System.out.println("\nFinal Train Formation (Ordered & Unique):");
        System.out.println(trainFormation);

        // 5. Demonstrate ordered iteration
        System.out.print("Physical Sequence: ");
        for (String bogie : trainFormation) {
            System.out.print(bogie + " <-> ");
        }
        System.out.println("END");
    }
}