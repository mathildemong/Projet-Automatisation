package pages.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebButton {

    public static void Click(WebDriver driver, String strXPATH, String s){

        WebElement Button = driver.findElement(By.xpath(strXPATH));
        Button.click();

    }

}
