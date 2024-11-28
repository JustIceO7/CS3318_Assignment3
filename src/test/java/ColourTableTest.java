import org.example.ColourTable;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /**
     * Tests an invalid constructor. Should result in IllegalArgumentException Error.
     */
    @Test
    void testInvalidConstructorNonPowerOfTwoCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(7));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(11));
    }

    /**
     * Tests adding in valid hex colours.
     */
    @Test
    void testAddValidColourHex() {
        ColourTable table = new ColourTable(2);
        assertDoesNotThrow(() -> table.add(0xFFFFFF));
        assertDoesNotThrow(() -> table.add(0xFFFFF0));
    }

    /**
     * Tests adding in invalid hex colours. Should result in IllegalArgumentException Error.
     */
    @Test
    void testAddInvalidColourHex() {
        ColourTable table = new ColourTable(2);
        assertThrows(IllegalArgumentException.class, () -> table.add(0xFFFFFF0));
        assertThrows(IllegalArgumentException.class, () -> table.add(-1));
    }

    /**
     * Tests adding in too many colours surpassing ColourTable capacity. Should result in ArrayIndexOutOfBoundsException Error.
     */
    @Test
    void testAddTooManyColours() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        table.add(0xFFFFF0);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> table.add(0xFFFF00));
    }

    /**
     * Tests to see if colours array reflects what is added
     */
    @Test
    void testAssertAddedColoursAreInArray() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        table.add(0xFFFFF0);

        int[] colours = table.getColours();
        assertEquals(0xFFFFFF, colours[0]);
        assertEquals(0xFFFFF0, colours[1]);
    }

    /**
     *  Tests adding duplicate colours. Should result in IllegalArgumentException Error.
     */
    @Test
    void testAddingDuplicateColours() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        assertThrows(IllegalArgumentException.class, () -> table.add(0xFFFFFF));
    }

    /**
     * Tests adding colours and seeing if ColoursTracker reflects the correct colours.
     */
    @Test
    void testAddColourCheckingColoursTracker() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        table.add(0xFFFFF0);
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(0xFFFFFF);
        expectedSet.add(0xFFFFF0);
        assertEquals(table.getColoursTracker(), expectedSet);
    }

    /**
     *  Tests adding valid RGB values.
     */
    @Test
    void testAddValidColourRGB() {
        ColourTable table = new ColourTable(8);

        assertDoesNotThrow(() -> table.add(0, 0, 0));
        assertDoesNotThrow(() -> table.add(255, 255, 255));
        assertDoesNotThrow(() -> table.add(123, 123, 123));
    }
}
