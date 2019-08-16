package com.company;

public class Kitchen {

    public int fridgeWeight;
    public int ovenTemp;
    public String microwaveBrand;
    public String tableShape;

    // Constructor

    public Kitchen(int fridgeWeight, int ovenTemp, String microwaveBrand, String tableShape) {
        this.fridgeWeight = fridgeWeight;
        this.ovenTemp = ovenTemp;
        this.microwaveBrand = microwaveBrand;
        this.tableShape = tableShape;
    }

    // Getters and Setters

    public int getFridgeWeight() {
        return fridgeWeight;
    }

    public void setFridgeWeight(int fridgeWeight) {
        this.fridgeWeight = fridgeWeight;
    }

    public int getOvenTemp() {
        return ovenTemp;
    }

    public void setOvenTemp(int ovenTemp) {
        this.ovenTemp = ovenTemp;
    }

    public String getMicrowaveBrand() {
        return microwaveBrand;
    }

    public void setMicrowaveBrand(String microwaveBrand) {
        this.microwaveBrand = microwaveBrand;
    }

    public String getTableShape() {
        return tableShape;
    }

    public void setTableShape(String tableShape) {
        this.tableShape = tableShape;
    }
}
