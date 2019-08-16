package concreteapproach;

public class Shape {

//    Include properties for name, color, x coordinate, and y coordinate.

    public String name;
    public String color;
    public double xcoordinate;
    public double ycoordinate;

//    Also provide an empty implementation for `area()` and `perimeter()` methods.

    public double area(){

    }

    public double perimeter(){

    }

    Shape(String name, String color, double xcoordinate, double ycoordinate){
        name = "Shape";
        color = "Green";
        xcoordinate = 2;
        ycoordinate = 3;
    }



}
