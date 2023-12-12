package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // aþaðýdaki testlerde smoke olanlarý çalýþtýr.
        tags = "@Smoke", //@Regression da denilebilir. Ýlgili FeatureFiles ta da gerekli annotation verilir.
        features = {"src/test/java/FeatureFiles"},//klasördeki bütün feature lar
        glue={"StepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"} // Jenkins için JSON report eklentisi
)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
