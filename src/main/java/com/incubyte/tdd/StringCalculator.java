package com.incubyte.tdd;

import java.util.stream.Stream;

public class StringCalculator {
    public int add(String number){
        if(number.equals("")) return 0;
        int[] numbers = Stream.of(number.split(",")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
