package com.mega.back.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UfvCalculator {
    public BigDecimal adjust(BigDecimal amount, BigDecimal ufvRate) {
        if (amount == null || ufvRate == null) throw new IllegalArgumentException("null");
        if (amount.signum() < 0) throw new IllegalArgumentException("amount < 0");
        return amount.multiply(ufvRate).setScale(2, RoundingMode.HALF_UP);
    }
}
