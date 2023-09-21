package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to country")
    public void navigateToCountry() {
        /*
        setup
        parameter
        country
         */
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.countries);
    }

    @When("Create a country")
    public void createACountry() {
        /*
        + tu�una bas
        �lke ad�n� gir
        �lke kodunu gir
        save tu�una bas
         */

        // Random �lke ad� ve codu �retme i�lemi
        // Bunun i�in pom.xml'e org.apache.commons eklendi.
        String ulkeAdi = RandomStringUtils.randomAlphanumeric(8);//8 harf
        String ulkeKodu = RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, ulkeAdi);//"AliCabbarCountry59"
        dc.mySendKeys(dc.codeInput, ulkeKodu);//"cabbar59"
        dc.myClick(dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        //success yaz�s� ��kt� m� kontrol et.
        dc.verifyContainsText(dc.successMessage, "success");
    }
    /*
     _03_CountryMultipleScenarios.feature dosyas�nda Background ve scenarios olu�turduk.
     2. scenario da name as "" ve code as "" yap�s�n� kulland�k.
    */
    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, name);
        dc.mySendKeys(dc.codeInput, code);
        dc.myClick(dc.saveButton);
    }
}
