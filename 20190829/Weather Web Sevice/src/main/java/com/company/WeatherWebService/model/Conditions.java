package com.company.WeatherWebService.model;

public class Conditions {

    private int windSpeed;
    private String windDirection;
    private String skies;
    private String precipitation;

    public Temperature temp;

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
