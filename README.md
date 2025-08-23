# English Learning Website — Backend

A Spring Boot backend providing RESTful APIs and real-time features for the **English Learning Website**.  
Pairs with the frontend: 👉 [Englearn-frontend](https://github.com/binhfnguyeen/Englearn-frontend.git)

---

## Table of Contents
- Overview
- Architecture
- Tech Stack
- Features
- Project Structure
- Getting Started
- Configuration
- Build & Run
- API & Docs
- Security
- Database & Migrations
- WebSocket (Realtime Chat)
- Mapping & DTOs
- Testing
- Deployment
- Contributing
- License

---

## Overview
This service powers:
- Vocabulary learning by topics
- Practice tests and scoring
- Chatbot conversations with AI (Gemini)
- OTP-based password recovery
- Admin & user statistics

It exposes REST APIs and a WebSocket gateway for real-time chat between **User <=> AI**.

**Frontend repo:** [Englearn-frontend](https://github.com/binhfnguyeen/Englearn-frontend.git)

---

## Architecture
- **Spring Boot (REST)** for APIs
- **WebSocket (STOMP/SockJS)** for realtime chat
- **Spring Security** for authentication & authorization (role-based)
- **Spring Data JPA/Hibernate** for persistence (MySQL)
- **MapStruct** for DTO <=> Entity mapping
- **Lombok** to reduce boilerplate
- **SMTP Mail** for OTP delivery
- **Gemini AI** integration via `spring-ai`

---

## Tech Stack
- **Java 21**
- **Spring Boot** (Web, Data JPA, Security, WebSocket, Mail)
- **MySQL** (Aiven Cloud DB)
- **MapStruct**
- **Lombok**
- **JWT** for authentication
- **Swagger/OpenAPI** (optional)
- **Docker** (optional)

---

## Features
### User Management
- Register/Login
- JWT-based authentication
- Role-based access (`ROLE_USER`, `ROLE_ADMIN`)
- OTP-based password reset via email

### Vocabulary & Topics
- CRUD topics & vocabulary
- Track learned words per user

### Practice Tests
- Create tests
- Submit answers and get results
- Test history per user

### Chatbot & AI Assistant
- Realtime chat with AI (Gemini) via WebSocket
- Contextual session history (optional)

### Admin Dashboard & Statistics
- User statistics
- Learned words per user
- Progress and completion tracking

---

## Project Structure
src/main/java/com/heulwen
├─ config/ # Security, WebSocket, Mail, CORS, etc.
├─ controllers/ # REST controllers
├─ dto/
│ ├─ request/ # Request DTOs
│ └─ response/ # Response DTOs
├─ exceptions/ # Custom exceptions & handlers
├─ mapper/ # MapStruct mappers
├─ pojo/ # JPA entities
├─ repositories/ # Spring Data repositories
├─ services/ # Business logic
└─ resolvers/ # MapStruct resolvers (entity fetching)

---

## Getting Started

### Prerequisites
- Java 21  
- Maven 3.9+  
- MySQL 8.x  

### Clone
git clone https://github.com/binhfnguyeen/Englearn-backend.git
cd Englearn-backend

### Configuration

- Update src/main/resources/application.properties with your settings:
spring.application.name=elearnweb
server.port=8080
server.servlet.context-path=/elearn

spring.datasource.url=jdbc:mysql://ecomercedb-heulwen.c.aivencloud.com:15750/elearnweb?ssl-mode=REQUIRED
spring.datasource.username=${AIVEN_USERNAME}
spring.datasource.password=${AIVEN_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

spring.jwt.signerkey=${JWT_SECRET}

spring.servlet.multipart.max-file-size=20MB
spring.servlet.multipart.max-request-size=20MB

spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.base-url=https://generativelanguage.googleapis.com
spring.ai.openai.chat.completions-path=/v1beta/openai/chat/completions
spring.ai.openai.chat.options.model=gemini-2.0-flash
spring.ai.chat.memory.repository.jdbc.initialize-schema=always
logging.level.org.springframework.jdbc.datasource.init.ScriptUtils=DEBUG

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${EMAIL_USERNAME}
spring.mail.password=${EMAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

### Build & Run

# Clean & build
mvn clean package

# Run
mvn spring-boot:run

- Service runs at: http://localhost:8080/elearn

### API & Docs

# If Swagger is enabled:

**Swagger UI**: http://localhost:8080/elearn/swagger-ui/index.html
**OpenAPI JSON**: http://localhost:8080/elearn/v3/api-docs