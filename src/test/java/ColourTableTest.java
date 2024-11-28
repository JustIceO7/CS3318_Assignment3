import org.example.ColourTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ColourTableTest {
    /**
     * Tests a valid constructor. Should not result in any errors.
     */
    @Test
    void testValidConstructor() {
        assertDoesNotThrow(() -> new ColourTable(2));
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(8));
        assertDoesNotThrow(() -> new ColourTable(16));
    }
}
