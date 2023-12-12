package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke or @Regression", // @Smoke larý ya da @Regression larý çalýþtýr demek @Smoke and @Regression da kullanýlabilir. (Her ikisinide çalýþtýr demek.)
        features = {"src/test/java/FeatureFiles"},//klasördeki bütün featurelar
        glue = {"StepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"} // Jenkins için JSON report eklentisi
)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
