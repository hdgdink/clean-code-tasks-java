package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

class MortgageInstallmentCalculator {

    static double calculateMonthlyPayment(int principalAmount, int term, double rate) {

        checkForNegativeValues(principalAmount, term, rate);

        rate = convertIntoDecimal(rate);

        double tim = convertYearsTermInMonth(term);

        if (isRateValueZero(rate)) return principalAmount / tim;

        double monthlyRate = convertIntoMonthlyRate(rate);

        return calculateMonthlyPayment(principalAmount, tim, monthlyRate);
    }

    private static void checkForNegativeValues(int principalAmount, int term, double rate) {
        if (principalAmount < 0 || term <= 0 || rate < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }
    }

    private static double convertIntoDecimal(double rate) {
        return rate / 100.0;
    }

    private static double convertYearsTermInMonth(int term) {
        return (double) (term * 12);
    }

    private static boolean isRateValueZero(double rate) {
        return rate == 0;
    }

    private static double convertIntoMonthlyRate(double rate) {
        return rate / 12.0;
    }

    private static double calculateMonthlyPayment(int principalAmount, double tim, double m) {
        return (principalAmount * m) / (1 - Math.pow(1 + m, -tim));
    }

}
