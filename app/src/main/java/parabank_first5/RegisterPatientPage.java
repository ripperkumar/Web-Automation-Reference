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

    public void fillPatientDemographics() {
        givenName.sendKeys("Priyanshu");
        familyName.sendKeys("kumar");
        nextBtn.click();
        selectOption(gender, "Male");
        nextBtn.click();

        birthdateYear.sendKeys("18");
        birthdateMonths.sendKeys("9");
        nextBtn.click();

    }

    public void fillPatientContactInfo() {
        address1.sendKeys("dlnafsklad adlknlk akjldsnl ");
        address2.sendKeys("adjkb ajdnk adlnnlda");
        cityVillage.sendKeys("bangalore");
        stateProvince.sendKeys("karnataka");
        country.sendKeys("Bharat");
        postalCode.sendKeys("560090");
        nextBtn.click();
        phoneNumber.sendKeys("8877010105");
        nextBtn.click();

    }

    public void fillRelationInfo() {
        selectOption(relationship_type, "Sibling");
        relationName.sendKeys("devanshu");
        nextBtn.click();
        submitBtn.click();


    }
}
