package com.company.AndresInciarteU1M5Summative.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Author {

    private Integer authorId;
    @NotEmpty(message = "First Name can not be empty")
    @Size(max = 50)
    private String firstName;
    @NotEmpty(message = "Last Name can not be empty")
    @Size(max = 50)
    private String LastName;
    @NotEmpty(message = "Street Name can not be empty")
    @Size(max = 50)
    private String street;
    @NotEmpty(message = "City can not be empty")
    @Size(max = 50)
    private String city;
    @NotEmpty(message = "State can not be empty")
    @Size(max = 2, message = "State must be provided in 2 letter format ex. GA")
    private String state;
    @NotEmpty(message = "Postal Code can not be empty")
    @Size(max = 25)
    private String postalCode;
    @NotEmpty(message = "Phone can not be empty")
    @Size(max = 15)
    private String phone;
    @NotEmpty(message = "Email can not be empty")
    @Size(max = 60)
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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
        Author author = (Author) o;
        return authorId.equals(author.authorId) &&
                firstName.equals(author.firstName) &&
                LastName.equals(author.LastName) &&
                street.equals(author.street) &&
                city.equals(author.city) &&
                state.equals(author.state) &&
                postalCode.equals(author.postalCode) &&
                phone.equals(author.phone) &&
                email.equals(author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, LastName, street, city, state, postalCode, phone, email);
    }
}
