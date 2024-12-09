# library
Save the following content as a `README.md` file:


# Library Management System - Spring Boot

## Description
A Spring Boot project that demonstrates the management of libraries, librarians, books, and authors. The project showcases various entity relationships:
- **One-to-One**: Library ↔ Librarian
- **One-to-Many**: Library ↔ Books
- **Many-to-Many**: Books ↔ Authors

---

## Technology Stack
- **Framework**: Spring Boot
- **Database**: H2 (Default) | MySQL | PostgreSQL (Optional)
- **Build Tool**: Maven
- **Programming Language**: Java 11+

---

## Endpoints

### Library
- **Create Library**:  
  `POST /api/libraries`  
  Example Request Body:
  ```json
  {
    "name": "Central Library"
  }
  ```

- **Get All Libraries**:  
  `GET /api/libraries`



### Librarian
- **Assign Librarian to Library**:  
  `POST /api/libraries/{libraryId}/librarian`  
  Example Request Body:
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
  ```

---

### Book
- **Add Book to Library**:  
  `POST /api/libraries/{libraryId}/books`  
  Example Request Body:
  ```json
  {
    "title": "Effective Java",
    "isbn": "978-0134685991"
  }
  ```

---

### Author
- **Add Author to Book**:  
  `POST /api/books/{bookId}/authors`  
  Example Request Body:
  ```json
  {
    "name": "Joshua Bloch",
    "email": "joshua@example.com"
  }
  ```

---

## Setup

### Prerequisites
- Java 11+
- Maven installed
- MySQL/PostgreSQL (Optional)

### Steps
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd library-management
   ```

2. By default, H2 is used. To use MySQL/PostgreSQL, update `src/main/resources/application.properties`.

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application:
    - Base URL: `http://localhost:8080/api`

---

## Database

### Default (H2)
- Console URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:librarydb`
- Username: `sa`
- Password: `password`

### MySQL/PostgreSQL (Optional)
Update `application.properties` as per your database configuration:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

## Testing
Use tools like **Postman** or **cURL** to test the API endpoints.

---

## License
This project is free to use and modify for educational purposes.
```