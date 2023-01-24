package com.utils;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;
@Service
public class IdNumberValidator implements Predicate<String> {
    boolean result;

    @Override
    public boolean test(String idNumber) {
        return idNumber.length() == 13 && idNumber.chars().allMatch(Character::isDigit);
    }


    public boolean validateSAID(String id) {
        boolean result = false;

        if((isValidNumberWith13Digits(id)) && (hasValidDate(id))){
            int sum = 0;
            int digit = Integer.parseInt((id));

            int size = id.length()-1;

            for(int i = 0; i <= size; i++){

                int digit1 = digit*size-i;
                if(IsOdd(i)){
                    digit1 = digit *2;
                    if (digit > 9){
                        int subSum =0;
                        while (digit > 0){
                            subSum = digit % 10;
                            digit = digit/10;
                        }
                        digit1 = subSum;
                    }
                }
                sum += digit1;
            }

            if(sum%10==0){
                result=true;
            }else{
                result=false;
            }
        }

        return result;
    }



    public boolean IsOdd(int i){
        return i%2 !=0;
    }

    public boolean hasValidDate(String id) {
        int year =Integer.parseInt(id.substring(0,2));
        int month = Integer.parseInt(id.substring(2, 4));
        int day = Integer.parseInt(id.substring(4, 6));

        Date date1;
        Date date2;

        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            date1 = simpleDateFormat.parse(String.valueOf(month/day/19+year));
            date2 = simpleDateFormat.parse(String.valueOf(month/day/20+year));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return dateTryParse(date1.toString()) || dateTryParse(date2.toString());

    }

    public boolean dateTryParse(String date) {
        result = true;
        String formatStr= "%m.%d/%Y";

        try {


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    public boolean isValidNumberWith13Digits(String id) {
        return id.length()==13 && id.chars().allMatch(Character::isDigit);//Regex.isMatch(id,"^[0-9] + $"

    }

    public boolean isOddNumber(String id){
        return Integer.parseInt(id) % 2 != 0;
    }



}
