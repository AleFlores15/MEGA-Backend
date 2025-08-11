package com.mega.back.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationService {
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public boolean isValidEmail(String email) {
        return email != null && EMAIL.matcher(email).matches();
    }
}
