package Runners;

import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class _08_ParallelTest extends AbstractTestNGCucumberTests {
// extent report'a ek bilgiler eklemek için aþaðýdaki kod satýrý eklendi.
//Ornek:Test Reports/TestReport 21-Eyl-23 21.49.33/test-output/SparkReport/Spark.html dosyasý tiklanarak rapor görülebilir.

    // cross browser testi için XML klasöründeki .xml dosyasýnda istediðin browserlarý set et ve çalýþtýr.
    @BeforeClass
    @Parameters("browserTipi")
    public void beforeClass(String browserName)
    {
        GWD.threadBrowserName.set(browserName);
    }

    @AfterClass
    public static void writeExtentReport(){
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name")); // username : Umit Boyraz
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "Umit Boyraz");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satýr", "Aciklama");
        ExtentService.getInstance().setSystemInfo("Ek Satýr", "Aciklama");
        ExtentService.getInstance().setSystemInfo("Ek Satýr", "Aciklama");
        ExtentService.getInstance().setSystemInfo("Ek Satýr", "Aciklama");
    }
}
