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
        + tuþuna bas
        ülke adýný gir
        ülke kodunu gir
        save tuþuna bas
         */
        String ulkeAdi = RandomStringUtils.randomAlphanumeric(8);//8 harf
        String ulkeKodu = RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, "AliCabbarCountry59");
        dc.mySendKeys(dc.codeInput, "cabbar59");
        dc.myClick(dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        /*
        success yazýsý çýktý mý kontrol et.
         */
        dc.verifyContainsText(dc.successMessage, "success");
    }
}
