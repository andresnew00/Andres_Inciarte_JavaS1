package com.company;

public class FizzBuzz {
    public static void main(String[] args) {

        //variable to contain numbers
        int numbers = 0;

        for (int i = 0; i < 100; i++) {
            //increment for numbers variable
            numbers++;

            // replacing values for BUZZ FIZZ strings
            if (numbers % 5 == 0 && numbers % 3 == 0) {
                System.out.println("FIZZBUZZ");
            } else if (numbers % 5 == 0) {
                System.out.println("BUZZ");
            } else if (numbers % 3 == 0) {
                System.out.println("FIZZ");
            } else {
                System.out.println(numbers);
            }


        }

    }
}
