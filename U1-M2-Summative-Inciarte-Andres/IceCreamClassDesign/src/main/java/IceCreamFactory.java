public class IceCreamFactory {
    // make more icecream if the amount is low
    // ship when truck is full
    int IcreamAmount;
    String Brand;
    Boolean AmountIsLow;
    int date;
    int expiredDate;

    public IceCreamFactory(int icreamAmount, String brand, Boolean amountIsLow, int date, int expiredDate) {
        IcreamAmount = icreamAmount;
        Brand = brand;
        AmountIsLow = amountIsLow;
        this.date = date;
        this.expiredDate = expiredDate;
    }

    public int getIcreamAmount() {
        return IcreamAmount;
    }

    public void setIcreamAmount(int icreamAmount) {
        IcreamAmount = icreamAmount;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public Boolean getAmountIsLow() {
        return AmountIsLow;
    }

    public void setAmountIsLow(Boolean amountIsLow) {
        AmountIsLow = amountIsLow;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(int expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void TruckisFull(String Brand, int date, int expiredDate){
        if (Brand == "Best Icecream" && date < expiredDate) {
            System.out.println("Order can be shipped!");
        }
    }
}
