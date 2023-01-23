package com.utils;

import java.util.function.Predicate;

public class IdNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String idNumber) {
        return idNumber.length() == 13;
    }
}
