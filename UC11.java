import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainValidationManager {
    public static void main(String[] args) {
        System.out.println("--- UC11: Train ID & Cargo Code Validation (Regex) ---");

        // 1. Define Regex Patterns
        // TRN- followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // PET- followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // 2. Compile Patterns
        Pattern trainPattern = Pattern.compile(trainIdRegex);
        Pattern cargoPattern = Pattern.compile(cargoCodeRegex);

        // 3. Test Inputs (Valid and Invalid)
        String[] testTrainIDs = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-12345"};
        String[] testCargoCodes = {"PET-AB", "PET-ab", "PET-12", "PET-ABC"};

        System.out.println("\n[Testing Train ID Validation]");
        for (String id : testTrainIDs) {
            Matcher matcher = trainPattern.matcher(id);
            if (matcher.matches()) {
                System.out.println("✔ " + id + " : Valid Format");
            } else {
                System.out.println("✘ " + id + " : Invalid Format (Expected TRN-XXXX)");
            }
        }

        System.out.println("\n[Testing Cargo Code Validation]");
        for (String code : testCargoCodes) {
            Matcher matcher = cargoPattern.matcher(code);
            if (matcher.matches()) {
                System.out.println("✔ " + code + " : Valid Format");
            } else {
                System.out.println("✘ " + code + " : Invalid Format (Expected PET-XX)");
            }
        }
    }
}