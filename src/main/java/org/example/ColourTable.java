package org.example;

public class ColourTable {
    private final int[] colours;
    private final int capacity;

    public ColourTable(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1.");
        }
        if (((capacity & (capacity - 1)) != 0)) {
            throw new IllegalArgumentException("Capacity must be a power of 2.");
        }
        this.colours = new int[capacity];
        this.capacity = capacity;
    }


    public int getCapacity() {
        return this.capacity;
    }

    public int[] getColours() {
        return this.colours;
    }

}
