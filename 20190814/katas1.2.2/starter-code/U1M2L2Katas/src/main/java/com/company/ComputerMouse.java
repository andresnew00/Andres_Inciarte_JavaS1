package com.company;

public class ComputerMouse {
    String manufacturer;
    String model;
    int xPosition;
    int yPosition;
    int[] lastClickedLocation;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }

    public ComputerMouse(String manufacturerId, String modelId, int xPositionId, int yPositionId, int[] lastClickedLocationId) {
        this.manufacturer = manufacturerId;
        this.model = modelId;
        this.xPosition = xPositionId;
        this.yPosition = yPositionId;
        this.lastClickedLocation = lastClickedLocationId;
    }
}
