package com.company;

public class Bathroom {

    public int toiletSize;
    public int sinkDiameter;
    public int temperature;
    public String decorationStyle;

    // Constructor

    public Bathroom(int toiletSize, int sinkDiameter, int temperature, String decorationStyle) {
        this.toiletSize = toiletSize;
        this.sinkDiameter = sinkDiameter;
        this.temperature = temperature;
        this.decorationStyle = decorationStyle;
    }

    // Getters and Setters

    public int getToiletSize() {
        return toiletSize;
    }

    public void setToiletSize(int toiletSize) {
        this.toiletSize = toiletSize;
    }

    public int getSinkDiameter() {
        return sinkDiameter;
    }

    public void setSinkDiameter(int sinkDiameter) {
        this.sinkDiameter = sinkDiameter;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getDecorationStyle() {
        return decorationStyle;
    }

    public void setDecorationStyle(String decorationStyle) {
        this.decorationStyle = decorationStyle;
    }
}
