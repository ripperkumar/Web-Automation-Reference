package parabank_first5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindPatientRecord extends UtilityComponents {

    WebDriver driver;

    public FindPatientRecord(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "patient-search")
    WebElement searchBar;

    @FindBy(css = "tbody[role='alert']>tr")
    List<WebElement> patientsRecord;

    By patientBy = By.cssSelector("tbody[role='alert']>tr");


    public List<WebElement> getPatientsRecord() {
        waitForElementToAppear(patientBy);
        return patientsRecord;
    }

    public WebElement getPatientRecordByName(String patientName) {
        searchBar.sendKeys(patientName);
        WebElement patient = getPatientsRecord().stream().filter(patients ->
                patients.findElement(By.cssSelector("td:nth-child(2)")).getText().contains(patientName)).findFirst().orElse(null);
        return patient;

    }

    public WebElement getPatientRecordById(String patientId) {
        searchBar.sendKeys(patientId);
        WebElement patient = getPatientsRecord().stream().filter(patients ->
                patients.findElement(By.cssSelector("td:nth-child(1)")).getText().equals(patientId)).findFirst().orElse(null);
        return patient;

    }

    public void searchAndClickOnPatientRecord(String idOrName, String patientNameOrId) {
        WebElement patient;
        if (idOrName.equalsIgnoreCase("name")) {
            patient = getPatientRecordByName(patientNameOrId);
        } else {
            patient = getPatientRecordById(patientNameOrId);
        }
        patient.click();
    }
}
