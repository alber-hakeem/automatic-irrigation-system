# Irrigation System

This project implements an automatic irrigation system for agricultural lands using Spring Boot.
[Link to high level architecture presentation](https://docs.google.com/presentation/d/1-wCiF4tusz5Y2C6ZnT6wd7wRy3OOJi3n9OdK3JYB0Rg/edit?usp=sharing)

## Requirements

- Java 11 or later
- Maven
- PostgreSQL

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/alber85/automatic-irrigation-system
   ```

2. Create a PostgreSQL database called `irrigation_system`. You can use the following command:

   ```bash
   createdb irrigation_system
   ```

3. Update the database connection properties in the `application.properties` file located in the `src/main/resources` directory. Modify the following properties with your PostgreSQL database credentials:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/irrigation_system
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

4. Build the project using Maven:

   ```bash
   cd irrigation-system
   mvn clean install
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

6. The application should now be running on `http://localhost:8080`. You can access the different endpoints using a tool like Postman or cURL.

## API Documentation

The API documentation for the irrigation system can be accessed at `http://localhost:8080/swagger-ui.html`. It provides detailed information about the available endpoints, request/response payloads, and examples.

## Running Unit Tests

To run the unit tests, use the following command:

```bash
mvn test
```

### Postman Collection
[Link to postman collection](./Irregarion system.postman_collection.json)
