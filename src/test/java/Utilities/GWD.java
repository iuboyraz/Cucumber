package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    //threadDriver.get()  -> bulunduðum thread deki driver'ý al
    //threadDriver.set(driver)  -> bulunduðum thread'e driver'ý ver

    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {

        Logger logger = Logger.getLogger("");
        // output yapýlan loglarý al,
        logger.setLevel(Level.SEVERE);
        // sadece ERRORLARI göster. Yani hata seviyesi YÜKSEK olanlarý göster.
        // Böylece chrome vb browser güncelleme eksikliklerinin hatalarýný run kýsmýnda göstermeyecek.

        // extend report'un türkçe bilgisayarlarda çalýþmamasý nedeniyle eklendi.
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        // Bu if code xmlden çalýþtýrma yapýlmadýðýnda yani runnerslardan çalýþtýrýldýðýnda çalýþacak.
        // Bu if code alttaki if code a eklenmedi çünkü null deðer geldiðinde switch onu görüp default deðere yönlendirmiyor.
        if (threadBrowserName.get() == null)  // eðer driver boþ ise 1 kere çalýþsýn.
            threadBrowserName.set("chrome");// ve driver chromeDriver olsun

        // gelen browser ismine göre firefox, edge, safari, chrome, browser switch ile set ediliyor.
        if (threadDriver.get() == null) {// eðer driver boþ ise 1 kere çalýþsýn.
            switch (threadBrowserName.get()) {
                case "firefox":// ilgili thread/pipe'e (runnerstan gelen browser isteðine) bir FirefoxDriver'ý set ettim.
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;
                default:
                    // ilgili thread/pipe'e (runnerstan browser isteði gelmezse) default olarak ChromeDriver'ý set ettim.
                    threadDriver.set(new ChromeDriver());
            }
        }
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return threadDriver.get();// bulunduðum thread (pipe)'için driver al.
    }

    public static void quitDriver() {
        // test sonucunun ekranda bir miktar beklemesi için
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (threadDriver.get() != null) { // driver var ise
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get(); // direkt eþitleme yapamadýðým için içindekini al
            driver = null;// null'a eþitle

            threadDriver.set(driver);// kendisine null olarak ver böylece bu thread/pipe ta dolu bir driver kalmadý.
        }
    }
}
