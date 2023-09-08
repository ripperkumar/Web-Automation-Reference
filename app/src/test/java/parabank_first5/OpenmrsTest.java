package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class OpenmrsTest extends BaseTest{


    @Test
    public void TestRegisterPatient() throws InterruptedException, IOException {

        LandingPage landingPage = launchApplication();
        HomePage homePage = landingPage.login("admin", "Admin123");

        RegisterPatientPage registerPatientPage = homePage.goToRegisterPatient();
        registerPatientPage.fillPatientDemographics();
        registerPatientPage.fillPatientContactInfo();
        registerPatientPage.fillRelationInfo();
        Thread.sleep(4000);
        driver.close();
    }


}
