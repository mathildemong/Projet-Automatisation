package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.model.WebButton;
import pages.model.WebLabel;
import pages.model.WebTextBox;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class StepDefinitions {

    private final WebDriver driver;

    public StepDefinitions() {
        // Récupère le driver déjà initialisé par les Hooks
        this.driver = DriverManager.getDriver();
    }

    @Given("je suis sur la page DemoQA dans la section {string}")
    public void jeSuisSurLaPageDemoQADansLaSection(String sectionName) {
        // Navigation vers la page
        driver.get("https://demoqa.com/text-box");

        // Vérification du titre de la section
        WebLabel.CheckText(driver, "//h1[contains(.,'Text Box')]", sectionName);
    }

    @When("je remplis le champ {string} avec la valeur {string}")
    public void jeRemplisLeChampAvecLaValeur(String fieldName, String strValue) {
        WebTextBox.SetText(driver, "//input[@id='" + fieldName + "']", strValue);
    }

    @And("je clique sur le bouton {string}")
    public void jeCliqueSurLeBouton(String buttonName) {
        WebButton.Click(driver, "//button[@id='" + buttonName + "']", "button ame: submit ");
    }

    @Then("le formulaire est pret a etre soumis")
    public void leFormulaireEstPretAEtreSoumis() {
                WebLabel.CheckText(driver, "//p[@id='name']", "Name:Jean Dupont");
        WebLabel.CheckText(driver, "//p[@id='email']", "Email:jean.dupont@example.com");
        WebLabel.CheckText(driver, "//p[@id='currentAddress']", "Current Address :123 rue de Paris");
        WebLabel.CheckText(driver, "//p[@id='permanentAddress']", "Permanent Address :456 avenue de Lyon");

    }
}