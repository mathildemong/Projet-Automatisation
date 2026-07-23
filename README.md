# Projet-Automatisation

Projet d'automatisation web (Selenium) et API (REST-assured), avec des scénarios de test écrits en Gherkin et exécutés via Cucumber + JUnit 5.

## Prerequisites

- Java JDK 17 or higher
- Maven 3.6 or higher
- An IDE (e.g., IntelliJ, Eclipse)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/mathildemong/Projet-Automatisation.git
   cd Projet-Automatisation
   ```
2. Install the dependencies:
   ```bash
   mvn install
   ```

## Project Structure

```
Projet-Automatisation/
├── src/
│   ├── main/java/
│   │   ├── pages/model/    # Page Object Model (WebButton, WebLabel, WebPage, WebTextBox)
│   │   └── utils/          # DriverManager, WebDriverFactory, Pause_Popup
│   └── test/
│       ├── java/
│       │   ├── DemoQATest2.java
│       │   ├── api/         # ApiTest, ApiTest2 (tests API avec REST-assured)
│       │   ├── runners/     # TestRunner (point d'entrée Cucumber)
│       │   └── steps/       # StepDefinitions
│       └── resources/
│           └── features/    # Scenario_Correction.feature (scénarios Gherkin)
└── pom.xml
```

## Technologies

- Java 17
- Selenium WebDriver 4.38.0
- WebDriverManager 6.3.3 (télécharge et configure automatiquement le driver Chrome/Firefox correspondant, sans installation manuelle)
- Cucumber 7.32.0
- JUnit 5 (Jupiter) + JUnit Platform Suite
- REST-assured 5.5.6 (tests API)
- SLF4J (logging)

## Configuration

Le driver de navigateur est géré automatiquement par **WebDriverManager** via la classe `utils/WebDriverFactory.java` — aucune configuration manuelle du binaire ChromeDriver n'est nécessaire.

## Test Execution

Pour lancer l'ensemble des tests (Cucumber + JUnit) :

```bash
mvn test
```

Les rapports Cucumber sont générés dans `target/cucumber-reports/` (`cucumber.html` et `cucumber.json`), configurés dans `runners/TestRunner.java`.

## Examples

- Le scénario d'exemple `Scenario_Correction.feature` (dans `src/test/resources/features`) remplit un formulaire sur DemoQA (section "Text Box") et vérifie sa soumission.

## Page Object Model

- Les classes de pages sont implémentées dans `src/main/java/pages/model` (`WebButton`, `WebLabel`, `WebPage`, `WebTextBox`).

## Cucumber Tests

- Les steps sont définis dans `src/test/java/steps/StepDefinitions.java`.
- Le runner Cucumber (`src/test/java/runners/TestRunner.java`) associe les features aux steps via `@SelectClasspathResource("features")` et `GLUE_PROPERTY_NAME = "steps, hooks"`.

## API Tests

- Les tests API (REST-assured) se trouvent dans `src/test/java/api/` (`ApiTest.java`, `ApiTest2.java`).

## Troubleshooting

- Vérifie que le JDK 17+ et Maven sont bien installés (`java -version`, `mvn -version`).
- En cas d'erreur liée au driver, WebDriverManager télécharge le driver au premier lancement : vérifie ta connexion internet.
- Consulte les logs Maven (`mvn test -X` pour plus de détails) en cas d'échec.

## Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/en/)
- [Cucumber Documentation](https://cucumber.io/docs/guides)
- [Maven Documentation](https://maven.apache.org/guides/)
- [WebDriverManager Documentation](https://github.com/bonigarcia/webdrivermanager)
