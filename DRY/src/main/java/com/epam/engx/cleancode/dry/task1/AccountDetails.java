package com.epam.engx.cleancode.dry.task1;

import java.math.BigDecimal;
import java.util.Date;

public class AccountDetails {
    private Date birthDate;
    private int age;
    private BigDecimal balance;
    private Date startDate;

    Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
