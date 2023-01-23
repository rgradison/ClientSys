package com.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class IdNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String idNumber) {
        return idNumber.length() == 13 && idNumber.chars().allMatch(Character::isDigit);
    }
}
