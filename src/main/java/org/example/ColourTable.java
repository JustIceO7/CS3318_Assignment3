package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 *  ColourTable represents a colour pallet used to keep track of colours.
 */
public class ColourTable {
    private final int[] colours;
    private int current_index;
    private final Set<Integer> coloursTracker;


    /**
     *  Constructor for ColourTable Class
     *
     * @param capacity      size of the ColourTable (must be greater than 1 and in powers of 2).
     */
    public ColourTable(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1.");
        }
        if (((capacity & (capacity - 1)) != 0)) {
            throw new IllegalArgumentException("Capacity must be a power of 2.");
        }
        this.colours = new int[capacity];
        this.current_index = 0;
        this.coloursTracker = new HashSet<>();
    }

    /**
     *  Adds colour into ColourTable using RGB format.
     *
     * @param r             red (0-255).
     * @param g             green (0-255).
     * @param b             blue (0-255).
     */
    public void add(int r, int g, int b) {
        if (!this.isValidRGB(r,g,b)) {
            throw new IllegalArgumentException("Invalid RGB values.");
        }
        if (this.current_index >= this.colours.length) {
            throw new ArrayIndexOutOfBoundsException("Too many colours added limit exceeded!");
        }
        int colour = (r << 16) | (g << 8) | b;
        if (this.coloursTracker.contains(colour)) {
            throw new IllegalArgumentException("Duplicate colour detected.");
        }
        this.updateTable(colour);
    }

    /**
     *  Adds colour into ColourTable in hexadecimal format (0x000000-0xFFFFFF).
     *
     * @param hex_colour    hexadecimal value.
     */
    public void add (int hex_colour) {
        if (!this.isValidHex(hex_colour))  {
            throw new IllegalArgumentException("Invalid hexadecimal values.");
        }
        if (this.current_index >= this.colours.length) {
            throw new ArrayIndexOutOfBoundsException("Too many colours added limit exceeded!");
        }
        if (this.coloursTracker.contains(hex_colour)) {
            throw new IllegalArgumentException("Duplicate colour detected.");
        }
        this.updateTable(hex_colour);
    }

    /**
     *  Updates data for ColourTable.
     *
     * @param colour        colour to be added.
     */
    private void updateTable(int colour) {
        this.colours[current_index] = colour;
        this.coloursTracker.add(colour);
        this.current_index++;
    }

    /**
     *  Checks if given RGB is valid.
     *
     * @param r             red (0-255).
     * @param g             green (0-255).
     * @param b             blue (0-255).
     * @return              {@code true} if given RGB is valid, else {@code false}.
     */
    private boolean isValidRGB(int r, int g, int b) {
        return !(r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255);
    }

    /**
     *  Checks if given hexadecimal is valid.
     *
     * @param hexadecimal   hexadecimal value .
     * @return              {@code true} if given hexadecimal is valid, else {@code false}.
     */
    private boolean isValidHex(int hexadecimal) {
        return !(hexadecimal < 0 || hexadecimal > 0xFFFFFF);
    }

    /**
     *  Returns the current colour pallet.
     *
     * @return              {@code int[]} representing the colours.
     */
    public int[] getColours() {
        return this.colours;
    }

    /**
     *  Returns set of all colours within the colour pallet.
     *
     * @return              {@link Set} representing the colours.
     */
    public Set<Integer> getColoursTracker() {
        return this.coloursTracker;
    }
}
