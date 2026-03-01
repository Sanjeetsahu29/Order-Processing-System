package com.example.order_System.Services;

import org.springframework.stereotype.Service;

/*
    @Service --> Marks this class as Spring Bean.
    Spring will create and manage this object
*/
@Service
public class CreditCardPaymentService implements PaymentService{
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment through Credit card of amount Rs. "+amount);
    }
}
