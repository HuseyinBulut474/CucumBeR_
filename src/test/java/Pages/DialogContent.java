package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement acceptCookies;

    @FindBy(id="mat-input-0")
    private WebElement username;

    @FindBy(id="mat-input-1")
    private WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath="//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='middleName']//input")
    private WebElement middleName;

    @FindBy(xpath = "//input[@formcontrolname='employeeId']")
    private WebElement employeeID;

    @FindBy(xpath = "//*[@data-placeholder='Document Number']")
    private WebElement documentNumber;

    @FindBy(xpath = "//*[@data-placeholder='Country']")
    private WebElement country;

    @FindBy(xpath = "//span[text()=' Delete ']")
    private WebElement deleteOption;

    @FindBy(xpath = "//td[text()=' Cloudy ']/../td[7]/div/ms-edit-button/button")
    private WebElement editButtonOption;

    @FindBy(xpath = "//td[text()=' Cloudy ']/../td[7]/div//ms-delete-button//button")
    private WebElement deleteButtonOption;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {
        switch (strElement) {
            case "username" : myElement =username; break;
            case "password" : myElement =password; break;
            case "nameInput" : myElement =nameInput; break;
            case "codeInput" : myElement =codeInput; break;
            case "shortName" : myElement =shortName; break;
            case "searchInput" : myElement =searchInput; break;
            case "integrationCode" : myElement =integrationCode; break;
            case "priorityCode" : myElement =priorityCode; break;
            case "firstName" : myElement =firstName; break;
            case "lastName" : myElement =lastName; break;
            case "middleName" : myElement =middleName; break;
            case "employeeID" : myElement =employeeID; break;
            case "documentNumber" : myElement =documentNumber; break;
            case "country" : myElement =country; break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "acceptCookies": myElement = acceptCookies;break;
            case "loginButton" : myElement =loginButton; break;
            case "addButton" : myElement =addButton; break;
            case "saveButton" : myElement =saveButton; break;
            case "closeDialog" : myElement =closeDialog; break;
            case "searchButton" : myElement =searchButton; break;
            case "deleteButton" : myElement =deleteButton; break;
            case "deleteDialogBtn" : myElement =deleteDialogBtn; break;
            case "deleteOption" : myElement =deleteOption; break;
            case "editButtonOption" : myElement =editButtonOption; break;
            case "deleteButtonOption" : myElement =deleteButtonOption; break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {
        switch (strElement) {
            case "dashboard" : myElement =dashboard; break;
            case "successMessage" : myElement =successMessage; break;
            case "alreadyExist" : myElement =alreadyExist; break;
        }
        verifyContainsText(myElement, text);
    }
    public void searchAndDelete(String searchText) {
        findAndSend("searchInput", searchText);
        findAndClick("searchButton");

        waitUntilLoading(); //sayfa reload olana kadar bekle...
      //  WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
      //  wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));

        findAndClick("deleteButton");
        findAndClick("deleteDialogBtn");
    }

}

