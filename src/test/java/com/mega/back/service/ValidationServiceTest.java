package com.mega.back.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

    private ValidationService svc;

    @BeforeEach
    void setUp() { svc = new ValidationService(); }

    @Test
    void validEmail_simple() {
        assertTrue(svc.isValidEmail("user@megabank.bo"));
    }

    @Test
    void invalidEmail_missingAt() {
        assertFalse(svc.isValidEmail("user.megabank.bo"));
    }

    @Test
    void invalidEmail_null() {
        assertFalse(svc.isValidEmail(null));
    }
}
