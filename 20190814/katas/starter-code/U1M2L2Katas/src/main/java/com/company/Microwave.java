package com.company;

public class Microwave {
    String manufacturer;
    String model;
    int secondsLeft;
    String time;
    boolean running;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public boolean isRunning() {
        return running;
    }

    public Microwave (String manufacturerIn, String modelIn , int secondsLeftIn, String timeIn, boolean runningIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.secondsLeft = secondsLeftIn;
        this.time = timeIn;
        this.running = runningIn;
    }
}
