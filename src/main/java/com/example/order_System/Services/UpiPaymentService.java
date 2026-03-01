package com.example.order_System.Services;

import org.springframework.stereotype.Service;
/*
    Another implementation of PaymentService.
    Now we have MULTIPLE beans of same type.

    You did NOT provide a bean name explicitly.
    Spring automatically assigns a default bean name.
    The default bean name = class name with first letter lowercase
    UpiPaymentService -> upiPaymentService

    if we want custom name for @Service("upiPay")
 */

@Service
public class UpiPaymentService implements PaymentService{
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment through UPI of amount Rs. "+amount);

    }
}
