package com.company;


public class App {

    public static int subtract(int a, int b) {
        int subtraction = a - b;
        return subtraction;
    }

    public static int subtractOrZero(int a, int b) {
        int subtractionZero = a - b;

        if (subtractionZero < 0) {
            return 0;
        } else {
            return subtractionZero;
        }
    }

    public static int max(int a, int b, int c) {

        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }

    }

    public static int min(int a, int b, int c) {

        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }

    }

    public static boolean isLarger(int first, int second) {

//        that takes two int parameters (first and second)
//        and returns true if the first is greater than second.
        if (first > second) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        subtract(2,3);
        subtractOrZero(3,4);
        max(1,2,3);
        min(3,5,6);
        isLarger(10, 20);


    }

}