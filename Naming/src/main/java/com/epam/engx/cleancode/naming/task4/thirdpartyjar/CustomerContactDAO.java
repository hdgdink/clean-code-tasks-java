package com.epam.engx.cleancode.naming.task4.thirdpartyjar;

import com.epam.engx.cleancode.naming.task4.service.entity.CustomerContact;

public interface CustomerContactDAO {
    CustomerContact findById(Long customerId);

    void update(CustomerContact customerContact);
}
