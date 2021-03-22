package hu.nive.ujratervezes.zarovizsga.cleaning;

import hu.nive.ujratervezes.zarovizsga.cleaning.Cleanable;

public class Office implements Cleanable {
    private String address;
    private int size;
    private int level;

    public Office(String address, int size, int level) {
        this.address = address;
        this.size = size;
        this.level = level;
    }

    @Override
    public int clean() {
        return size * level * 100;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }
}
