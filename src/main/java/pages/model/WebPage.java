package pages.model;

import utils.DriverManager;
import utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebPage {

    private static WebDriver driver;

    public static Boolean VerifierLancement(String strUrl, String strBrowser,String strPageAttendue) {

        //String PageAttendue = "DEMOQA";
        String PageObservee= "";
        Boolean ResultatTest = false;

        // Configuration automatique avec WebDriverManager
        DriverManager.setupDriver(strBrowser);

        // Lancement du navigateur
        driver = WebDriverFactory.createDriver(strBrowser);

        // Exemple de test
        driver.get(strUrl);
        PageObservee = driver.getTitle();
        System.out.println("Titre de la page: " + PageObservee);

        //assertEquals(PageAttendue,PageObservee);

        if (strPageAttendue.equals(PageObservee)){

            ResultatTest = true;
            System.out.println("Test reussi");

        } else {

            ResultatTest = false;
            System.out.println("Erreur test : Valeur attendue = " + strPageAttendue + " Valeur Observée = " + PageObservee );

        }

        System.out.println("Fin du test");

        // Fermeture
        //driver.quit();

        return ResultatTest;

    }

    public static void closeBrowser(){

        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("Erreur closeBrowser driver null");
        }


    }

    public static WebDriver getDriver(){

        return driver;

    }

    public static void main(String[] args) {

        Boolean Rslt = VerifierLancement("https://demoqa.com/","chrome","DEMOQA");

    }
}