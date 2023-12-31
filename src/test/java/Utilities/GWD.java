package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    //threadDriver.get()  -> bulundu�um thread deki driver'� getir
    //threadDriver.set(driver)  -> bulundu�um thread'e driver'� ayarla

    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {

        Logger logger = Logger.getLogger("");
        // output yap�lan loglar� al,
        logger.setLevel(Level.SEVERE);
        //<!--# logging level hierarchy: ALL -> TRACE -> DEBUG -> INFO -> WARN -> ERROR -> FATAL -> OFF
        // sadece ERRORLARI g�ster. Yani hata seviyesi Y�KSEK olanlar� g�ster.
        // B�ylece chrome vb browser g�ncelleme eksikliklerinin hatalar�n� run k�sm�nda g�stermeyecek.

        // extend report'un t�rk�e bilgisayarlarda �al��mamas� nedeniyle eklendi.
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        // Bu if code xmlden �al��t�rma yap�lmad���nda yani runnerslardan �al��t�r�ld���nda �al��acak.
        // Bu if code alttaki if code a eklenmedi ��nk� null de�er geldi�inde switch onu g�r�p default de�ere y�nlendirmiyor.
        if (threadBrowserName.get() == null)  // e�er driver bo� ise 1 kere �al��s�n.
            threadBrowserName.set("firefox");// ve driver FirefoxDriver olsun

        // gelen browser ismine g�re firefox, edge, safari, chrome, browser switch ile set ediliyor.
        if (threadDriver.get() == null) {// e�er driver bo� ise 1 kere �al��s�n.
            switch (threadBrowserName.get()) {// ilgili thread/pipe'a ParallelTesting.xml den _08_ParallelTest runner class'a gelen browser iste�ine g�re bir Driver'� set ediyorum.
                case "chrome":
                    threadDriver.set(new ChromeDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;
                default:
                    if (isRunningOnJenkins()) {
                        //Jenkinste firefox un memory sinin maximum �al��mas� i�in "headless" kod eklendi
                        FirefoxOptions options = new FirefoxOptions();
                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                        // ilgili thread/pipe'e (runnerstan browser iste�i gelmezse) default olarak FirefoxDriver'� set ettim.
                        threadDriver.set(new FirefoxDriver());
                    }
                    else {
                        threadDriver.set(new ChromeDriver()); // E�er test Jenkinsten �al��t�r�lm�yorsa ilgili threade ChromeDriver'� set ettim
                    }

                    //Jenkinste edge in memory sinin maximum �al��mas� i�in "headless" ve default kod
                    /*
                    EdgeOptions eOptions = new EdgeOptions();
                    eOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                    threadDriver.set(new EdgeDriver(eOptions));
                     */
            }
        }
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return threadDriver.get();// bulundu�um thread (pipe) i�in driver al.
    }

    public static void quitDriver() {
        // test sonucunun ekranda bir miktar beklemesi i�in
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (threadDriver.get() != null) { // driver var ise
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get(); // direkt e�itleme yapamad���m i�in i�indekini al
            driver = null;// null'a e�itle

            threadDriver.set(driver);// kendisine null olarak ver b�ylece bu thread/pipe ta dolu bir driver kalmad�.
        }
    }

    public static boolean isRunningOnJenkins() {
        String jenkinsHome = System.getenv("JENKINS_HOME");
        return jenkinsHome != null && !jenkinsHome.isEmpty();
    }
}
