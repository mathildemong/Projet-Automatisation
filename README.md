# Projet-Automatisation

A web (Selenium) and API (REST-assured) automation project, with test scenarios written in Gherkin and executed via Cucumber and JUnit 5.

## Prerequisites

- Java JDK 17 or higher
- Maven 3.6 or higher
- An IDE (e.g., IntelliJ, Eclipse)

## Installing Java and Maven on Windows (via Chocolatey)

On Windows (for example with Git Bash / MINGW64), if `mvn` is not recognized, Java and Maven can be installed via [Chocolatey](https://chocolatey.org/):

1. PowerShell should be opened **as administrator** (right-click > "Run as administrator").
2. Script execution should be allowed for the current session:
   ```powershell
   Set-ExecutionPolicy Bypass -Scope Process -Force
   ```
3. Chocolatey should be installed using the official script:
   ```powershell
   [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
   ```
4. PowerShell should be closed and reopened (still as administrator), then the installation can be verified:
   ```powershell
   choco -v
   ```
5. Maven can then be installed (Chocolatey also installs a compatible JDK if needed):
   ```powershell
   choco install maven -y
   ```
6. The terminal (PowerShell and/or Git Bash) should be fully closed and reopened so the PATH is reloaded.
7. The installation can be verified — **note that the command is `mvn`, not `maven`**:
   ```bash
   mvn -version
   ```
   The Maven version and detected Java version (17+ required) should be displayed.

## Installation

1. The repository can be cloned:
   ```bash
   git clone https://github.com/mathildemong/Projet-Automatisation.git
   cd Projet-Automatisation
   ```
2. Dependencies can be installed:
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
│       │   ├── api/         # ApiTest, ApiTest2 (API tests using REST-assured)
│       │   ├── runners/     # TestRunner (Cucumber entry point)
│       │   └── steps/       # StepDefinitions
│       └── resources/
│           └── features/    # Scenario_Correction.feature (Gherkin scenarios)
└── pom.xml
```

## Technologies

- Java 17
- Selenium WebDriver 4.38.0
- WebDriverManager 6.3.3 (automatically downloads and configures the matching Chrome/Firefox driver, with no manual installation required)
- Cucumber 7.32.0
- JUnit 5 (Jupiter) + JUnit Platform Suite
- REST-assured 5.5.6 (API tests)
- SLF4J (logging)

## Configuration

The browser driver is handled automatically by **WebDriverManager** through the `utils/WebDriverFactory.java` class — no manual configuration of the ChromeDriver binary is required.

## Test Execution

All tests (Cucumber + JUnit) can be run with:

```bash
mvn test
```

Cucumber reports are generated in `target/cucumber-reports/` (`cucumber.html` and `cucumber.json`), as configured in `runners/TestRunner.java`.

## Examples

- The example scenario `Scenario_Correction.feature` (in `src/test/resources/features`) fills out a form on DemoQA (the "Text Box" section) and verifies its submission.

## Page Object Model

- Page classes are implemented in `src/main/java/pages/model` (`WebButton`, `WebLabel`, `WebPage`, `WebTextBox`).
- `WebButton.Click` scrolls the target element into view and falls back to a JavaScript click if a normal click is intercepted by an overlapping element (see Troubleshooting).

## Cucumber Tests

- Steps are defined in `src/test/java/steps/StepDefinitions.java`.
- The Cucumber runner (`src/test/java/runners/TestRunner.java`) links features to steps via `@SelectClasspathResource("features")` and `GLUE_PROPERTY_NAME = "steps, hooks"`.

## API Tests

- API tests (REST-assured) can be found in `src/test/java/api/` (`ApiTest.java`, `ApiTest2.java`).

## Troubleshooting

- It should be verified that JDK 17+ and Maven are properly installed (`java -version`, `mvn -version`).
- If a driver-related error occurs, WebDriverManager downloads the driver on first launch, so an internet connection should be checked.
- Maven logs (`mvn test -X` for more detail) should be consulted in case of failure.
- **Browser window not visible on Windows**: if `chrome.exe` and `chromedriver.exe` appear in Task Manager (Details tab) while running `mvn test`, but no visible Chrome window ever shows up, this is a known issue with the `--start-maximized` startup flag on some Windows configurations (particularly with display scaling enabled) — it can cause the window to render off-screen or with zero size. The fix applied in `utils/DriverManager.java` is to drop `--start-maximized` and instead set an explicit window position and size, both as Chrome arguments and via `webDriver.manage().window()`, after the driver is created:
  ```java
  ChromeOptions options = new ChromeOptions();
  options.addArguments("--disable-notifications");
  options.addArguments("--window-position=0,0");
  options.addArguments("--window-size=1280,800");

  WebDriver webDriver = new ChromeDriver(options);
  webDriver.manage().window().setPosition(new org.openqa.selenium.Point(0, 0));
  webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1280, 800));
  ```
- A `Pause_Popup.showContinuePopup()` call (see `utils/Pause_Popup.java`) can be added at the end of a step definition to pause execution with a Swing dialog, which is useful for visually confirming the browser window during a run before it closes.
- **`element click intercepted` error on the submit button**: on some window sizes, DemoQA's footer can overlap the "submit" button, causing Selenium to throw `ElementClickInterceptedException`. This is handled in `pages/model/WebButton.java`: the element is first scrolled to the center of the viewport (`scrollIntoView({block: 'center'})`), and if the click is still intercepted, a JavaScript click (`arguments[0].click()`) is used as a fallback, since it bypasses the visual overlap entirely.

## Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/en/)
- [Cucumber Documentation](https://cucumber.io/docs/guides)
- [Maven Documentation](https://maven.apache.org/guides/)
- [WebDriverManager Documentation](https://github.com/bonigarcia/webdrivermanager)
