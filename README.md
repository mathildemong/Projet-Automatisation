# Projet-Automatisation

## Prerequisites
- Java JDK 8 or higher
- Maven 3.6 or higher
- An IDE (e.g., IntelliJ, Eclipse)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/mathildemong/Projet-Java-Selenium-Gherkin__492__0.git
   cd Projet-Java-Selenium-Gherkin__492__0
   ```
2. Install the dependencies:
   ```bash
   mvn install
   ```

## Project Structure
```
Projet-Java-Selenium-Gherkin__492__0/
├── src/
│   ├── main/
│   └── test/
└── pom.xml
```

## Technologies
- Java
- Selenium WebDriver
- Cucumber
- TestNG

## Configuration
- Update `config.properties` with your environment settings.
- Specify the browser and environment in the corresponding configuration files.

## Test Execution
- To run tests, use the command:
   ```bash
   mvn test
   ```

## Examples
- Example feature files can be found in the `src/test/resources/features` directory.

## Page Object Model
- Implement your page classes in the `src/main/java/pages` directory.

## Cucumber Tests
- Cucumber tests are defined in the `src/test/resources/features` folder.

## API Tests
- To run API tests, utilize the `src/test/java/api` directory for the implementation.

## Troubleshooting
- Ensure all dependencies are correctly installed.
- Check the logs for errors during test execution.

## Resources
- [Selenium Documentation](https://www.selenium.dev/documentation/en/)
- [Cucumber Documentation](https://cucumber.io/docs/guides)
- [Maven Documentation](https://maven.apache.org/guides/)
