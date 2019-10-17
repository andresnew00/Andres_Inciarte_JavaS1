package com.company.AndresInciarteU1Capstone.Dto;

import javax.validation.constraints.*;
import java.util.Objects;

public class UserPurchaseInfo {

    @NotNull
    @Size(max = 80, message = "Name must be less than 80 characters long")
    private String name;
    @NotNull
    @Size(max = 30, message = "Title must be less than 30 characters long")
    private String street;
    @NotNull
    @Size(max = 30, message = "Title must be less than 30 characters long")
    private String city;
    @NotNull
    @Size(max = 2, message = "Please enter enter state in 2 char format ex. 'TX' ")
    private String state;
    @NotNull
    @Size(max = 5, message = "Zipcode must be less or 5 characters long")
    private String zipcode;
    @NotNull
    @Size(max = 20, message = "itemType must be less than 20 characters long")
    private String itemType;
    @NotNull
    @PositiveOrZero
    private int itemId;
    @NotNull
    @Min(0)
    private int quantity;

    public UserPurchaseInfo(String name, String street, String city, String state, String zipcode, String itemType, int itemId, int quantity) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.itemType = itemType;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public UserPurchaseInfo(){}

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
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPurchaseInfo that = (UserPurchaseInfo) o;
        return itemId == that.itemId &&
                quantity == that.quantity &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipcode.equals(that.zipcode) &&
                itemType.equals(that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, city, state, zipcode, itemType, itemId, quantity);
    }
}
