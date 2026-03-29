[README.md](https://github.com/user-attachments/files/26335157/README.md)
#### **Matcher App – Microservices Backend System**



##### Overview



Matcher App is a microservices-based backend system designed to manage users, invoices, and payments, with a future goal of implementing intelligent matching between financial records.



The system is built using Spring Boot and follows a service-oriented architecture, where each domain is isolated into its own service.



##### Architecture



The application currently consists of three core microservices:



###### Auth Service



User registration and authentication

JWT-based login and request validation



###### Invoice Service



Create, retrieve, update, and delete invoices

Invoice status tracking



###### Payment Service



Create and manage payments

Track payment status and associations



Each service operates independently and communicates via REST APIs.



##### Authentication \& Security



Stateless authentication using JWT (JSON Web Tokens)

Custom authentication filters implemented in each service

Secure endpoint access using Spring Security



##### Tech Stack



Backend: Java, Spring Boot

Security: Spring Security, JWT

Build Tool: Maven

Architecture: Microservices (REST-based)



##### Features



User registration and login

Token-based authentication (JWT)

Full CRUD operations for:

Invoices

Payments

Service-level separation of concerns



##### API Capabilities



###### Auth Service



Register new users

Authenticate users and return JWT



###### Invoice Service



Create invoices

Retrieve invoices by user

Update invoice details

Delete invoices



###### Payment Service



Create payments

Retrieve payments by user

Update payment details



##### Roadmap (Planned Enhancements)



Matching Service

Automatically match invoices with payments

Implement matching algorithms and status reconciliation

Advanced Security Features

Rate limiting

Account lockout after failed login attempts

Enhanced logging and monitoring

Scalability Improvements

API gateway integration

Centralized authentication service

Inter-service communication improvements



##### Why This Project Matters



###### This project demonstrates:



Designing and building a microservices architecture

Implementing secure authentication using JWT

Structuring scalable backend systems with separation of concerns

Writing maintainable and testable Spring Boot services



##### Getting Started



###### Prerequisites



Java 17+

Maven

Run Each Service



From each service directory:



mvn spring-boot:run



##### Future Direction



Matcher App is evolving into a more advanced system that will simulate real-world financial reconciliation workflows, making it a strong foundation for exploring distributed systems and backend scalability.

