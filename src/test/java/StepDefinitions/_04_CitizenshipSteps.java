package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _04_CitizenshipSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to citizenship")
    public void navigateToCitizenship() {

        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenships);
    }

    @When("Create a citizenship")
    public void createACitizenship() {
        String citizenshipName = RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenshipShortCode = RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, citizenshipName);
        dc.mySendKeys(dc.shortName, citizenshipShortCode);
        dc.myClick(dc.saveButton);
    }
    /*
     _05_CitizenshipParameter.feature dosyas�nda Background ve scenarios olu�turduk.
     1. scenario da name as "" ve code as "" yap�s�n� kulland�k.
    */
    @When("Create a citizenship name as {string} shortname as {string}")
    public void createACitizenshipNameAsShortnameAs(String name, String shortName) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, name);
        dc.mySendKeys(dc.shortName, shortName);
        dc.myClick(dc.saveButton);
    }

     //_05_CitizenshipParameter.feature dosyas�nda 2. scenario da "already" mesaj�n� verify ettik.
    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.alreadyExist, "already");
    }
    //_06_ScenarioOutlineCitizenship.feature de parametre ile olu�turdu�umuz kay�tlar�
    //_07_CitizenshipDelete.feature dosyas�nda yine parametre ile sildik.
    @When("User delete the name {string}")
    public void deleteACitizenshipNameAs(String name) {
        dc.deleteItem(name);
    }
}
