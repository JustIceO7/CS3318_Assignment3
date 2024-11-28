package org.example;

public class ColourTable {
    private final int[] colours;

    public ColourTable(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1.");
        }
        this.colours = new int[capacity];
    }
}
