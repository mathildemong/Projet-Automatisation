import utils.DriverManager;
import utils.Pause_Popup;
import utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQATest2 {

        public static void main(String[] args) {
            // Configuration automatique avec WebDriverManager
            DriverManager.setupDriver("chrome");

            // Lancement du navigateur
            WebDriver driver = WebDriverFactory.createDriver("chrome");

            // Aller sur le formulaire Text Box
            driver.get("https://demoqa.com/text-box");

            // Remplir le formulaire
            driver.findElement(By.id("userName")).sendKeys("Jean Dupont");
            driver.findElement(By.id("userEmail")).sendKeys("jean.dupont@example.com");
            driver.findElement(By.id("currentAddress")).sendKeys("123 rue de Paris");
            driver.findElement(By.id("permanentAddress")).sendKeys("456 avenue de Lyon");

            // Cliquer sur le bouton Submit
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            // Attendre un peu et afficher les résultats
            try {
                Thread.sleep(2000); // pause pour voir le résultat
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement outputName = driver.findElement(By.id("name"));
            WebElement outputEmail = driver.findElement(By.id("email"));

            System.out.println("Nom affiché : " + outputName.getText());
            System.out.println("Email affiché : " + outputEmail.getText());

            // Fermer le navigateur
            driver.quit();
        }
    }



