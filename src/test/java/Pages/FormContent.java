package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FormContent extends Parent {

    public FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;

    @FindBy(xpath = "(//ms-date[@formcontrolname='dateOfBirth']/mat-form-field/div/div)[1]/div")
    private WebElement dateOfBirth;

    @FindBy(xpath = "(//button[@class='mat-calendar-body-cell mat-calendar-body-active']//div)[1]")
    private WebElement dateOfBirthOption;

    @FindBy(xpath = "(//mat-form-field[@formgroupname='profile']/div/div/div/mat-select/div)[1]")
    private WebElement gender;

    @FindBy(xpath = "//span[text()=' Male ']")
    private WebElement genderOption;

    @FindBy(xpath = "//div[text()='Contact & Address']")
    private WebElement contact;

    @FindBy(xpath = "//mat-select[@formcontrolname='type']/div")
    private WebElement documentType;

    @FindBy(xpath = "//span[text()=' Personal ID ']")
    private WebElement personalOption;

    @FindBy(xpath = "//span[text()='India']")
    private WebElement India;


    WebElement myElement;
    public void findAndClick(String strElement) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "academicPeriod": myElement = academicPeriod;break;
            case "academicPeriod1": myElement = academicPeriod1;break;
            case "gradeLevel": myElement = gradeLevel;break;
            case "gradeLevel2": myElement = gradeLevel2;break;
            case "dateOfBirth" : myElement =dateOfBirth ; break;
            case "dateOfBirthOption" : myElement =dateOfBirthOption ; break;
            case "gender" : myElement =gender ; break;
            case "genderOption" : myElement =genderOption ; break;
            case "contact" : myElement =contact ; break;
            case "documentType" : myElement =documentType ; break;
            case "personalOption" : myElement =personalOption ; break;
            case "India" : myElement =India ; break;
        }
        clickFunction(myElement);
        if (myElement == academicPeriod || myElement == gradeLevel)
            GWD.Bekle(2);
    }
}