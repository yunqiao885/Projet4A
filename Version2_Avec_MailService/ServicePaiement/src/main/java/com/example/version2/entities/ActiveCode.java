package com.example.version2.entities;

import java.util.Random;

public class ActiveCode {
    private static final String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();



    public static String generateCode(){
        char[] numbers = new char[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        String code = new String(numbers);
        return code;
    }
}
