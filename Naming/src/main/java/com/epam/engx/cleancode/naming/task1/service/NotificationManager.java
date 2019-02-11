package com.epam.engx.cleancode.naming.task1.service;

import com.epam.engx.cleancode.naming.task1.entity.Message;

public interface NotificationManager {
    void notifyCustomer(Message message, int level);
}
