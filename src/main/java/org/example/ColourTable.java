package org.example;

public class ColourTable {
    private final int[] colours;
    private final int capacity;

    public ColourTable(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1.");
        }
        int test_capacity = capacity;
        while (test_capacity > 1) {
            if (test_capacity % 2 != 0) {
                throw new IllegalArgumentException("Capacity must be a power of 2.");
            }
            test_capacity = test_capacity / 2;
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
