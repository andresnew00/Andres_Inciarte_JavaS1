package com.trilogyed.tasker.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {
    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "12345";
        String encodedPassword = enc.encode(password);

        System.out.println(encodedPassword);
    }
}
