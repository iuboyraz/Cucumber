package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature"},// ->Featurefiles'�n path'i yaz�lacak.
        glue={"StepDefinitions"}//-> StepDefinitions'�n klas�r� yaz�l�yor.

)
public class _01_TestRunner extends AbstractTestNGCucumberTests {
}
