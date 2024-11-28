package org.example;

import java.util.HashSet;
import java.util.Set;

public class ColourTable {
    private final int[] colours;
    private int current_index;
    private final Set<Integer> coloursTracker;


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

    private void updateTable(int colour) {
        this.colours[current_index] = colour;
        this.coloursTracker.add(colour);
        this.current_index++;
    }

    private boolean isValidRGB(int r, int g, int b) {
        return !(r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255);
    }

    private boolean isValidHex(int hexadecimal) {
        return !(hexadecimal < 0 || hexadecimal > 0xFFFFFF);
    }

    public int[] getColours() {
        return this.colours;
    }

    public Set<Integer> getColoursTracker() {
        return this.coloursTracker;
    }
}
