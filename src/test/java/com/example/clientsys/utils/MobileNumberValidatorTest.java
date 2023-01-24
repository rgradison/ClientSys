package com.example.clientsys.utils;

import com.utils.IdNumberValidator;
import com.utils.MobileNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileNumberValidatorTest {
    private MobileNumberValidator mobileNumberValidator;
    @BeforeEach
    void setUp(){
        mobileNumberValidator = new MobileNumberValidator();
    }

    @ParameterizedTest()
    @CsvSource({"+27824844002,true",
            "+2782484400,False",
            "+278248440021,False",
    })
    @DisplayName("Should pass if phone number length is 12 && is and starts with +27")
    void itShouldValidateMobileNumber(String pNumber,boolean expected) throws Exception {
        //Given
        // String pNumber = "+27824844002";
        //When
        boolean isValid = mobileNumberValidator.test(pNumber);

        //Then
        assertThat(isValid).isEqualTo(expected);

    }
}
