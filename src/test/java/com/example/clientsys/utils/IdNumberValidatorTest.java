package com.example.clientsys.utils;

import com.utils.IdNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

//import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

class IdNumberValidatorTest {
    private IdNumberValidator underTest;
    @BeforeEach
    void setUp() throws Exception {
        underTest = new IdNumberValidator();
    }

    @Test
    void itShouldValidateIdNumber() throws Exception {
        //Given
        String idNumber = "7208085992081";
        //When
        boolean isValid = underTest.test(idNumber);

        //Then
        assertThat(isValid).isTrue();

    }

}
