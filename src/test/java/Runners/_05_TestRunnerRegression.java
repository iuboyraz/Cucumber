package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke or @Regression", // @Smoke lar� ya da @Regression lar� �al��t�r demek @Smoke and @Regression da kullan�labilir. (Her ikisinide �al��t�r demek.)
        features = {"src/test/java/FeatureFiles"},//klas�rdeki b�t�n featurelar
        glue = {"StepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"} // Jenkins i�in JSON report eklentisi
)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
