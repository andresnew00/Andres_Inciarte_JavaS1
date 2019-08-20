package com.company;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {
//    Create a method called `printKeys` which takes in a `Map`
//    with String keys and String values and iterates
//    through and prints out all keys in the `Map`.

    public Map printKeys(Map<String, String> keys){
        // Declare and initialize a Map
        Set<String> myKeys = keys.keySet();
        for (String key : myKeys) {
            System.out.println(key);
        }
    }

    public static void main(String[] args) {


    }



}
