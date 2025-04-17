# JSONPlaceHolder API Testing

This project is a Java-based test automation framework for testing the JSONPlaceholder API. It uses **TestNG** for test execution, **RestAssured** for API interactions, and other utilities like **Lombok**, **Faker**, and **Gson** to simplify development.

## Features

- Automated testing of JSONPlaceholder API endpoints.
- Supports GET, POST, PUT, and DELETE requests.
- Schema validation for API responses.
- Randomized test data generation using **Faker**.
- Modular and reusable utility classes for API interactions and configuration management.

## Prerequisites

- **Java 17** or higher
- **Maven** (for dependency management and build)
- An IDE like IntelliJ IDEA (with annotation processing enabled for Lombok)

## Project Structure

    .
    src
    ├── main 
    │ ├── java 
    │ │ ├── org/jsonplaceholder/models/ # Data models (e.g., Posts) 
    │ │ ├── org/jsonplaceholder/test/ # Test classes (e.g., BaseClass, TestCases) 
    │ │ ├── org/jsonplaceholder/utility/ # Utility classes (e.g., ApiUtilities, PropertiesRead) 
    │ └── resources/ # Configuration files (e.g., config.properties, schemas) 
    └── test.xml # TestNG suite configuration

## Dependencies

The project uses the following dependencies:

- **TestNG**: Test framework for Java.
- **RestAssured**: Library for testing REST APIs.
- **Lombok**: Reduces boilerplate code for models.
- **Faker**: Generates random test data.
- **Gson**: Serializes and deserializes JSON.

Dependencies are managed via Maven. See the `pom.xml` file for details.

## Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd JSONPlaceHolder

2. Build the project:
   ```bash
    mvn clean install

3. Update the **config.properties** file in the resources directory with the required configuration:

    ```bash
    URL=https://jsonplaceholder.typicode.com
    TIME_RESPONSE=5000
4. Running Tests
    ```bash 
   mvn test

Alternatively, you can run the **test.xml** suite file directly from your IDE.

## Example Test Execution
**GET Request**: Validates the response schema and status code.

**POST Request**: Creates a new post with random data and verifies the response.

**PUT Request**: Updates an existing post and validates the response.

**DELETE Request**: Deletes a post and checks the status code.


## License
This project is licensed under the MIT License. See the LICENSE file for details.