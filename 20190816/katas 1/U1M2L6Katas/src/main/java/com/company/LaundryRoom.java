package com.company;

public class LaundryRoom{

    public int ClothesCount;
    public String roomColor;
    public int laundryBasketCount;
    public String detergent;

    public LaundryRoom(int clothesCount, String roomColor, int laundryBasketCount, String detergent) {
        ClothesCount = clothesCount;
        this.roomColor = roomColor;
        this.laundryBasketCount = laundryBasketCount;
        this.detergent = detergent;
    }
}
