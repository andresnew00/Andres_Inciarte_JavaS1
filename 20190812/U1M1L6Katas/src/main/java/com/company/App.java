package com.company;

import java.util.Scanner;
import java.util.SplittableRandom;

public class App {

    public static int total(int[] sum) {
        int totalSum = 0;
        // loop and add each item in array to each other to the variable totalSum
        for (int i = 0; i < sum.length; i++) {
            totalSum += sum[i];

        }

        return totalSum;

    }

    public static int totalOdd(int[] oddSumArray) {
        int oddSum = 0;
        //loop items in array
        for (int i = 0; i < oddSumArray.length; i++) {
            // if the item reminder is equal to 1 then add value to oddSum
            if (i % 2 == 1) {
                oddSum += oddSumArray[i];
            }
        }
        return oddSum;
    }

    public static int totalEven(int[] evenSumArray) {
        int evenSum = 0;
        //loop items
        for (int i = 0; i < evenSumArray.length; i++) {
            // if the reminder is equal to 0 then is even so add to evenSumArray
            if (i % 2 == 0) {
                evenSum += evenSumArray[i];
            }
        }
        return evenSum;
    }

    public static int secondLargestNumber(int[] largestNumberArray) {

        int largest = largestNumberArray[0];
        int secondLargest = largestNumberArray[0];


        //looping the array
        for (int i = 0; i < largestNumberArray.length; i++) {

            // if array[i] is larger than the largest number
            if (largestNumberArray[i] >= largest) {
                // then the second largest number is equal to the largest
                secondLargest = largest;
                // and the largest number is now the value of array[i]
                largest = largestNumberArray[i];
                // else if the value of the array item is bigger than the second largest
            } else if (largestNumberArray[i] >= secondLargest) {
                // the second largest is now equal to the value of the item in the array
                secondLargest = largestNumberArray[i];
                // In the case of a 2 item array
            } else if (largestNumberArray.length <= 2) {
                //grab both items and compare their values
                largest = largestNumberArray[0];
                secondLargest = largestNumberArray[1];
            }
            // if the largest is smaller just change it with the secondLargest value
            if (largest < secondLargest) {
                largest = secondLargest;
            }

        }

        return secondLargest;
    }

    public static String[] swapFirstAndLast(String[] words) {

        // variable containing last item in array
        String lastWord = words[words.length - 1];
        //last word is equal to the first word in array
        words[words.length - 1] = words[0];
        //first word in the array changes into the last word variable
        words[0] = lastWord;

        return words;


    }


    public static int[] reverse(int[] reverseArray) {

        int[] newReverseArray = new int[reverseArray.length];
        // variable that is going to contain the current position
        int reverseValue = 0;

        // loop backwards
        for(int i = reverseArray.length - 1; i >= 0; i--){
            newReverseArray[reverseValue++] = reverseArray[i];
        }
        return newReverseArray;
    }

    public static String concatenateString(String[] wordsArray) {
        String fullWord = "";

        // loop that sums all the strings into one fullWord
        for (int i = 0; i < wordsArray.length; i++) {
            // similar to the sum from first method add all strings into one
            fullWord += wordsArray[i];

        }
        return fullWord;
    }

    public static int[] everyThird(int[] third) {
        //first if there is less than 3 numbers in array return null
        if (third.length < 3) {
            return null;
        } else {
            //create new array with the length of the other array divide by 3
            int[] newThird = new int[third.length / 3];
            // add a variable that takes in the new item value to be moved into the new array
            int newThirdCount = 0;
            //loop the array to add into the new array
            for (int i = 2; i < third.length; i += 3) {

                newThird[newThirdCount++] = third[i];

            }
            return newThird;
        }
    }

    public static int[] lessThanFive(int[] lessFiveArray) {
        //variable that creates a count for how many numbers less than 5 we have
        int counterLessFive = 0;
        //loop that counts how many < 5 we have
        for (int i = 0; i < lessFiveArray.length; i++) {
            if (lessFiveArray[i] < 5) {
                counterLessFive++;
            }
        }
        //if the array has no numbers lower than 5 then return null
        if (counterLessFive == 0) {
            return null;
        }
        // creating a new array to fill
        int[] lessThanFiveArray = new int[counterLessFive];
        int count = 0;
        //loop through the array
        for (int i = 0; i < lessFiveArray.length; i++) {
            //add all the values that are less than 5
            if (lessFiveArray[i] < 5) {
                lessThanFiveArray[count++] = lessFiveArray[i];
            }
        }
        return lessThanFiveArray;
    }
}

