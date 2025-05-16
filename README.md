# Kafka Microservices Demo

This project is a demo of a microservices architecture using Spring Boot and Apache Kafka. It includes the following services:

## 📦 Microservices

### 1. **Order Service**
- Accepts and places orders.
- Sends order events to Kafka.

### 2. **Stock Service**
- Listens to order events.
- Updates stock based on order status.

### 3. **Email Service**
- Listens to order events.
- Sends confirmation emails to customers.

### 4. **Base Service**
- Shared between all services.
- Contains common models like `Order`, `OrderEvent`, and `Product`.

## 🛠 Technologies Used
- Java 17
- Spring Boot 3
- Apache Kafka
- Maven
- Lombok

## 🚀 How to Run

1. Start Kafka and Zookeeper on your local machine.
2. Start each microservice individually (using `mvn spring-boot:run` or from IntelliJ).
3. Place an order using Order Service (via Postman or frontend).
4. Stock and Email services will automatically consume the event and perform their actions.

---

> Make sure Kafka is running on `localhost:9092` before starting the services.
