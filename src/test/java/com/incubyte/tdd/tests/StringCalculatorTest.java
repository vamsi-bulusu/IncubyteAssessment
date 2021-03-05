package com.incubyte.tdd.tests;

import com.incubyte.tdd.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {

    @Test
    void addEmptyString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void addStringWithOneNum(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void addStringWithTwoNum(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1,2"));
    }

}
