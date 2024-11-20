package org.example;

public class ColourTable {
    private final int[] colours;
    private final int capacity;
    private int current_index;

    public ColourTable(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1.");
        }
        if (((capacity & (capacity - 1)) != 0)) {
            throw new IllegalArgumentException("Capacity must be a power of 2.");
        }
        this.colours = new int[capacity];
        this.capacity = capacity;
        this.current_index = 0;
    }

    public void add(int colour) {
        if (colour < 0 || colour > 0xFFFFFF) {
            throw new IllegalArgumentException("Invalid RGB values.");
        }
        else if (this.current_index == this.capacity) {
            throw new ArrayIndexOutOfBoundsException("Too many colours added limit exceeded!");
        }
        for (int c : this.colours) {
            if (colour == c) {
                throw new IllegalArgumentException("RGB colour already in colours list!");
            }
        }
        this.colours[current_index] = colour;
        this.current_index++;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int[] getColours() {
        return this.colours;
    }

    public int getCurrentIndex() {
        return this.current_index;
    }

}
