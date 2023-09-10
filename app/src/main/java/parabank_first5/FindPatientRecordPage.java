package parabank_first5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindPatientRecordPage extends UtilityComponents {

    WebDriver driver;

    public FindPatientRecordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "patient-search")
    WebElement searchBar;
   @FindBy(tagName = "h2")
    WebElement pageHeader;

    @FindBy(css = "tbody[role='alert']>tr")
    List<WebElement> patientsRecord;

    By patientBy = By.cssSelector("tbody[role='alert']>tr");



    public List<WebElement> getPatientsRecord() {
        waitForElementToAppear(patientBy);
        return patientsRecord;
    }

    public int getNoOfPatientFound(String idOrName, String patientNameOrId) {
        int noOfPatient = 0;
        if (idOrName.equalsIgnoreCase("name")) {
            searchBar.sendKeys(patientNameOrId);
            noOfPatient =  getPatientsRecord().size();

        } else {
            searchBar.sendKeys(patientNameOrId);
            searchBar.sendKeys(Keys.ENTER);
            noOfPatient =  getPatientsRecord().size();
        }
        return noOfPatient;
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
                patients.findElement(By.cssSelector("td:nth-child(1)")).getText().contains(patientId)).findFirst().orElse(null);
        return patient;

    }

    public PatientRecordPage searchAndClickOnPatientRecord(String idOrName, String patientNameOrId) {
        WebElement patient;
        if (idOrName.equalsIgnoreCase("name")) {
            patient = getPatientRecordByName(patientNameOrId);
        } else {
            patient = getPatientRecordById(patientNameOrId);
        }
        patient.click();
        return new PatientRecordPage(driver);
    }

    public String  getPageHeader(){
        return pageHeader.getText();
    }
}
