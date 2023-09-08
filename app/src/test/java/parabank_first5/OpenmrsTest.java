package parabank_first5;

import org.testng.annotations.Test;

import java.io.IOException;

public class OpenmrsTest extends BaseTest {


    @Test
    public void TestRegisterPatient() throws InterruptedException, IOException {

        HomePage homePage = landingPage.login("admin", "Admin123");

        RegisterPatientPage registerPatientPage = homePage.goToRegisterPatient();
        registerPatientPage.fillPatientDemographics();
        registerPatientPage.fillPatientContactInfo();
        registerPatientPage.fillRelationInfo();
        Thread.sleep(4000);
    }


}
