package com.epam.engx.cleancode.naming.task1.service.impl;


import com.epam.engx.cleancode.naming.task1.entity.Message;
import com.epam.engx.cleancode.naming.task1.service.CollectionService;
import com.epam.engx.cleancode.naming.task1.service.NotificationManager;
import com.epam.engx.cleancode.naming.task1.service.Order;
import com.epam.engx.cleancode.naming.task1.service.OrderService;

public class CollectOrderService implements OrderService {
    private static final int INFO_NOTIFICATION_LEVEL_VALUE = 4;
    private static final int CRITICAL_NOTIFICATION_LEVEL_VALUE = 1;

    private CollectionService collectionService;
    private NotificationManager notificationManager;

    @Override
    public void submit(Order order) {
        if (collectionService.isCollectable(order))
            notificationManager.notifyCustomer(Message.READY_FOR_COLLECT_MESSAGE, INFO_NOTIFICATION_LEVEL_VALUE);
        else
            notificationManager.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT_MESSAGE, CRITICAL_NOTIFICATION_LEVEL_VALUE);
    }

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

}
