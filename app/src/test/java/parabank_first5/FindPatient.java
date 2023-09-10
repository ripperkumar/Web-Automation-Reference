package parabank_first5;

import org.testng.annotations.Test;

public class FindPatient extends BaseTest{
    @Test
    public void TestFindPatient() {
        // 1. Arrange
        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecord findPatientRecord = homePage.goToFindPatientRecord();
        findPatientRecord.searchAndClickOnPatientRecord("name", "Gaurav");
    }
}
