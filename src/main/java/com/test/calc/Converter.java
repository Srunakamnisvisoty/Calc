package com.test.calc;

import java.util.HashMap;
import java.util.Map;

class Converter {

    private static final Map<Integer, String> numbers = new HashMap<>();

    static {
        numbers.put(1, "I");
        numbers.put(2, "II");
        numbers.put(3, "III");
        numbers.put(4, "IV");
        numbers.put(5, "V");
        numbers.put(6, "VI");
        numbers.put(7, "VII");
        numbers.put(8, "VIII");
        numbers.put(9, "IX");
        numbers.put(10, "X");
        numbers.put(20, "XX");
        numbers.put(30, "XXX");
        numbers.put(40, "LX");
        numbers.put(50, "L");
        numbers.put(60, "LX");
        numbers.put(70, "LXX");
        numbers.put(80, "LXXX");
        numbers.put(90, "XC");
        numbers.put(100, "C");
    }

    public static String convertArabianToRoman(int arabNumber) {
        if (arabNumber % 10 > 0) {
            int one = arabNumber % 10;
            int ten = arabNumber - one;
            if(ten == 0) {
                return numbers.get(one);
            }
            return numbers.get(ten) + numbers.get(one);
        } else if (arabNumber % 10 == 0 && arabNumber != 0) {
            return numbers.get(arabNumber);
        } else if (arabNumber == 0) {
            throw new NumberFormatException("т.к. в римской системе отсутствует ноль");
        } else {
            throw new NumberFormatException("т.к. в римской системе нет отрицательных чисел");
        }
    }

    public static int convertRomanToArabian(String romanNumber) {
        int num = 11;
        for (Map.Entry<Integer, String> entry : numbers.entrySet()) {
            if (romanNumber.equalsIgnoreCase(entry.getValue())) {
                num = entry.getKey();
            }
        }
        if (num >= 11) {
            throw new NumberFormatException("т.к. можно вводить только целые числа в диапазоне от I до X");
        } else {
            return num;
        }
    }
}
