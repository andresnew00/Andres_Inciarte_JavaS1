package com.company;

public class Radio {

    String manufacturer;
    String model;
    String station;
    int numSpeaker;
    int volume;
    boolean powered;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getStation() {
        return station;
    }

    public int getNumSpeakers() {
        return numSpeaker;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public Radio(String manufacturerIn, String modelIn, int numSpeakerIn, String stationIn , int volumeIn, boolean poweredIn) {
            this.manufacturer = manufacturerIn;
            this.model = modelIn;
            this.station = stationIn;
            this.numSpeaker = numSpeakerIn;
            this.volume = volumeIn;
            this.powered = poweredIn;
        }
    }
