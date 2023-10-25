package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.List;

public class _14_JDBCStatesSteps {

    DialogContent dc = new DialogContent();

    @Then("Send the {string} query to the Database and check if it matches with UI")
    public void sendTheQueryToTheDatabaseAndCheckIfItMatchesWithUI(String sql) {

        // DB den oku
        List<List<String>> dbList = DBUtility.getDataList(sql); // DB den okudum

        System.out.println("----------------------dbList-----------------------------");
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(0)); // DB yi yazdýrdým
        }

        System.out.println("----------------------statesFirst10List------------------");

        // UI dan oku
        List<WebElement> statesFirst10List = dc.statesFirst10; // UI yý okudum
        for (int i = 0; i < statesFirst10List.size(); i++) {
            System.out.println(statesFirst10List.get(i).getText());// UI yý yazdýrdým
        }

        System.out.println("-----------------------matches----------------------------");

        // karþýlaþtýr
        for (int i = 0; i < statesFirst10List.size(); i++) {
            System.out.println(dbList.get(i).get(0) + " - " + statesFirst10List.get(i).getText());
            Assert.assertEquals(dbList.get(i).get(0).trim(), statesFirst10List.get(i).getText().trim(), "No match !!!");
        }
    }
}
