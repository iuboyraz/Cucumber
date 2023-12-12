package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false, // default deðeri false. Eðer testleri direkt çalýþtýracaksan dryRun'ý kullanmana gerek yok.
        // true olduðunda testler çalýþmadan önce FeatureFiles larýn StepDefinitons larý (yani gerekli çalýþtýrma dosyalarý) var mý? diye kontrol eder.
        // false olduðunda ise testleri çalýþtýrýr.

        plugin={
                "pretty",//Ben ekledim -> raporlarin daha okunakli olmasi icin
                "html:target/site/cucumber-pretty.html"
               },
        // Basit rapor olup raporun cinsi: html, pdf, json, xml vs. olabilir.
        // Rapor cinsi (html), yolu ve dosya adý (cucumber-pretty.html)
        // "html:target/site/cucumber-pretty.html"

        // pom.xml'e gerekli dependency i eklemek þartýyla aþaðýdaki raporlamalar da kullanýlabilir.
        // "json:target/json-reports/cucumber.json", -> JSON rapor tipi için kullanýlabilir
        // "junit:test-output/htmlReport/cucumber.xml", -> xml rapor tipi için kullanýlabilir.
        monochrome = true //Ben ekledim -> test adýmlarýnýn console da alt alta düzenli bir sekilde cikmasi icin
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
