package com.epam.engx.cleancode.naming.task1.service;

import com.epam.engx.cleancode.naming.task1.entity.Product;

import java.util.List;

public interface OrderFulfilmentService {
    void fulfil(List<Product> products);
}
