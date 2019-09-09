package com.company.CoffeeInventoryDaoAndresInciarte.model;

import java.util.Objects;

public class Coffee {

    private int coffeeId;
    private int roasterId;
    private String name;
    private int count;
    private double unitPrice;
    private String description;
    private String type;

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(int roasterId) {
        this.roasterId = roasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return coffeeId == coffee.coffeeId &&
                roasterId == coffee.roasterId &&
                count == coffee.count &&
                Double.compare(coffee.unitPrice, unitPrice) == 0 &&
                name.equals(coffee.name) &&
                Objects.equals(description, coffee.description) &&
                Objects.equals(type, coffee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeId, roasterId, name, count, unitPrice, description, type);
    }
}
