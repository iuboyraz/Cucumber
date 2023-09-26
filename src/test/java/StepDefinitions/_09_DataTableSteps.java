package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _09_DataTableSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the element in the LeftNav")
    public void clickOnTheElementInLeftNav(DataTable links) {
        List<String> strlinkList = links.asList(String.class);

        for (int i = 0; i < strlinkList.size(); i++) {
            WebElement linkWebElement = ln.getWebElement(strlinkList.get(i));
            ln.myClick(linkWebElement);
        }
        //ln.myClick(ln.getWebElement(strlinkList.get(i)));
    }

    @And("Click on the element in the DialogContent")
    public void clickOnTheElementInDialogContent(DataTable buttons) {
        List<String> strButtonsList = buttons.asList(String.class);

        for (int i = 0; i < strButtonsList.size(); i++) {
            WebElement buttonWebElement = dc.getWebElement(strButtonsList.get(i));
            dc.myClick(buttonWebElement);
        }
    }

    @And("User sends the keys into the DialogBox")
    public void userSendsTheKeysIntoTheDialogBox(DataTable data) {
        List<List<String>> items = data.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement element = dc.getWebElement(items.get(i).get(0));
            String text = items.get(i).get(1);//Önce 1.elementin daha sonra 2.elementin texti

            dc.mySendKeys(element, text);
        }
    }

    @And("User deletes the element from the DialogBox")
    public void userDeletesTheElementFromTheDialogBox(DataTable willBeDeletedText) {
        List<String> willBeDeletedItems = willBeDeletedText.asList(String.class);

        for (int i = 0; i < willBeDeletedItems.size(); i++) {
            dc.deleteItem(willBeDeletedItems.get(i));

        }
    }
}

