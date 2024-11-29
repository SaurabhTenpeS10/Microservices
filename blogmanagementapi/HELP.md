# Blog Management API - HELP.md

## Overview
The **Blog Management API** is a Spring Boot application that provides functionality for managing users and their blogs. It supports creating, updating, deleting, and viewing blogs with role-based access control. This API is designed to showcase efficient management of blog data with modular design and a focus on clean code architecture.

---

## Project Structure

### Key Packages
- **`controller`**: Contains controllers for handling API requests for users and blogs (`BlogController`, `UserController`).
- **`service`**: Provides business logic for blog and user management (`BlogService`, `UserService`).
- **`repository`**: Interfaces for database operations on blogs and users (`BlogRepository`, `UserRepository`).
- **`entity`**: JPA entities representing database tables (`WebBlog`, `User`, `Role`, `Response`).

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
cd blogmanagementapi
```

### 2. Configure the Database
- Create a MySQL database named `blog_db`.
- Update the `application.properties` file with the database details:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
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

### User Management
| Method   | Endpoint               | Description                        |
|----------|------------------------|------------------------------------|
| `POST`   | `/users`               | Create a new user                  |
| `GET`    | `/users/{id}`          | Get user details by ID             |
| `PUT`    | `/users/{id}`          | Update user details                |
| `DELETE` | `/users/{id}`          | Delete user by ID                  |

### Blog Management
| Method   | Endpoint               | Description                        |
|----------|------------------------|------------------------------------|
| `POST`   | `/blogs`               | Create a new blog                  |
| `GET`    | `/blogs/{id}`          | Get blog details by ID             |
| `GET`    | `/blogs`               | List all blogs                     |
| `PUT`    | `/blogs/{id}`          | Update blog content                |
| `DELETE` | `/blogs/{id}`          | Delete a blog by ID                |

---

## Features

1. **Role-Based Access Control**:
   - The `Role` entity and role assignments ensure access control for managing blogs and users.

2. **Centralized Response Structure**:
   - Uses the `Response` entity to standardize API responses.

3. **DTOs and Entity Mapping**:
   - Data structures like `WebBlog`, `User`, and `Role` encapsulate and persist data efficiently.

4. **Database Operations**:
   - JPA repositories (`BlogRepository`, `UserRepository`) simplify database interactions.

---

## Testing the Application

Run tests using:
```bash
./mvnw test
```
Unit tests are located in `src/test/java/com/jspiders/blogmanagement`.

---

## Build and Deployment

To build the project:
```bash
./mvnw package
```
The JAR file will be available in the `target` directory. Run the JAR with:
```bash
java -jar target/blogmanagementapi-<version>.jar
```

---

## Troubleshooting

- **Database Connection Issues**:
  Ensure the MySQL service is running and the credentials in `application.properties` are accurate.

- **Port Conflicts**:
  Modify the server port in `application.properties`:
  ```properties
  server.port=8081
  ```

---

## Contribution Guidelines

1. Fork the repository.
2. Create a new branch for your feature/fix.
3. Commit your changes and submit a pull request.

---

## License

This project is licensed under the MIT License.

---

This `HELP.md` provides all the essential details to set up, use, and contribute to the Blog Management API project.

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

