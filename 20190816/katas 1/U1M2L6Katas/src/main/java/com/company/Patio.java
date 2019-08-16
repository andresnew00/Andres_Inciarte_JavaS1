package com.company;

public class Patio {

    public String fanBrand;
    public int poolSize;
    public int grasslength;
    public int chairCount;

    // Constructor

    public Patio(String fanBrand, int poolSize, int grasslength, int chairCount) {
        this.fanBrand = fanBrand;
        this.poolSize = poolSize;
        this.grasslength = grasslength;
        this.chairCount = chairCount;
    }

    // Getters and Setters

    public String getFanBrand() {
        return fanBrand;
    }

    public void setFanBrand(String fanBrand) {
        this.fanBrand = fanBrand;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getGrasslength() {
        return grasslength;
    }

    public void setGrasslength(int grasslength) {
        this.grasslength = grasslength;
    }

    public int getChairCount() {
        return chairCount;
    }

    public void setChairCount(int chairCount) {
        this.chairCount = chairCount;
    }
}
