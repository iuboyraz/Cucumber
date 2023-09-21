package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {
    private static WebDriver driver;

    public static WebDriver getDriver() {

        // extend report'un t�rk�e bilgisayarlarda �al��mamas� nedeniyle eklendi.
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void quitDriver() {
        // test sonucunun ekranda bir miktar beklemesi i�in
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) { // driver var ise
            driver.quit();
            driver = null;
        }
    }
}
