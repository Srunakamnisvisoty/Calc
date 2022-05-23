package com.test.calc;

class LinePreparing {

    private static String[] findMathSymbol(String source) {
        String mathString = source.replaceAll(" ", "");
        if (mathString.startsWith("-")) {
            throw new NumberFormatException("Нельзя вводить отрицательные числа");
        }
        if (mathString.contains("*")) {
            String[] numbers = checkOperation(mathString.split("\\*"));
            return new String[]{numbers[0], "*", numbers[1]};
        } else if (mathString.contains("/")) {
            String[] numbers = checkOperation(mathString.split("/"));
            return new String[]{numbers[0], "/", numbers[1]};
        } else if (mathString.contains("+")) {
            String[] numbers = checkOperation(mathString.split("\\+"));
            return new String[]{numbers[0], "+", numbers[1]};
        } else if (mathString.contains("-")) {
            String[] numbers = checkOperation(mathString.split("-"));
            return new String[]{numbers[0], "-", numbers[1]};
        } else {
            throw new InvalidStringException("т.к. строка не является математической операцией");
        }
    }

    public static String checkNumber(String source) {
        if (Character.isDigit((source).charAt(0))) {
            return source;
        } else {
            return String.valueOf(Converter.convertRomanToArabian(source));
        }
    }

    private static void checkNumber(String[] source) {
        if (Double.parseDouble(source[0]) % 1 != 0 || Double.parseDouble(source[2]) % 1 != 0 ) {
            throw new NumberFormatException("т.к можно вводить только целые числа");
        }
        if (Integer.parseInt(source[0]) > 10 || Integer.parseInt(source[0]) < 1 ||
                Integer.parseInt(source[2]) > 10 ||Integer.parseInt(source[2]) < 1) {
            throw new NumberFormatException("т.к. можно вводить только числа от 1 до 10");
        }
    }

    private static String[] checkLine(String[] source) {
        if (Character.isDigit((source[0]).charAt(0)) && Character.isDigit((source[2]).charAt(0))) {
            checkNumber(source);
            return source;
        } else if (!Character.isDigit((source[0]).charAt(0)) && !Character.isDigit((source[2]).charAt(0))) {
            return source;
        } else {
            throw new InvalidStringException("т.к. используются одновременно разные системы счисления");
        }
    }

    public static String[] resultLine(String source) {
        return checkLine(findMathSymbol(source));
    }

    private static String[] checkOperation(String[] source) {
        if (source[0].contains("*") || source[1].contains("*") ||
                source[0].contains("/") || source[1].contains("/") ||
                source[0].contains("+") || source[1].contains("+") ||
                source[0].contains("-") || source[1].contains("-") || source.length > 2) {
            throw new InvalidStringException("т.к. формат математической операции не удовлетворяет заданию" +
                    " - два операнда и один оператор (+, -, /, *) ");
        }
        return source;
    }
}
