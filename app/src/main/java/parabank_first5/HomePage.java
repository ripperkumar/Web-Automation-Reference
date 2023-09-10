package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends UtilityComponents {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Register a patient")
    WebElement registerPatient;

    @FindBy(partialLinkText = "Find Patient Record")
    WebElement findPatientRecord;
    @FindBy(partialLinkText = "Configure Metadata")
    WebElement configureMetaData;
    @FindBy(partialLinkText = "Appointment Scheduling")
    WebElement appointmentScheduling;

    public RegisterPatientPage goToRegisterPatient() {
        registerPatient.click();
        return new RegisterPatientPage(driver);
    }

    public FindPatientRecord goToFindPatientRecord() {
        findPatientRecord.click();
        return new FindPatientRecord(driver);
    }


    public ConfigureMetaDataPage goToConfigureMetadata() {
        configureMetaData.click();
        return new ConfigureMetaDataPage(driver);
    }

    public AppointmentSchedulingPage goToAppointmentScheduling() {
        appointmentScheduling.click();
        return new AppointmentSchedulingPage(driver);
    }
}
