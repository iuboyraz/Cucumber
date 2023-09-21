package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // a�a��daki testlerde smoke olanlar� �al��t�r.
        tags = "@SmokeTest", //@Regression da denilebilir. �lgili FeatureFiles ta da gerekli annotation verilir.
        features = {"src/test/java/FeatureFiles"},//klas�rdeki b�t�n featurelar
        glue={"StepDefinitions"}
)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
