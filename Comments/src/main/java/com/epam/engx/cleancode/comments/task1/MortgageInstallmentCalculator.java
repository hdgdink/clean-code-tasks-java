package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

class MortgageInstallmentCalculator {
    private static final int COUNT_OF_MONTHS_IN_YEAR = 12;

    static double calculateMonthlyPayment(int principalAmount, int mergageTermInYears, double interestRate) {
        defineValues(principalAmount, mergageTermInYears, interestRate);
        return doCalculateMonthlyPayment(principalAmount, mergageTermInYears, interestRate);
    }

    private static double doCalculateMonthlyPayment(int principalAmount, int mergageTermInYears, double interestRate) {
        double morgageTermInMonth = convertYearsTermInMonth(mergageTermInYears);
        if (rateValueZero(interestRate)) {
            return principalAmount / morgageTermInMonth;
        }

        interestRate = convertIntoDecimal(interestRate);
        double monthlyRate = convertIntoMonthlyRate(interestRate);
        return calculateMonthlyPayment(principalAmount, morgageTermInMonth, monthlyRate);
    }

    private static void defineValues(int principalAmount, int mergageTermInYears, double interestRate) {
        if (principalAmount < 0 || mergageTermInYears <= 0 || interestRate < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }
    }

    private static double convertIntoDecimal(double interestRate) {
        return interestRate / 100.0;
    }

    private static double convertYearsTermInMonth(int mergageTermInYears) {
        return (double) (mergageTermInYears * COUNT_OF_MONTHS_IN_YEAR);
    }

    private static boolean rateValueZero(double interestRate) {
        return interestRate == 0;
    }

    private static double convertIntoMonthlyRate(double interestRate) {
        return interestRate / 12.0;
    }

    private static double calculateMonthlyPayment(int principalAmount, double tmorgageTermInMonthm, double monthlyRate) {
        return (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -tmorgageTermInMonthm));
    }
}