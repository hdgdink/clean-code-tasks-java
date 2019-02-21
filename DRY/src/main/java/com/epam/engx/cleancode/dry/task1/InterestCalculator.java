package com.epam.engx.cleancode.dry.task1;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterestCalculator {
    private static final int AGE = 60;
    private static final double INTEREST_PERCENT_RATE = 4.5d;
    private static final double SENIOR_PERCENT_RATE = 5.5d;
    private static final int BONUS_AGE = 13;

    private Calendar startCalendar = new GregorianCalendar();
    private Calendar endCalendar = new GregorianCalendar();


    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            return getResultOfCalculation(accountDetails);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(accountDetails.getBirthDate(), accountDetails.getStartDate()) > BONUS_AGE;
    }

    private BigDecimal getResultOfCalculation(AccountDetails accountDetails) {
        return BigDecimal.valueOf(calculateResult(accountDetails));
    }

    private double calculateResult(AccountDetails accountDetails) {
        double interestRate = determineRate(accountDetails);

        return accountDetails.getBalance().doubleValue()
                * durationSinceStartDateInYears(accountDetails.getStartDate()) * interestRate / 100;
    }

    private double determineRate(AccountDetails accountDetails) {
        return AGE <= accountDetails.getAge() ? SENIOR_PERCENT_RATE : INTEREST_PERCENT_RATE;
    }


    private int durationBetweenDatesInYears(Date from, Date to) {
        startCalendar.setTime(from);
        endCalendar.setTime(to);

        return calculateYearDifference(startCalendar, endCalendar);
    }


    private int durationSinceStartDateInYears(Date startDate) {
        startCalendar.setTime(startDate);
        endCalendar.setTime(new Date());

        return calculateYearDifference(startCalendar, endCalendar);

    }

    private int calculateYearDifference(Calendar startCalendar, Calendar endCalendar) {
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);

        if (endCalendar.get(Calendar.DAY_OF_YEAR) < startCalendar.get(Calendar.DAY_OF_YEAR)) {
            return diffYear - 1;
        }

        return diffYear;
    }
}
