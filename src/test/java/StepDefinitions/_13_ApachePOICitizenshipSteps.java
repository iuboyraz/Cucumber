package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _13_ApachePOICitizenshipSteps {

    DialogContent dc = new DialogContent();

    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {

        // getData ile excelden oku
        // for döngüsü ile kaydet

        ArrayList<ArrayList<String>> tablo = ExcelUtility.getData(
                ("src/test/java/ApachePOI/ExcelFiles/ApacheExcel2.xlsx"), "testCitizen",2);

        for (List<String> satir : tablo){
            dc.myClick(dc.addButton);
            dc.mySendKeys(dc.nameInput, satir.get(0));
            dc.mySendKeys(dc.shortName, satir.get(1));
            dc.myClick(dc.saveButton);
            dc.verifyContainsText(dc.successMessage,"success");
        }
    }

    @Then("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() throws InterruptedException {

        // getData ile excelden oku
        // for döngüsü ile sil

        ArrayList<ArrayList<String>> tablo = ExcelUtility.getData(
                ("src/test/java/ApachePOI/ExcelFiles/ApacheExcel2.xlsx"), "testCitizen",2);

        for (ArrayList<String> satir : tablo){
            dc.deleteItem(satir.get(0));
            dc.verifyContainsText(dc.successMessage,"success");
        }
    }
}
