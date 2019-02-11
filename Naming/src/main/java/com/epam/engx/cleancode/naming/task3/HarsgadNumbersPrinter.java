package com.epam.engx.cleancode.naming.task3;

public class HarsgadNumbersPrinter {

    public static void main(String[] args) {
        printHasrhadNumbers();
    }

    private static void printHasrhadNumbers() {
        long lim = 1000;

        for (int i = 1; i <= lim; i++) {

            if (i % getSumOfDigitsFor(i) == 0) {
                System.out.println(i);
            }
        }
    }

    private static int getSumOfDigitsFor(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }
}