package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false, // default de�eri false. E�er testleri direkt �al��t�racaksan dryRun'� kullanmana gerek yok.
        // true oldu�unda �al��t�rmadan FeatureFileslerin DefinitonStepleri (yani gerekli �al��t�rma dosyalar�) var m�? diye kontrol eder.
        // false oldu�unda ise testi �al��t�r�r.
        plugin= {"html:target/site/cucumber-pretty.html"}
        // Basit rapor olup raporun cinsi: html, pdf, json vs. olabilir.
        // Klas�r ad� (html), yolu ve dosya ad� (cucumber-pretty.html)
        // "html:target/site/cucumber-pretty.html"

        // pom.xml'e gerekli dependency si eklenmek �art�yla a�a��daki raporlamalar da kullan�labilir.
        // "json:target/json-reports/cucumber.json", -> JSON rapor tipi i�in kullan�labilir
        // "junit:test-output/htmlReport/cucumber.xml", -> xml rapor tipi i�in kullan�labilir.
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
