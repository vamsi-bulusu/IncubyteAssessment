package com.incubyte.tdd;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class StringCalculator {

    public int add(String number){
        if(number.isEmpty()) return 0;
        else {
            return sum(Stream.of(tokenize(number)).mapToInt(Integer::parseInt).toArray());
        }
    }

    public String[] tokenize(String number){
        if(number.startsWith("//")) return customTokenize(number);
        if(number.contains(",\n") || number.contains("\n,")){
            throw new InputMismatchException("Invalid Input");
        }
        return number.split(",|\n");
    }

    public String[] customTokenize(String number){
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(number);
        boolean isMatch = matcher.matches();
        String delimiter = matcher.group(1);
        return matcher.group(2).split(Pattern.quote(delimiter));
    }

    public int sum(int[] numbers){
        int result = 0;
        for (int num:numbers) result += num;
        return result;
    }

}
