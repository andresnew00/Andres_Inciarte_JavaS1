package com.company.AndresInciarteU1M5Summative.Dto;

import java.util.Objects;

public class Author {

    private Integer authorId;
    private String firstName;
    private String street;
    private String city;
    private String state;
    private String phone;
    private String email;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        Author author = (Author) o;
        return authorId.equals(author.authorId) &&
                firstName.equals(author.firstName) &&
                street.equals(author.street) &&
                city.equals(author.city) &&
                state.equals(author.state) &&
                phone.equals(author.phone) &&
                email.equals(author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, street, city, state, phone, email);
    }

}
