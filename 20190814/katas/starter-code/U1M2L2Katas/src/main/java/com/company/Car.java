package com.company;

public class Car {
    String make;
    String model;
    String type;
    String color;
    String engine;
    String transmission;
    int numDoors;
    double mpg;
    int milesDriven;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public double getMpg() {
        return mpg;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public Car(String makeIn, String modelIn, String typeIn, String colorIn, String engineIn, String transmissionIn, int numDoorsIn,
               double mpgIn, int milesDrivenIn)
    {
        this.make = makeIn;
        this.model = modelIn;
        this.type = typeIn;
        this.color = colorIn;
        this.engine = engineIn;
        this.transmission = transmissionIn;
        this.numDoors = numDoorsIn;
        this.mpg = mpgIn;
        this.milesDriven = milesDrivenIn;
    }
}
