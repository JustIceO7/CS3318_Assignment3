import org.example.ColourTable;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * Tests adding a valid rgb colour. Should not result in any errors.
     */
    @Test
    void testAddValidColourHex() {
        ColourTable table = new ColourTable(2);
        assertDoesNotThrow(() -> table.add(0xFFFFFF));
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
     * Tests adding duplicate colours and seeing if ColourTable reflects the correct data.
     */
    @Test
    void testAddDuplicateColourCheckingColours() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        table.add(0xFFFFFF);
        int[] expectedColours = new int[]{0xFFFFFF,0};
        assertArrayEquals(table.getColours(), expectedColours);
    }

    /**
     * Tests adding duplicate colours and seeing if ColoursTracker reflects the correct data.
     */
    @Test
    void testAddDuplicateColourCheckingColoursTracker() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        table.add(0xFFFFFF);
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(0xFFFFFF);
        assertEquals(table.getColoursTracker(), expectedSet);
    }

    /**
     * Tests adding in invalid rgb colours. Should result in IllegalArgumentException Error.
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
     * Tests getter method for current_index
     */
    @Test
    void testGetCurrentIndex() {
        ColourTable table = new ColourTable(2);
        int actualIndex1 = table.getCurrentIndex();
        assertEquals(actualIndex1,0);
        table.add(0xFFFFFF);
        int actualIndex2 = table.getCurrentIndex();
        assertEquals(actualIndex2,1);
    }

    /**
     * Tests getter method of coloursTracker
     */
    @Test
    void testGetColoursTracker() {
        ColourTable table = new ColourTable(2);
        Set<Integer> expectedSet = new HashSet<>();
        Set<Integer> actualSet = table.getColoursTracker();

        assertEquals(expectedSet, actualSet);
    }

    /**
     * Tests to see if coloursTracker set reflects what is added
     */
    @Test
    void testAssertAddedColoursAreInSet() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        table.add(0xFFFFF0);

        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(0xFFFFFF);
        expectedSet.add(0xFFFFF0);

        assertEquals(expectedSet, table.getColoursTracker());
    }

    /**
     *  Tests adding negative RGB. Should result in ArrayIndexOutOfBoundsException Error.
     */
    @Test
    void testAddInvalidColourNegativeRGB() {
        ColourTable table = new ColourTable(8);

        assertThrows(IllegalArgumentException.class, () -> table.add(-1, 50, 50));
        assertThrows(IllegalArgumentException.class, () -> table.add(50, -1, 50));
        assertThrows(IllegalArgumentException.class, () -> table.add(50, 50, -1));
    }

    /**
     *  Tests adding out of range RGB values. Should result in ArrayIndexOutOfBoundsException Error.
     */
    @Test
    void testAddInvalidColourOutOfRangeRGB() {
        ColourTable table = new ColourTable(8);

        assertThrows(IllegalArgumentException.class, () -> table.add(256, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> table.add(1, 256, 1));
        assertThrows(IllegalArgumentException.class, () -> table.add(1, 1, 256));
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

    /**
     *  Tests isFull method
     */
    @Test
    void testIsFull() {
        ColourTable table = new ColourTable(2);

        table.add(0xFFFFFF);
        assertFalse(table.isFull());

        table.add(0xFFFF00);
        assertTrue(table.isFull());
    }
}

