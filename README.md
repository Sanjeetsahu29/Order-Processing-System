# My First Spring Project – IoC & Dependency Injection Demo

### Project Overview
This project demonstrates the core concepts of the Spring Framework:
- Inversion of Control (IoC)
- Dependency Injection (DI)
- Interface-based design
- Multiple bean implementations
- Bean ambiguity resolution using @Qualifier and @Primary
  
The application simulates a simple Order Processing System where:
- An order is placed
- A payment is processed
- A notification is sent<br>
The goal of this project is to understand how Spring manages object creation and dependency resolution internally.
---

### Project Structure
```
myFirstSpringProject
  └── src
      └── main
         ├── java
         │    └── com.example.myFirstSpringProject
         │         ├── MyFirstSpringProjectApplication.java
         │         └── service
         │              ├── OrderService.java
         │              ├── PaymentService.java
         │              ├── CreditCardPaymentService.java
         │              ├── UpiPaymentService.java
         │              ├── NotificationService.java
         │              ├── EmailNotificationService.java
         │              └── SmsNotificationService.java
         └── resources
              └── application.properties
```
---
## Main Concept Demonstrated
1. Inversion of Control (IoC)<br>
In traditional Java:
```java
PaymentService paymentService = new UpiPaymentService();
```

The developer creates and manages objects manually.
In this project:
- We do NOT create objects using new
- Spring container creates and manages all beans
- Control is inverted from developer → to Spring container

This is Inversion of Control.

2. Dependency Injection (DI)<br>
   OrderService depends on:
   - PaymentService
   - NotificationService
  Instead of creating dependencies internally, they are injected via constructor:
```
public OrderService(PaymentService paymentService,
                    NotificationService notificationService)
```
This is Constructor-Based Dependency Injection (recommended approach).

Benefits:
- Loose coupling
- Easy testing
- Follows Dependency Inversion Principle
- Better maintainability

3. Interface-Based Design<br>
   We depend on abstractions, not implementations.
   ```
   public interface PaymentService {
    void pay(double amount);
   }
   ```
   Implementations:
   - CreditCardPaymentService
   - UpiPaymentService
   
   OrderService depends only on the interface.
   This ensures:
   - Open/Closed Principle
   - Easy swapping of implementations
   - Extensibility without modifying business logic
4. Bean Ambiguity Problem<br>
   When multiple implementations exist:
   ```
   @Service
   public class CreditCardPaymentService implements PaymentService
   
   @Service
   public class UpiPaymentService implements PaymentService
   ```
   Spring finds multiple beans of type PaymentService.
   ```
   If we inject:
   public OrderService(PaymentService paymentService)
   ```
   ```
   Spring throws:
   NoUniqueBeanDefinitionException
   ```
   Because it does not know which implementation to inject.
5. How Spring Resolves Ambiguity
   This project demonstrate ambiguity resolution using:
   1. <b>@Qualifier</b>
      ```
      public OrderService(
      @Qualifier("upiPaymentService") PaymentService paymentService,
      @Qualifier("emailNotificationService") NotificationService notificationService
      ```
      Spring injects the bean matching the given name.
      Default bean name rule:
      - Class name with lowercase first letter
        Example: UpiPaymentService → upiPaymentService
    2. <b>@Primary (Alternative Approach)</b>
       If one implementation should be default:
       ```
       @Service
       @Primary
       public class CreditCardPaymentService implements PaymentService
       ```
       Spring automatically injects the primary bean when multiple exist.

       Injection Resolution Order (Internals)<br>
       When resolving dependency, Spring:
       1. Matches by Type
       2. If multiple matches → checks @Qualifier
       3. If no qualifier → checks @Primary
       4. If still ambiguous → throws exception
       This demonstrates Spring’s internal dependency resolution mechanism.
6. Why This Design Is Powerful<br>

   This architecture provides:
   - Loose coupling
   - Runtime flexibility
   - Easy extension (add new payment method without modifying OrderService)
   - Clean separation of concerns
   - Production-ready design pattern (Strategy Pattern via Spring)
     
7. How to run this project
   1. Clone the repository
   2. Ensure Java 17+ installed
   3. Run:
      ```
      mvn spring-boot:run
      ```
      or run the main class
      ```
      MyFirstSpringProjectApplication.java
      ```
   
   
