package com.incubyte.tdd;

import java.util.InputMismatchException;
import java.util.stream.Stream;

public class StringCalculator {


    public String[] tokenize(String number){
        if(number.contains(",\n") || number.contains("\n,")){
            throw new InputMismatchException("Invalid Input");
        }
        return number.split(",|\n");
    }
    public int sum(int[] numbers){
        int result = 0;
        for (int num:numbers) result += num;
        return result;
    }


    public int add(String number){
        if(number.isEmpty()) return 0;
        else {
            int[] numbers = Stream.of(tokenize(number)).mapToInt(Integer::parseInt).toArray();
            return sum(numbers);
        }
    }
}
