package Pages;

import Utilities.GWD;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.event.KeyEvent;
import java.time.Duration;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class Parent {

    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public void myClick(WebElement element){
        /*
        Bir butona týklanacaðý zaman yapýlacak iþlemler;
        1- wait element to be clickable
        2- scroll to the element
        3- click
         */

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public void mySendKeys(WebElement element, String yazi){
        /*
        Bir textbox'ýn saðlýklý çalýþmasý için yapýlacak iþlemler;
        1- wait element to be visible
        2- scroll to the element
        3- clear
        4- sendKeys
         */

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(yazi);

    }

    public void ScrollIntoElement (WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void verifyContainsText(WebElement element, String value){

        wait.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        //Programý çalýþtýrdýðýmýzda silmede çýkan mesaj (dialog kutusu) Unable to locate element hatasý oluþturuyor.
        //Actions ile ESC ye basarak çýkan mesajý kapatarak çözdük.
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();

    }

}
