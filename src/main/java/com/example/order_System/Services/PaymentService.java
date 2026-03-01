package com.example.order_System.Services;

public interface PaymentService {
    /*
        This is an Abstraction.
        We depend on interface, not implementation.
        This follows Dependency Inversion Principle.
    */
    void pay(double amount);
}
