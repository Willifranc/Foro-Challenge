package com.foro.entities.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {
    public static void main(String[] args) {
        String rawPassword = "1234";
        String encoded = new BCryptPasswordEncoder().encode(rawPassword);
        System.out.println(encoded);
    }
}
