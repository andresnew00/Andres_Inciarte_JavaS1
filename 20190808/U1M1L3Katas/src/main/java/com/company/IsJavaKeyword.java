package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        //User Input
        System.out.println("Java Keyword checker");
        String userAnswer = myScanner.nextLine();

        if (userAnswer.equals("abstract") || userAnswer.equals("continue") || userAnswer.equals("for") || userAnswer.equals("new") ||
                userAnswer.equals("switch") || userAnswer.equals("assert") || userAnswer.equals("default") || userAnswer.equals("goto") ||
                userAnswer.equals("package") || userAnswer.equals("synchronized") || userAnswer.equals("boolean") || userAnswer.equals("do") ||
                userAnswer.equals("if") || userAnswer.equals("private") || userAnswer.equals("this") || userAnswer.equals("break") ||
                userAnswer.equals("break") || userAnswer.equals("implements") || userAnswer.equals("protected") || userAnswer.equals("import") ||
                userAnswer.equals("throw") || userAnswer.equals("byte") || userAnswer.equals("else") || userAnswer.equals("enum") ||
                userAnswer.equals("public") || userAnswer.equals("throws") || userAnswer.equals("case") || userAnswer.equals("instanceof") ||
                userAnswer.equals("return") || userAnswer.equals("transient") || userAnswer.equals("catch") || userAnswer.equals("extends") ||
                userAnswer.equals("int") || userAnswer.equals("short") || userAnswer.equals("try") || userAnswer.equals("char") ||
                userAnswer.equals("final") || userAnswer.equals("interface") || userAnswer.equals("static") || userAnswer.equals("void") ||
                userAnswer.equals("class") || userAnswer.equals("finally") || userAnswer.equals("long") || userAnswer.equals("strictfp") ||
                userAnswer.equals("volatile") || userAnswer.equals("const") || userAnswer.equals("float") || userAnswer.equals("native") ||
                userAnswer.equals("super") || userAnswer.equals("while")

        ) {
            System.out.println("this is a Java Keyword");
        } else {
            System.out.println("this is not a Java Keyword");
        }








//        Write a program that get user input (a String) and print out whether or not it is a Java keyword.
//        You will need to find a list of keywords for this kata.

    }
}
