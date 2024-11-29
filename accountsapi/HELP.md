# Accounts API - HELP.md

## Overview
The **Accounts API** is a Spring Boot-based project designed to manage customer accounts and associated functionalities. It follows best practices such as modular design, exception handling, logging, and adherence to SOLID principles.  

This project supports RESTful APIs and includes features such as:
- Customer and Account management.
- AOP-based logging for better traceability.
- Centralized exception handling.
- Support for audits and error reporting.

---

## Project Structure

### Key Packages
- **`controller`**: Contains REST controllers for handling API requests (`AccountsController.java`).
- **`service`**: Business logic implementation (e.g., `AccountsServiceImpl.java`).
- **`repository`**: Handles database operations using JPA repositories (`AccountsRepository.java`, `CustomerRepository.java`).
- **`dto`**: Data Transfer Objects for encapsulating API request and response data.
- **`entity`**: JPA entities representing database tables (`Accounts`, `Customer`).
- **`exception`**: Custom exception handling classes and global exception handler.
- **`aspect`**: Contains AOP aspects for logging (`LoggingAspect.java`).
- **`mapper`**: For mapping between entities and DTOs.

---

## Prerequisites

- Java Development Kit (JDK) 17+
- Maven 3.8+
- MySQL database
- IDE (e.g., IntelliJ IDEA, Eclipse)

---

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd accountsapi
   ```

2. **Setup MySQL Database**:
   - Create a database named `accounts_db`.
   - Update the `application.properties` file with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/accounts_db
     spring.datasource.username=<your-username>
     spring.datasource.password=<your-password>
     ```

3. **Build and Run**:
   - Build the project:
     ```bash
     ./mvnw clean install
     ```
   - Run the application:
     ```bash
     ./mvnw spring-boot:run
     ```

4. **Access the API**:
   - Base URL: `http://localhost:8080/api/v1`

---

## Key Endpoints

### Customer Management
| Method | Endpoint                   | Description                       |
|--------|----------------------------|-----------------------------------|
| `POST` | `/customers`               | Create a new customer             |
| `GET`  | `/customers/{id}`          | Get customer by ID                |
| `PUT`  | `/customers/{id}`          | Update customer details           |
| `DELETE` | `/customers/{id}`        | Delete customer by ID             |

### Account Management
| Method | Endpoint                   | Description                       |
|--------|----------------------------|-----------------------------------|
| `POST` | `/accounts`                | Create a new account              |
| `GET`  | `/accounts/{id}`           | Get account details by ID         |
| `PUT`  | `/accounts/{id}`           | Update account information        |
| `DELETE` | `/accounts/{id}`         | Delete an account by ID           |

---

## Features

1. **Logging**:
   - AOP-based logging provided by `LoggingAspect`.
   - Automatically logs API requests and responses.

2. **Exception Handling**:
   - Centralized error handling via `GlobalExceptionHandler`.
   - Custom exceptions like `ResourceNotFoundException` and `CustomerAlreadyExistsException`.

3. **Audit Support**:
   - Audit functionality implemented using `AuditAwareImpl`.

4. **DTO Mapping**:
   - Uses `CustomerMapper` and `AccountsMapper` to map between DTOs and entities.

---

## Tests

Run the tests with:
```bash
./mvnw test
```

Unit and integration tests are located under `src/test/java/com/saurabh/accounts`.

---

## Building the Project

To create a JAR file:
```bash
./mvnw package
```
The resulting JAR will be located in the `target` directory.

---

## Troubleshooting

- **Database Connection Issues**:
  Ensure the MySQL database is running and the credentials in `application.properties` are correct.

- **Port Already in Use**:
  Modify the server port in `application.properties`:
  ```properties
  server.port=8081
  ```

---

## Contributions
Feel free to fork the repository and submit pull requests for new features or bug fixes.

---

## License
This project is licensed under the MIT License.

--- 

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/maven-plugin/build-image.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.3.5/reference/actuator/index.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.3.5/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.3.5/reference/using/devtools.html)
* [Thymeleaf](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Validation](https://docs.spring.io/spring-boot/3.3.5/reference/io/validation.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

