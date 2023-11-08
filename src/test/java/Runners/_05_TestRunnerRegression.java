package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest or @Regression", // @SmokeTest and @Regression da kullan�labilir.
        features = {"src/test/java/FeatureFiles"},//klas�rdeki b�t�n featurelar
        glue = {"StepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"} // Jenkins i�in JSON report eklentisi
)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
