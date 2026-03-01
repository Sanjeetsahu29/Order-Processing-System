package com.example.order_System.Services;

import org.springframework.stereotype.Service;
/*
    You did NOT provide a bean name explicitly.
    Spring automatically assigns a default bean name.
    The default bean name = class name with first letter lowercase
    SmsNotificationService -> smsNotificationService
 */
@Service
public class SmsNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS "+message);
    }
}
