package com.utils;

import java.util.function.Predicate;

public class MobileNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String pNumber) {
        return pNumber.startsWith("+27") && pNumber.length() == 12;
    }
}
