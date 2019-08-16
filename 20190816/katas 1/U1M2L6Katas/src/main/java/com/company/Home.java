package com.company;

public class Home {
    public String address;
    public int length;
    public int width;
    public int SquareFootage;

    public boolean Opendoor(){
        return false;
    }

    public boolean hasOwner(){
        return true;
    }

    // rooms composition
    public LaundryRoom laundryRoom;
    public Bathroom bathroom;
    public Kitchen kitchen;
    public Patio patio;

    // Getters and Setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSquareFootage() {
        return SquareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        SquareFootage = squareFootage;
    }

}
