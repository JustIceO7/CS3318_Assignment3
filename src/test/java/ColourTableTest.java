import org.example.ColourTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ColourTable Class.
 */
public class ColourTableTest {
    /**
     * Tests a valid constructor. Should not result in any errors.
     */
    @Test
    void testValidConstructor() {
        assertDoesNotThrow(() -> new ColourTable(2));
    }

    /**
     * Tests an invalid constructor. Should result in IllegalArgumentException Error.
     */
    @Test
    void testInvalidConstructorInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(-1));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(0));
    }

    /**
     * Tests an invalid constructor. Should result in IllegalArgumentException Error.
     */
    @Test
    void testInvalidConstructorNonPowerOfTwoCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5));
    }

    /**
     * Tests getter method for capacity
     */
    @Test
    void testGetCapacity() {
        ColourTable table = new ColourTable(2);
        int actualCapacity = table.getCapacity();
        assertEquals(actualCapacity,2);
    }

    /**
     * Tests getter method for colours
     */
    @Test
    void testGetColours() {
        ColourTable table = new ColourTable(2);
        int[] expectedColours = {0,0};
        int[] actualColours = table.getColours();
        assertArrayEquals(expectedColours,actualColours);
    }

}