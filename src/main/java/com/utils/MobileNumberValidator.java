package com.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class MobileNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String pNumber) {
        return pNumber.startsWith("+27") && pNumber.length() == 12;
    }
}
