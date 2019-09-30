package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is the width of the driveway?");
        double width = Double.parseDouble(scan.nextLine());

        System.out.println("What is the Length of the Driveway");
        double Length = Double.parseDouble(scan.nextLine());

        double perimeter = width + width + Length + Length;
        System.out.format("The area is %2f ", perimeter);

        double area = (width * Length);
        System.out.format("THe perimeter is %2f ", area);

        double cement = 12.50;
        double footers = 8.25;

        double subtotalCement = cement * area;
        System.out.format("Subtotal of cement is %2f ", subtotalCement);

        double subtotalFooter = footers * perimeter;
        System.out.format("Subtotal of footers is %2f ", subtotalFooter);

        //brake point
        System.out.println();

        //Version 2
        System.out.println("What is the price of cement?");
        double priceCement = Double.parseDouble(scan.nextLine());


        System.out.println("What is the price of the footer?");
        double priceFooter = Double.parseDouble(scan.nextLine());

        double newsubtotalCement = priceCement * area;
        System.out.format("Subtotal of cement is now %2f ", newsubtotalCement);

        double newsubtotalFooter = priceFooter * perimeter;
        System.out.format("Subtotal of footers is now %2f ", newsubtotalFooter);
    }
}
