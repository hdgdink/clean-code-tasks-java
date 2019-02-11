package com.epam.engx.cleancode.naming.task4.service;


import com.epam.engx.cleancode.naming.task4.service.entity.CustomerContact;

public interface CustomerContactService {

    CustomerContact find(Long customerId);

    void update(CustomerContact customerContact);

}
