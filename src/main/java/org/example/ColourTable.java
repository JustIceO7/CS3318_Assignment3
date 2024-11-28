package org.example;

public class ColourTable {
    private final int[] colours;
    private int current_index;

    public ColourTable(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1.");
        }
        if (((capacity & (capacity - 1)) != 0)) {
            throw new IllegalArgumentException("Capacity must be a power of 2.");
        }
        this.colours = new int[capacity];
        this.current_index = 0;
    }

    public void add (int hex_colour) {
        if (hex_colour < 0 || hex_colour > 0xFFFFFF) {
            throw new IllegalArgumentException("Invalid RGB values.");
        }
        this.colours[current_index] = hex_colour;
        this.current_index++;
    }
}
