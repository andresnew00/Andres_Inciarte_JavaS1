package concreteapproach;

public class Circle extends Shape{

    public double area(){
        double radius = 2;
        double PI = Math.PI;
        return PI * Math.pow(radius, 2);
    }


    public double perimeter() {
        double radius = 2;
        double perimeter =  2 * Math.PI * radius;
        return perimeter;
    }

    Shape(){

    }

}
