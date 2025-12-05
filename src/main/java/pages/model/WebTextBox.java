package pages.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTextBox {

    public static void SetText(WebDriver driver, String strXPATH, String strText){

        WebElement TextField = driver.findElement(By.xpath(strXPATH));
        TextField.sendKeys(strText);

    }

    public static String GetText(WebDriver driver, String strXPATH){

        String strTextFieldValue = "";

        WebElement TextField = driver.findElement(By.xpath(strXPATH));
        strTextFieldValue = TextField.getAttribute("value");

        return strTextFieldValue;

    }

    public static Boolean CheckText(WebDriver driver, String strXPATH, String strExpectedValue){

        Boolean Rslt = false ;

        String ActualValue = GetText(driver, strXPATH);

        if (strExpectedValue.equals(ActualValue)){

            System.out.println("Test Reussi");
            Rslt = true;

        } else {

            System.out.println("Erreur TextBox : "  +  strXPATH +  " Valeur attendue = " + strExpectedValue + " Valeur Observée = " + ActualValue );

        }

        return Rslt;

    }

}
