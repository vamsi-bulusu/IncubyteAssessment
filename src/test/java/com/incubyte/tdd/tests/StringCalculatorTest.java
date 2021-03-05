package com.incubyte.tdd.tests;

import com.incubyte.tdd.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {

    @Test
    void addEmptyString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""),"Empty string returns 0");
    }

    @Test
    void addStringWithOneNum(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"), "1 == 1");
    }

    @Test
    void addStringWithTwoNum(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"), "1,2 == 1+2");
    }

    @Test
    void addStringWithNewline(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"), "Newline between numbers instead of commas");
    }

}
