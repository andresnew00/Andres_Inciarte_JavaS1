package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {
    Scanner myScanner = new Scanner(System.in);

    public int readInt(String prompt){
        System.out.println(prompt);
        return Integer.parseInt(myScanner.nextLine());
    }
    public long readLong(String prompt){
        System.out.println(prompt);
        return Long.parseLong(myScanner.nextLine());
    }
    public double readDouble(String prompt){
        System.out.println(prompt);
        return Double.parseDouble(myScanner.nextLine());
    }
    public float readFloat(String prompt){
        System.out.println(prompt);
        return Float.parseFloat(myScanner.nextLine());
    }
    public String readString(String prompt){
        System.out.println(prompt);
        return myScanner.nextLine();
    }

}
