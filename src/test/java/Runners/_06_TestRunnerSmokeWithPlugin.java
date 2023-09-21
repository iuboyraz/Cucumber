package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false, // default deðeri false. Eðer direkt testleri çalýþtýracaksan dryRun'ý kullanmana gerek yok.
        // true olduðunda çalýþtýrmadan testlerin stepleri (gerekli dosyalarý) var mý? diye kontrol eder.
        // false olduðunda ise testi çalýþtýrýr.
        plugin= {"html:target/site/cucumber-pretty.html"}  //Basit rapor
        // Rapor cinsi: html, pdf, json vs. olabilir.
        // Dosya yolu ve adý: target/site/cucumber-pretty.html
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
