package com.test.calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        return Calc.result(input);
    }
}