package com.example.clientsys.utils;

import com.utils.IdNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class IdNumberValidatorTest {
    private IdNumberValidator underTest;
    @BeforeEach
    void setUp() throws Exception {
        underTest = new IdNumberValidator();
    }

    @ParameterizedTest()
    @CsvSource({"7208085992081,true",
            "72080859920081,False",
            "720808592081,False",
    })
    @DisplayName("Should pass if ID number length is 13 && is digit")
    void itShouldValidateIdNumber(String idNumber,boolean expected) throws Exception {
        //Given
       // String idNumber = "7208085992081";
        //When
        boolean isValid = underTest.test(idNumber);

        //Then
        assertThat(isValid).isEqualTo(expected);

    }

}
