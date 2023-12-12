package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // a�a��daki testlerde smoke olanlar� �al��t�r.
        tags = "@Smoke", //@Regression da denilebilir. �lgili FeatureFiles ta da gerekli annotation verilir.
        features = {"src/test/java/FeatureFiles"},//klas�rdeki b�t�n feature lar
        glue={"StepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"} // Jenkins i�in JSON report eklentisi
)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
