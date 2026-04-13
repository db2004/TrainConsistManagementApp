import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrainSearchValidatorTest {

    TrainSearchValidator validator = new TrainSearchValidator();

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        // UC20-TC1: Verifies exception is thrown for empty collection
        List<String> emptyList = new ArrayList<>();
        assertThrows(IllegalStateException.class, () -> {
            validator.searchWithValidation(emptyList, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        // UC20-TC2: Verifies no exception when data is present
        List<String> data = Arrays.asList("BG101", "BG205");
        assertDoesNotThrow(() -> {
            validator.searchWithValidation(data, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        // UC20-TC3: Verifies successful match
        List<String> data = Arrays.asList("BG101", "BG205", "BG309");
        assertTrue(validator.searchWithValidation(data, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        // UC20-TC4: Verifies correct 'false' return when data exists but ID doesn't
        List<String> data = Arrays.asList("BG101", "BG205", "BG309");
        assertFalse(validator.searchWithValidation(data, "BG999"));
    }
}