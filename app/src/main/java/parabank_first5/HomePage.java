package parabank_first5;

import io.opentelemetry.api.internal.Utils;
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

    public RegisterPatientPage goToRegisterPatient() {
        registerPatient.click();
        RegisterPatientPage registerPatientPage = new RegisterPatientPage(driver);
        return registerPatientPage;
    }

}
