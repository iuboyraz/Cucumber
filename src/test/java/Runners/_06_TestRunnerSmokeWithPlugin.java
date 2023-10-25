package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false, // default deðeri false. Eðer testleri direkt çalýþtýracaksan dryRun'ý kullanmana gerek yok.
        // true olduðunda çalýþtýrmadan FeatureFileslerin DefinitonStepleri (yani gerekli çalýþtýrma dosyalarý) var mý? diye kontrol eder.
        // false olduðunda ise testi çalýþtýrýr.
        plugin= {"html:target/site/cucumber-pretty.html"}
        // Basit rapor olup raporun cinsi: html, pdf, json vs. olabilir.
        // Klasör adý (html), yolu ve dosya adý (cucumber-pretty.html)
        // "html:target/site/cucumber-pretty.html"

        // pom.xml'e gerekli dependency si eklenmek þartýyla aþaðýdaki raporlamalar da kullanýlabilir.
        // "json:target/json-reports/cucumber.json", -> JSON rapor tipi için kullanýlabilir
        // "junit:test-output/htmlReport/cucumber.xml", -> xml rapor tipi için kullanýlabilir.
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
