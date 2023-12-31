package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends Parent{
    public DialogContent(){
        PageFactory.initElements(GWD.getDriver(),this);
        // Kullan�laca�� zaman bu sayfadaki locatorlar� driver �zerinden initialize eder.
    }
    @FindBy (css="input[formcontrolname='username']")
    public WebElement username;

    @FindBy (css="input[formcontrolname='password']")
    public WebElement password;
    @FindBy (css="button[aria-label='LOGIN']")
    public WebElement loginButton;
    @FindBy (css="span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement txtTechnoStudy;
    @FindBy(xpath="//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;
    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;
    @FindBy(xpath="//ms-text-field[@formcontrolname='code' ]//input")
    public WebElement codeInput;
    @FindBy(xpath="//ms-save-button/button")
    public WebElement saveButton;
    @FindBy(xpath="//div[contains(text(),'successfully')]")
    public WebElement successMessage;
    @FindBy(xpath="//*[@formcontrolname='shortName']//input")
    public WebElement shortName;
    @FindBy(xpath="//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;
    @FindBy(xpath="//mat-form-field//input[@data-placeholder='Name']")//ms-text-field[contains(@placeholder,'NAME')]//input
    public WebElement searchInput;
    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchButton;
    @FindBy(xpath="(//ms-delete-button//button)[1]")//(((//table//tbody//tr)[1]//td)[4]//button)[2]
    public WebElement deleteImageButton;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement deleteDialogButton;
    @FindBy(xpath="//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;
    @FindBy(xpath="//ms-integer-field[@formcontrolname='priority']/input")
    private WebElement priorityCode;
    @FindBy(xpath="//mat-slide-toggle[@formcontrolname='active']")
    private WebElement toggleBar;
    @FindBy(xpath="//mat-select//span[text()='Academic Period']")
    private WebElement academicPeriod;
    @FindBy(xpath="//mat-option/span")
    private WebElement academicPeriod1;
    @FindBy(xpath="(//span[text()='Grade Level'])[1]")
    private WebElement gradeLevel;
    @FindBy(xpath = "(//*[@role='option'])[4]") //@FindBy(xpath="(//mat-option//span)[2]")
    private WebElement gradeLevel2;
    @FindBy(xpath="//mat-select//span[text()='Test 2024']")
    private WebElement searchAcademicPeriod;
    @FindBy(xpath="//tbody[@role='rowgroup']//tr//td[2]")
    public List<WebElement> statesFirst10;
    //td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-name mat-column-name ng-tns-c1331969616-48 ng-star-inserted']
     public WebElement getWebElement(String strElement){
        switch (strElement){
            case "addButton": return this.addButton;
            case "saveButton": return this.saveButton;
            case "nameInput": return this.nameInput;
            case "codeInput": return this.codeInput;
            case "integrationCode": return this.integrationCode;
            case "priorityCode": return this.priorityCode;
            case "toggleBar": return this.toggleBar;
            case "academicPeriod": return this.academicPeriod;
            case "academicPeriod1": return this.academicPeriod1;
            case "gradeLevel": return this.gradeLevel;
            case "gradeLevel2": return this.gradeLevel2;
            case "searchAcademicPeriod": return this.searchAcademicPeriod;
        }
        return null;
    }
    public void deleteItem(String searchText) {
        mySendKeys(searchInput,searchText);
        myJsClick(searchButton);
        /*
        1. Y�ntem:
         Program� �al��t�rd���m�zda search i�leminden sonra ekran yenilendi�i i�in
         deleteButton1 elementte stale element hatas� olu�uyor.
         Bunu engellemek i�in citizenshipSearchButton cilickable olana kadar bekletiyoruz.
         dc.wait.until(ExpectedConditions.elementToBeClickable(dc.citizenshipSearchButton));
         */

        // 2. Y�ntem: wait.until(ExpectedConditions.stalenessOf(dc.deleteImageBtn)); //kullan�labilir ama her zaman ��zmez!

        /*
        3. Y�ntem:
        sayfan�n kendi waitini, search yap�ld���nda meydana gelen "loading" i�lemini yakalayal�m. (en sa�lam y�ntem)
        fuse-progress-bar/*    -> fuse-progress-bar �n �ocuklar� demek
        bu �ocuklar�n say�s� 0 olana kadar bekle.
        */
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));

        myJsClick(deleteImageButton);
        myJsClick(deleteDialogButton);
    }
}