package com.company.AndresInciarteU1Capstone.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {

        // this application takes a password String, applies the BCrypt algorithm,
        // and then prints the hashed String to the console.
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "3333";

        String encodedPassword = enc.encode(password);

        System.out.println(encodedPassword);

        //users:

        // ROLE_USER
        // regular user : standard00 password: 0000 == $2a$10$WMiNlG8giq.LxQK10XRpOe76Gb8lZnueWx5.abTngoaedvXhPp3Ja
        // ROLE_STAFF
        // staff user : staff11 password: 1111 == $2a$10$v.2bgrlCPL62DWcgb/aveurU31xi/KnqZoA2XkZ5/wjMavERIWJd6
        // ROLE_MANAGER
        // manager user : manager22 password: 2222 == $2a$10$Pmwd0iE5M7vwraxTy42lSOzrlcfPGtG/H5WOgTDaduqYwQyNlrVzi
        // ROLE_ADMIN
        // admin : admin33 password: 3333 == $2a$10$NsNi16cjRr1DjueGGUfsbeh5MwyMQBjShUW3F7l8ZahibxaVPSWFO

    }

}
