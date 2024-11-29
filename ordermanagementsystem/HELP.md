# Order Management System

The **Order Management System** is a Spring Boot application that facilitates managing orders, products, carts, and users. It follows modern software development practices with features like RESTful APIs, AOP logging, exception handling, and dynamic invoice rendering using Velocity templates.

---

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [Contributors](#contributors)

---

## Features

- **User Management**: Add, update, delete, and fetch user details.
- **Product Management**: Manage product catalog with CRUD operations.
- **Order Processing**: Create, view, and manage customer orders.
- **Cart Functionality**: Add/remove products from the cart.
- **Dynamic Invoice Generation**: Render invoices using Velocity templates.
- **Robust Exception Handling**: Global exception handling for better user feedback.
- **Logging**: AOP-based logging for method-level execution details.

---

## Technologies Used

- **Backend**: Spring Boot, Hibernate
- **Frontend**: Thymeleaf (if applicable)
- **Database**: MySQL
- **Build Tool**: Maven
- **API Documentation**: Postman Collection
- **Logging**: Spring AOP
- **Template Engine**: Apache Velocity

---

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven 3.6 or higher
- MySQL Server
- Postman (for API testing)

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository/order-management-system.git
   cd ordermanagementsystem
   ```

2. Configure the database:
   - Create a MySQL database.
   - Update `application.properties` with your database credentials.

3. Build the project:
   ```bash
   ./mvnw clean install
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Access the application:
   - REST APIs: Use Postman to test endpoints.
   - If a frontend is available, visit: [http://localhost:8080](http://localhost:8080)

---

## API Documentation

- A Postman collection is available at: `Order Management API Collection.postman_collection.json`.
- Import this file into Postman to explore and test available APIs.

---

## Project Structure

```
src/main/java/com/redberyl/ordermanagemnt/
├── aspect/                 # Logging with AOP
├── controller/             # REST controllers for users, orders, products, and carts
├── dto/                    # Data transfer objects
├── exception/              # Custom exception handling
├── model/                  # Entity classes
├── repository/             # Data access layers
├── service/                # Business logic interfaces and implementations
├── OrdermanagementsystemApplication.java # Main class
src/main/resources/
├── application.properties  # Application configuration
├── templates/              # Velocity templates for dynamic content
```

---

## Contributors

- **Saurabh Tenpe** - [LinkedIn](https://www.linkedin.com/in/saurabhtenpe)

---

Feel free to reach out for contributions, feedback, or queries!

---


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.3.5/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.3.5/reference/using/devtools.html)
* [Thymeleaf](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

