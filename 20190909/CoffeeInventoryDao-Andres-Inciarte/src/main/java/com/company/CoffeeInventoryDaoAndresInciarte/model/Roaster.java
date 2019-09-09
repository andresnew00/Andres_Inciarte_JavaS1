package com.company.CoffeeInventoryDaoAndresInciarte.model;

import java.util.Objects;

public class Roaster {
    //    This project is a DAO and relational database that keeps track of coffee in inventory.
//
//            * Your DAO API must allow callers to create, read, read all, update, and delete Coffees
//            and Roasters in the system. The system must also allow callers to find Coffees by Roaster
//            Id and Coffees by Type.
//            * Your solution must be based on the database created by the SQL script below.

    private int roasterId;
    private String name;
    private String street;
    private String city;
    private String State;
    private String postalCode;
    private String phone;
    private String email;
    private String note;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return roasterId == roaster.roasterId &&
                name.equals(roaster.name) &&
                street.equals(roaster.street) &&
                city.equals(roaster.city) &&
                State.equals(roaster.State) &&
                postalCode.equals(roaster.postalCode) &&
                phone.equals(roaster.phone) &&
                email.equals(roaster.email) &&
                Objects.equals(note, roaster.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roasterId, name, street, city, State, postalCode, phone, email, note);
    }
}
