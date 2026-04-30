# Expense-Tracker-Application

Expense Tracker Application (Backend)

A robust Expense Tracker backend application built using Java, Spring Boot, and REST APIs to manage personal finances efficiently.
It enables users to track, filter expenses with a scalable and production-ready architecture.

🚀 Features
💵 Expense Management
Add, View all expenses
Categorize expenses (Food, Travel, Bills, etc.)
Category-wise breakdown
Sorting & filtering support
🔍 Search & Filtering
Filter by date range
Filter by category
Sort by amount/date
🌐 RESTful APIs
Clean and scalable API design
Easily integrable with frontend (React/Vercel)
🏗️ Tech Stack
Backend: Java, Spring Boot
Database: H2 / MySQL (configurable)
ORM: Spring Data JPA
Build Tool: Maven
Deployment: AWS EC2
📁 Project Structure
src/
 ├── controller/       # REST Controllers
 ├── service/          # Business Logic
 ├── repository/       # Database Access Layer
 ├── model/entity/     # JPA Entities
 ├── dto/              # Data Transfer Objects
 ├── config/           # Security & App Config

⚙️ Getting Started
1. Clone the Repository
git clone https://github.com/Abhishek464/Expense-Tracker-Application.git
cd Expense-Tracker-Application
2. Configure Application

Update application.yaml or application.properties:

spring:
  datasource:
    url: jdbc:h2:mem:expenses-db
    username: sa
    password:

For H2:

spring:
  h2:
    console:
      enabled: true
3. Run the Application
mvn clean install
java -jar target/*.jar

Key Design Decisions
Layered Architecture
Separation of controller, service, and repository improves maintainability and scalability.
DTO Usage
Prevents exposing internal entities and improves API contract clarity.
RESTful Design
Ensures easy integration with any frontend or external service.
Stateless APIs
Enables horizontal scaling and cloud deployment readiness.

Trade-offs Due to Time Constraints
Basic Authentication (or limited security implementation)
Focused on core functionality instead of implementing full JWT/OAuth security flows.
Limited Test Coverage
Prioritized feature completion over writing comprehensive unit/integration tests.
Simplified Error Handling
Implemented global exception handling but avoided deeply granular error classification.
Minimal Optimization
Basic indexing and query optimization applied; advanced performance tuning was deferred.


🚫 What Was Intentionally Not Done
No Advanced Analytics Dashboard
Kept analytics limited to basic summaries instead of building complex reporting features.
No Microservices Architecture
Chose a monolithic design to reduce complexity and speed up development.
No Caching Layer (e.g., Redis)
Skipped caching since current scale does not demand it.
No CI/CD Pipeline Setup
Deployment done manually to save time during the evaluation phase.
No Dockerization
Focused on application logic rather than containerization for faster delivery.

