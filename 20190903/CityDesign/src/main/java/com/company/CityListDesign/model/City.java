package com.company.CityListDesign.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class City {

    @NotEmpty(message = "You must provide a city name.")

    private String name;

    @NotEmpty(message = "You must provide a state name.")
    private String state;

    @NotNull(message = "You must provide a population number.")
    private int population;

    @NotNull(message = "Provide if city is a capital or not.")
    private boolean isCapital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }
}
