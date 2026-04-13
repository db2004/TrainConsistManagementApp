import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test; // Added missing import
import org.junit.jupiter.api.DisplayName; // Added missing import
import java.util.ArrayList; // Added missing import
import java.util.Arrays; // Added missing import
import java.util.List; // Added missing import

class DefensiveSearchManagerTest {

    @Test
    @DisplayName("UC20-TC1: Should throw IllegalStateException when consist is empty")
    void testFindBogie_EmptyList_ShouldThrowException() {
        // Arrange
        List<String> emptyConsist = new ArrayList<>();
        String target = "BG101";

        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            DefensiveSearchManager.findBogieInTrain(emptyConsist, target);
        });

        // Verify the specific error message
        String expectedMessage = "Search Operation Denied: The train consist is empty.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    @DisplayName("UC20-TC2: Should throw IllegalStateException when consist is null")
    void testFindBogie_NullList_ShouldThrowException() {
        // Arrange
        List<String> nullConsist = null;

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            DefensiveSearchManager.findBogieInTrain(nullConsist, "BG101");
        });
    }

    @Test
    @DisplayName("UC20-TC3: Should proceed normally when consist has data")
    void testFindBogie_ValidList_ShouldNotThrowException() {
        // Arrange
        List<String> validConsist = Arrays.asList("BG101", "BG202", "BG303");

        // Act & Assert
        // This ensures no exception is thrown during the search
        assertDoesNotThrow(() -> {
            DefensiveSearchManager.findBogieInTrain(validConsist, "BG101");
        });
    }
}