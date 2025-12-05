package pages.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebLabel {

    public static boolean CheckText(WebDriver driver, String strXPATH, String strExpectedValue){

        boolean Rslt = false ;

        String ActualValue = GetText(driver, strXPATH);

        if (strExpectedValue.equals(ActualValue)){

            System.out.println("Test Reussi");
            Rslt = true;

        } else {

            System.out.println("Erreur Label : "  +  strXPATH +  " Valeur attendue = " + strExpectedValue + " Valeur Observée = " + ActualValue );

        }

        return Rslt;

    }

    public static String GetText(WebDriver driver, String strXPATH){

        String strLabelValue = "";

        WebElement Label = driver.findElement(By.xpath(strXPATH));
        strLabelValue = Label.getText();

        return strLabelValue;

    }

}
