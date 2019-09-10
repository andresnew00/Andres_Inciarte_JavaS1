package com.company.AndresInciarteCoffeeInventoryJpaRepository.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "roaster")
public class Roaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roasterId;
    private String name;
    private String street;
    private String city;
    private String State;
    private String postalCode;
    private String phone;
    private String email;
    private String note;

    public Integer getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(Integer roasterId) {
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
        return Objects.equals(roasterId, roaster.roasterId) &&
                Objects.equals(name, roaster.name) &&
                Objects.equals(street, roaster.street) &&
                Objects.equals(city, roaster.city) &&
                Objects.equals(State, roaster.State) &&
                Objects.equals(postalCode, roaster.postalCode) &&
                Objects.equals(phone, roaster.phone) &&
                Objects.equals(email, roaster.email) &&
                Objects.equals(note, roaster.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roasterId, name, street, city, State, postalCode, phone, email, note);
    }
}
