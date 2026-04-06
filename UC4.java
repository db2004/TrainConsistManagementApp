import java.util.LinkedList;

public class TrainSequenceManager {
    public static void main(String[] args) {
        // 1. Create a LinkedList to model the physical train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        System.out.println("--- UC4: Ordered Train Consist (LinkedList) ---");

        // 2. Adding bogies to the sequence
        // addLast() ensures they are attached to the end of the current train
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Sequence: " + trainConsist);

        // 3. Insert a Pantry Car at position 2 (after Engine and Sleeper)
        // LinkedList allows efficient insertion at a specific index
        System.out.println("\nAction: Inserting 'Pantry Car' at position 2...");
        trainConsist.add(2, "Pantry Car");
        System.out.println("After Insertion: " + trainConsist);

        // 4. Remove the first and last bogie
        // Simulates uncoupling the Engine and the Guard coach
        System.out.println("\nAction: Detaching Engine (First) and Guard (Last)...");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // 5. Display the final ordered train consist
        System.out.println("Final Ordered Consist: " + trainConsist);
        System.out.println("Current Head of Train: " + trainConsist.peekFirst());
    }
}