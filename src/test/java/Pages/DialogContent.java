package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent {
    public DialogContent(){
        PageFactory.initElements(GWD.getDriver(),this);
        // Kullan�laca�� zaman bu sayfadaki locatorlar� driver �zerinden initialize eder.
    }

    @FindBy (css="input[formcontrolname='username']")
    public WebElement username;

    @FindBy (css="input[formcontrolname='password']")
    public WebElement password;

    @FindBy (css="button[aria-label='LOGIN']")
    public WebElement loginButton;

    public void click(WebElement element){
        /* Bir butona t�klanaca�� zaman yap�lacak i�lemler;
        1- wait element to be clickable
        2- scroll to the element
        3- click
         */

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

        element.click();

    }

    public void sendKeys(WebElement element, String yazi){
        /* Bir textbox'�n sa�l�kl� �al��mas� i�in yap�lacak i�lemler;
        1- wait element to be visible
        2- scroll to the element
        3- clear
        4- sendKeys
         */

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();
        element.sendKeys(yazi);

    }

}
