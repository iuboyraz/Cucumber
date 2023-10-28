package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD_Old {
    private static WebDriver driver;
    public static WebDriver getDriver() {

        Logger logger = Logger.getLogger("");
        // output yapýlan loglarý al,
        logger.setLevel(Level.SEVERE);
        //<!--# logging level hierarchy: ALL -> TRACE -> DEBUG -> INFO -> WARN -> ERROR -> FATAL -> OFF
        // sadece ERRORLARI göster. Yani hata seviyesi YÜKSEK olanlarý göster.
        // Böylece chrome vb browser güncelleme eksikliklerinin hatalarýný run kýsmýnda göstermeyecek.

        // extend report'un türkçe bilgisayarlarda çalýþmamasý nedeniyle eklendi.
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
        // test sonucunun ekranda bir miktar beklemesi için
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
