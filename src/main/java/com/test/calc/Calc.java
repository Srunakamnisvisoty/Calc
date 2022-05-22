package com.test.calc;
class Calc {

    public static String result(String source) {
        String[] mathString = LinePreparing.resultLine(source);
        String result = "";
        switch (mathString[1]) {
            case "*":
                result = multiplication(mathString);
                break;
            case "/":
                result = division(mathString);
                break;
            case "+":
                result = addition(mathString);
                break;
            case "-":
                result = subtraction(mathString);
                break;
        }
        if (Character.isDigit((mathString[0]).charAt(0)) && Character.isDigit((mathString[2]).charAt(0))) {
            return result;
        } else {
            return Converter.convertArabianToRoman(Integer.parseInt(result));
        }
    }

    private static String multiplication(String[] source) {
        return String.valueOf(firstNumber(source) * secondNumber(source));
    }

    private static String division(String[] source) {
        return String.valueOf(firstNumber(source) / secondNumber(source));
    }

    private static String addition(String[] source) {
        return String.valueOf(firstNumber(source) + secondNumber(source));
    }

    private static String subtraction(String[] source) {
        return String.valueOf(firstNumber(source) - secondNumber(source));
    }

    private static int firstNumber(String[] source) {
        return Integer.parseInt(LinePreparing.checkNumber(source[0]));
    }

    private static int secondNumber(String[] source) {
        return Integer.parseInt(LinePreparing.checkNumber(source[2]));
    }


}
