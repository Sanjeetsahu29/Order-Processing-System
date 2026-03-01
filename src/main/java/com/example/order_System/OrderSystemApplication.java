package com.example.order_System;

import com.example.order_System.Services.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrderSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrderSystemApplication.class, args);
		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder(5000);

	}

}
