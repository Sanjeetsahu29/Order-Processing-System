package com.example.order_System.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/*
    OrderService depends on:
    1. PaymentService
    2. NotificationService

    We are using Constructor Injection.
    This is the recommended way in Spring.
*/

@Service
public class OrderService {
    private final PaymentService paymentService;
    private final NotificationService notificationService;
    /*
        @Qualifier is required because:
        We have multiple PaymentService implementations and Notification implementations.

        If we don't specify, Spring throws:
        NoUniqueBeanDefinitionException
    */
    public OrderService(
            @Qualifier("upiPaymentService") PaymentService paymentService,
            @Qualifier("emailNotificationService") NotificationService notificationService){
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public void placeOrder(double amount){
        System.out.println("Order Placed Successfully");
        paymentService.pay(amount);
        notificationService.sendNotification("Your order of Rs. "+amount+" is successful.");
    }
}
