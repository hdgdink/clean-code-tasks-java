package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.List;

class Order {
    private List<Product> products;

    Double getPriceOfAvailableProducts() {
        double orderPrice = 0.0;

        for (Product product : products) {
            orderPrice = getOrderPrice(orderPrice, product);
        }

        return orderPrice;
    }

    private double getOrderPrice(double orderPrice, Product product) {
        if (removeNotAvailableProducts(product)) {
            orderPrice += product.getProductPrice();
        }

        return orderPrice;
    }

    private Boolean removeNotAvailableProducts(Product product) {
        return product.isAvailable();
    }


    void setProducts(List<Product> products) {
        this.products = products;
    }
}
