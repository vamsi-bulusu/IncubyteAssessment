package com.incubyte.tdd.tests;

import com.incubyte.tdd.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void addStringWithInvalidInput(){
        StringCalculator stringCalculator = new StringCalculator();
        Throwable throwable = assertThrows(InputMismatchException.class, () -> stringCalculator.add("1,\n"));
        assertEquals("Invalid Input", throwable.getMessage());
    }

    @Test
    @DisplayName("Delimiter pattern - //[delimiter]\n[numbers…]")
    void addStringWithCustomDelimiter(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void addStringWithNegativeNumber(){
        StringCalculator stringCalculator = new StringCalculator();
        Throwable throwable = assertThrows(RuntimeException.class, () -> stringCalculator.add("-1"));
        assertEquals("negatives not allowed, [-1]", throwable.getMessage());
    }

    @Test
    void addStringWithNumbersGreaterThan1000(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("2,1002"));
    }

}
