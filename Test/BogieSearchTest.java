import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BogieSearchTest {

    BogieSearchManager manager = new BogieSearchManager();

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(manager.binarySearchBogie(bogies, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(manager.binarySearchBogie(bogies, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(manager.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(manager.binarySearchBogie(bogies, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(manager.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogies = {};
        assertFalse(manager.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // System should sort this internally before searching
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(manager.binarySearchBogie(bogies, "BG205"));
    }
}