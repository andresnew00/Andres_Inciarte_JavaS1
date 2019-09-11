package com.company.AndresInciarteU1M5Summative.Dto;

import java.util.Objects;

public class Publisher {

    private Integer publisherId;
    private String name;
    private String Street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId.equals(publisher.publisherId) &&
                name.equals(publisher.name) &&
                Street.equals(publisher.Street) &&
                city.equals(publisher.city) &&
                state.equals(publisher.state) &&
                postalCode.equals(publisher.postalCode) &&
                phone.equals(publisher.phone) &&
                email.equals(publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, name, Street, city, state, postalCode, phone, email);
    }
}
