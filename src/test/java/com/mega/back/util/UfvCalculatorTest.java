package com.mega.back.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UfvCalculatorTest {

    @Test
    void adjust_ok() {
        var calc = new UfvCalculator();
        var r = calc.adjust(new BigDecimal("100.00"), new BigDecimal("1.005"));
        assertEquals(new BigDecimal("100.50"), r);
    }

    @Test
    void adjust_throwsOnNull() {
        var calc = new UfvCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.adjust(null, BigDecimal.ONE));
        assertThrows(IllegalArgumentException.class, () -> calc.adjust(BigDecimal.ONE, null));
    }

    @Test
    void adjust_throwsOnNegative() {
        var calc = new UfvCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.adjust(new BigDecimal("-1"), BigDecimal.ONE));
    }
}
