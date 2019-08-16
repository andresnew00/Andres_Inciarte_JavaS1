package com.company;

public class LaundryRoom{

    public int ClothesCount;
    public String roomColor;
    public int laundryBasketCount;
    public String detergent;

    // Constructor

    public LaundryRoom(int clothesCount, String roomColor, int laundryBasketCount, String detergent) {
        ClothesCount = clothesCount;
        this.roomColor = roomColor;
        this.laundryBasketCount = laundryBasketCount;
        this.detergent = detergent;
    }

    // Getters and Setters

    public int getClothesCount() {
        return ClothesCount;
    }

    public void setClothesCount(int clothesCount) {
        ClothesCount = clothesCount;
    }

    public String getRoomColor() {
        return roomColor;
    }

    public void setRoomColor(String roomColor) {
        this.roomColor = roomColor;
    }

    public int getLaundryBasketCount() {
        return laundryBasketCount;
    }

    public void setLaundryBasketCount(int laundryBasketCount) {
        this.laundryBasketCount = laundryBasketCount;
    }

    public String getDetergent() {
        return detergent;
    }

    public void setDetergent(String detergent) {
        this.detergent = detergent;
    }
}
