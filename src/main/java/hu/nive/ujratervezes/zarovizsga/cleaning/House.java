package hu.nive.ujratervezes.zarovizsga.cleaning;

import hu.nive.ujratervezes.zarovizsga.cleaning.Cleanable;

public class House implements Cleanable {

    private String address;
    private int size;

    public House(String address, int size) {
        this.address = address;
        this.size = size;
    }

    @Override
    public int clean() {
        return size * 80;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getSize() {
        return size;
    }
}
