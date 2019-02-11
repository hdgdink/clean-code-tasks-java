package com.epam.engx.cleancode.naming.task1.service.impl;

import com.epam.engx.cleancode.naming.task1.entity.Product;
import com.epam.engx.cleancode.naming.task1.exception.NotDeliverableOrderException;
import com.epam.engx.cleancode.naming.task1.service.DeliveryService;
import com.epam.engx.cleancode.naming.task1.service.Order;
import com.epam.engx.cleancode.naming.task1.service.OrderFulfilmentService;
import com.epam.engx.cleancode.naming.task1.service.OrderService;

import java.util.List;

public class DeliveryOrderService implements OrderService {

    private DeliveryService deliveryService;
    private OrderFulfilmentService orderFulfilmentService;

    @Override
    public void submit(Order order) {
        if (deliveryService.isDeliverable()) {
            List<Product> productList = order.getListOfProducts();
            orderFulfilmentService.fulfil(productList);
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService orderFulfilmentService) {
        this.orderFulfilmentService = orderFulfilmentService;
    }
}
