package parabank_first5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPatientPage extends UtilityComponents {
    public RegisterPatientPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement pageTitle;

    @FindBy(name = "givenName")
    WebElement givenName;
    @FindBy(name = "familyName")
    WebElement familyName;
    @FindBy(id = "next-button")
    WebElement nextBtn;
    @FindBy(id = "birthdateYears-field")
    WebElement birthdateYear;
    @FindBy(id = "birthdateMonths-field")
    WebElement birthdateMonths;
    @FindBy(id = "address1")
    WebElement address1;
    @FindBy(id = "address2")
    WebElement address2;
    @FindBy(id = "cityVillage")
    WebElement cityVillage;
    @FindBy(id = "stateProvince")
    WebElement stateProvince;
    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "postalCode")
    WebElement postalCode;
    @FindBy(name = "phoneNumber")
    WebElement phoneNumber;
    @FindBy(xpath = "//input[@placeholder='Person Name']")
    WebElement relationName;
    @FindBy(id = "submit")
    WebElement submitBtn;

    By gender = By.id("gender-field");
    By relationship_type = By.id("relationship_type");

    public void fillPatientDemographics(String gname,String gFamilyName,String ggender,String gBirthYear,String gBirthMon) {
        givenName.sendKeys(gname);
        familyName.sendKeys(gFamilyName);
        nextBtn.click();
        selectOption(gender, ggender);
        nextBtn.click();

        birthdateYear.sendKeys(gBirthYear);
        birthdateMonths.sendKeys(gBirthMon);
        nextBtn.click();

    }

    public void fillPatientContactInfo(String addr1,String addr2,String cityVill,String gstate,String gcountry,String postal,String gphone) {
        address1.sendKeys(addr1);
        address2.sendKeys(addr2);
        cityVillage.sendKeys(cityVill);
        stateProvince.sendKeys(gstate);
        country.sendKeys(gcountry);
        postalCode.sendKeys(postal);
        nextBtn.click();
        phoneNumber.sendKeys(gphone);
        nextBtn.click();

    }

    public void fillRelationInfo(String grelationType,String grelationName) {
        selectOption(relationship_type, grelationType);
        relationName.sendKeys(grelationName);
        nextBtn.click();
        submitBtn.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    @FindBy(css = ".PersonName-givenName")
    WebElement personFirstName;

    public String getPatientFirstName()
    {
        waitForElementToAppear(By.className("PersonName-givenName"));
        return personFirstName.getText();
    }
    public String getRegisterPatientGender(){
        PatientRecordPage patientRecordPage= new PatientRecordPage(driver);
        return patientRecordPage.getPatientGender();
    }

    public String getRegisterPatientAddr(){
        PatientRecordPage patientRecordPage= new PatientRecordPage(driver);
        return patientRecordPage.getPatientAddress();
    }
}
