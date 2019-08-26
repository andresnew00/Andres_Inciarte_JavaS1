public class Car {
    public String Make;
    public String Model;
    public int Year;
    public String Color;
    public int MilesDriven;

    public Car(String make, String model, int year, String color, int milesDriven) {
        Make = make;
        Model = model;
        Year = year;
        Color = color;
        MilesDriven = milesDriven;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

//    @Override
//    public String toString() {
//        return "Car{" +
//                "Make='" + Make + '\'' +
//                ", Model='" + Model + '\'' +
//                ", Year=" + Year +
//                ", Color='" + Color + '\'' +
//                ", MilesDriven=" + MilesDriven +
//                '}';
//    }

    public int getMilesDriven() {
        return MilesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        MilesDriven = milesDriven;
    }
}
