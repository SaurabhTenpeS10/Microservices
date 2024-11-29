# Contact Management API - HELP.md

## Overview
The **Contact Management API** is a Spring Boot application designed to manage contact information. It provides functionality to create, update, delete, and retrieve contact details, offering an efficient and user-friendly solution for managing personal or professional contacts.

---

## Project Structure

### Key Packages
- **`controller`**: Contains the `ContactController` class, responsible for handling HTTP requests and responses.
- **`service`**: Contains the `ContactService` class, which implements the business logic for contact management.
- **`repository`**: Includes the `ContactRepository` interface for interacting with the database using JPA.
- **`entity`**: Defines the core data models, including `Contact` and `Response`.

---

## Prerequisites

- Java Development Kit (JDK) 17+
- Maven 3.8+
- MySQL database
- IDE (e.g., IntelliJ IDEA, Eclipse)

---

## Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd contactmanagementapi
```

### 2. Configure the Database
- Create a MySQL database named `contact_db`.
- Update the `application.properties` file with the database connection details:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/contact_db
  spring.datasource.username=<your-username>
  spring.datasource.password=<your-password>
  ```

### 3. Build and Run
- Build the project:
  ```bash
  ./mvnw clean install
  ```
- Run the application:
  ```bash
  ./mvnw spring-boot:run
  ```

### 4. Access the API
- Base URL: `http://localhost:8080/api/v1`

---

## Key Endpoints

### Contact Management
| Method   | Endpoint           | Description                     |
|----------|--------------------|---------------------------------|
| `POST`   | `/contacts`        | Create a new contact            |
| `GET`    | `/contacts/{id}`   | Get details of a contact by ID  |
| `GET`    | `/contacts`        | List all contacts               |
| `PUT`    | `/contacts/{id}`   | Update an existing contact      |
| `DELETE` | `/contacts/{id}`   | Delete a contact by ID          |

---

## Features

1. **CRUD Operations**:
   - Supports creating, reading, updating, and deleting contact information.

2. **Standardized API Responses**:
   - Utilizes the `Response` entity to return consistent responses.

3. **Database Integration**:
   - JPA repositories simplify interaction with the MySQL database.

---

## Testing the Application

Run tests using:
```bash
./mvnw test
```
Unit tests are located in `src/test/java/com/jspiders/contactmanagement`.

---

## Build and Deployment

To build the project:
```bash
./mvnw package
```
The JAR file will be available in the `target` directory. Run the JAR with:
```bash
java -jar target/contactmanagementapi-<version>.jar
```

---

## Troubleshooting

- **Database Connection Issues**:
  Ensure the MySQL service is running and the credentials in `application.properties` are correct.

- **Port Conflicts**:
  Modify the server port in `application.properties`:
  ```properties
  server.port=8080
  ```

---


## License

This project is licensed under the MIT License.



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

