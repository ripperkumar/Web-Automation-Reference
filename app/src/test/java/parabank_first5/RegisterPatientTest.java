package parabank_first5;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterPatientTest extends BaseTest{

    @Test
    public void navigateToRegisterPatientPage(){
        String expectedPageTitle = "Register a patient";
        HomePage homePage = landingPage.login("admin", "Admin123");
        RegisterPatientPage registerPatientPage = homePage.goToRegisterPatient();
        String pageTitle = registerPatientPage.getPageTitle();
        Assert.assertEquals(pageTitle,expectedPageTitle, "PageTitle do not match");
    }

    @Test
    public void testRegisterPatient() throws InterruptedException, IOException {
        HomePage homePage = landingPage.login("admin", "Admin123");
        String givenName = "Priyanshu", familyName = "kumar", gender = "Male", birthYear = "23", birthMon = "9";
        String addr1 = "dlnafsklad adlknlk akjldsnl" , addr2 = "adjkb ajdnk adlnnlda",city = "banglore",state = "karnataka";
        String country="Bharat",postalCode ="560090",phoneNumber = "8877010105";
        String relationType = "Sibling",relationName ="devanshu";
        RegisterPatientPage registerPatientPage = homePage.goToRegisterPatient();
        registerPatientPage.fillPatientDemographics(givenName,familyName,gender,birthYear,birthMon);
        registerPatientPage.fillPatientContactInfo(addr1,addr2,city,state,country,postalCode,phoneNumber);
        registerPatientPage.fillRelationInfo(relationType,relationName);
        String patientFirstName = registerPatientPage.getPatientFirstName();
        String patientGender = registerPatientPage.getRegisterPatientGender();
        String patientAddress = registerPatientPage.getRegisterPatientAddr();

        Assert.assertTrue(givenName.contains(patientFirstName));
        Assert.assertTrue(patientGender.contains(gender));
        Assert.assertTrue(patientAddress.contains(addr1));

        Thread.sleep(4000);
    }
}
