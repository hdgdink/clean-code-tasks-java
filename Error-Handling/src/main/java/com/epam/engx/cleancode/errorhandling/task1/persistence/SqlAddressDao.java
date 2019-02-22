package com.epam.engx.cleancode.errorhandling.task1.persistence;

import com.epam.engx.cleancode.errorhandling.task1.AddressDao;
import com.epam.engx.cleancode.errorhandling.task1.persistence.exceptions.DeliveryAddressException;
import com.epam.engx.cleancode.errorhandling.task1.persistence.exceptions.HomeAddressException;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.SqlService;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlAddressDao implements AddressDao {
    private SqlService sqlService;

    public SqlAddressDao(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @Override
    public Address getHomeAddress(String userId) {
        Address address;
        try {
            address = new Address(sqlService.queryUserHomeAddress(userId));
        } catch (SQLException e) {
            throw new HomeAddressException("Error getting home address " + e);
        }
        return address;
    }

    @Override
    public List<Address> getDeliveryAddresses(String userId) {
        List<Address> addresses = new ArrayList<>();

        try {
            for (Map addressData : sqlService.queryUserDeliveryAddress(userId)) {
                addresses.add(new Address(addressData));
            }
        } catch (SQLException e) {
            throw new DeliveryAddressException("error getting  user delivery address " + e);

        }

        return addresses;
    }
}
