package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRecordPage extends UtilityComponents {
    public PatientRecordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".float-sm-right > span")
    WebElement patientId;
    @FindBy(css = ".PersonName-givenName")
    WebElement patientFirstName;
    @FindBy(css = ".gender-age > span:first-child")
    WebElement patientGender;
    @FindBy(id = "patient-header-contactInfo")
    WebElement contactInfobtn;
  @FindBy(css = ".contact-info-inline.labeled > span:first-child")
    WebElement patientAddress;

    public String getPatientId() {
        return patientId.getText();
    }

    public String getPatientFirstName() {
        return patientFirstName.getText();
    }

    public String getPatientGender() {
        return patientGender.getText();
    }

    public void showPatientContactInfo() {
        contactInfobtn.click();
    }

    public String getPatientAddress() {
        showPatientContactInfo();
        return patientAddress.getText();

    }
}
