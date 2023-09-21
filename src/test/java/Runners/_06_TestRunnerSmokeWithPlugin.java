package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false, // default de�eri false. E�er direkt testleri �al��t�racaksan dryRun'� kullanmana gerek yok.
        // true oldu�unda �al��t�rmadan testlerin stepleri (gerekli dosyalar�) var m�? diye kontrol eder.
        // false oldu�unda ise testi �al��t�r�r.
        plugin= {"html:target/site/cucumber-pretty.html"}  //Basit rapor
        // Rapor cinsi: html, pdf, json vs. olabilir.
        // Dosya yolu ve ad�: target/site/cucumber-pretty.html
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
