import org.example.ColourTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    /**
     * Tests an invalid constructor. Should result in IllegalArgumentException Error.
     */
    @Test
    void testInvalidConstructorInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(-1));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(0));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));
    }
}
