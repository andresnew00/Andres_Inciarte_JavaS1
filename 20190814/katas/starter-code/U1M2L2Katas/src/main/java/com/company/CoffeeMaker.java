package com.company;

public class CoffeeMaker {
    String manufacturer;
    String model;
    int carafeSize;
    int cupsLeft;
    boolean powered;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }

    public boolean isPowered() {
        return powered;
    }

    public CoffeeMaker( String manufacturerIn, String modelIn, int carafeSizeIn, int cupsLeftIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.carafeSize = carafeSizeIn;
        this.cupsLeft = cupsLeftIn;
        this.powered = poweredIn;
    }
}
