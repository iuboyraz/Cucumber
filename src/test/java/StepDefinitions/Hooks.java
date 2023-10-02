package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before // cucumber'in annotation'i
    public void before() {
        // System.out.println("Senaryo baþladý mý?");
    }

    @After // cucumber'ýn annotation'ý
    public void after(Scenario scenario) {
        ExcelUtility.writeToExcel("src/test/java/ApachePOI/ExcelFiles/SenaryoSonuclari3.xlsx",
                scenario);

        // runner dosyasýnda "plugin" varsa aþaðýdaki kod blok AÇIK kalsýn.
        // Ör: _06_TestRunnerSmokeWithPlugin ve _07_TestRunnerExtentReport
        // diðer classlarda KAPALI kalsýn. Çünkü plugin olmayacaðý için senaryoyu bulamaz ve hata verir.

        // extend report'a screenshot eklemek için bu if blok yazýldý.
        if (scenario.isFailed()) {
            TakesScreenshot ts = ((TakesScreenshot) GWD.getDriver());
            byte[] inMemory = ts.getScreenshotAs(OutputType.BYTES); // Baþka bir dosyaya ekleyebilmek için tip byte seçildi.
            //https://www.programsbuzz.com/article/how-add-screenshot-cucumber-extent-report-every-step den aldýk.
            // GenericFunctions.getByteScreenshot() -> inMemory ile deðiþtirildi.
            scenario.attach(inMemory, "image/png", "screenshot name");
        }
        // System.out.println("Senaryo bitti mi?");
        // doðru çalýþýrsa quitDriver()'ý çaðýracaðýz.
        GWD.quitDriver(); // driver'ý kapattýk.
    }
}
