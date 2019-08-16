package com.company;

import com.company.interfaces.Vehicle;

public class Car implements Vehicle {

    public String make;
    public String model;

    public String getMake() {
        return make;
    }


    public void drive(int miles) {

    }


    public void displayMilesTraveled() {

    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilesTravelled() {
        return milesTravelled;
    }

    public void setMilesTravelled(int milesTravelled) {
        this.milesTravelled = milesTravelled;
    }

    public int milesTravelled;
}
