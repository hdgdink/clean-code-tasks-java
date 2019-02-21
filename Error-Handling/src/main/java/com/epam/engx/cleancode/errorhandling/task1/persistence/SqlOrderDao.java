package com.epam.engx.cleancode.errorhandling.task1.persistence;

import com.epam.engx.cleancode.errorhandling.task1.OrderDao;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.SqlService;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlOrderDao implements OrderDao {
    private Logger logger = Logger.getLogger(SqlOrderDao.class.getName());
    private SqlService sqlService;

    public SqlOrderDao(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @Override
    public List<Address> getOrderAddresses(String userId) {
        List<Address> addresses = new ArrayList<>();

        try {
            for (Map addressData : sqlService.queryUserOrderAddress(userId)) {
                addresses.add(new Address(addressData));
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "error geting address " + e);
            e.printStackTrace();
        }

        return addresses;
    }
}
