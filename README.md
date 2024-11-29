# Java Microservice Project Repository

This repository contains multiple Spring Boot-based microservice projects, each showcasing different functionalities and use cases. These projects are modular, follow clean code principles, and demonstrate the implementation of various microservice patterns and best practices in design and implementation.


---

## Table of Contents

1. [Accounts API](#accounts-api)
2. [Blog Management API](#blog-management-api)
3. [Contact Management API](#contact-management-api)
4. [Order Management System](#order-management-system)

---

## Accounts API

### Overview
The **Accounts API** manages customer accounts and associated functionalities. It includes customer and account management features with centralized exception handling and AOP-based logging for enhanced traceability.

For more detailed information, refer to the [`help.md`](help.md) file.

---

## Blog Management API

### Overview
The **Blog Management API** provides functionality for managing users and their blogs with role-based access control. This project is designed to demonstrate clean architecture and efficient handling of blog data.

For more detailed information, refer to the [`help.md`](help.md) file.

---

## Contact Management API

### Overview
The **Contact Management API** manages contact information for individuals or organizations. It focuses on CRUD operations for storing, updating, and retrieving contact details.

For more detailed information, refer to the [`help.md`](help.md) file.

---

## Order Management System

### Overview
The **Order Management System** facilitates the management of customer orders, providing functionalities like dynamic invoice generation, AOP-based logging, and validation for data integrity.

For more detailed information, refer to the [`help.md`](help.md) file.

---

## Common Prerequisites

- **Java Development Kit (JDK)**: 17+
- **Maven**: 3.8+
- **Database**: MySQL
- **IDE**: IntelliJ IDEA, Eclipse, or similar

---

## Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Navigate to the Desired Project
```bash
cd <project-folder>
```

### 3. Configure the Database
Update the `application.properties` file with the respective database details:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<database-name>
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

### 4. Build and Run the Project
```bash
./mvnw clean install
./mvnw spring-boot:run
```

### 5. Access the API
- Base URL for all APIs: `http://localhost:8080/api/v1`

---

## Testing

Run tests for any project using:
```bash
./mvnw test
```

---


## License

This repository is licensed under the MIT License.

---  

Each project includes more detailed documentation in the [`help.md`](help.md) file located in the repository.
