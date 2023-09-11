package parabank_first5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindPatientTest extends BaseTest {

    @Test(groups = {"ErrorValidation","RunAll","Sanity"})
    public void navigateToFindPatientRecord() {
        String expectedPageHeader = "Find Patient Record";
        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecordPage findPatientRecord = homePage.goToFindPatientRecord();
        String pageHeader = findPatientRecord.getPageHeader();
        Assert.assertEquals(pageHeader, expectedPageHeader);
    }

    @Test(groups = {"RunAll","Sanity"})
    public void findPatientByName() {
        String expectedPatientId = "100JH8";
        String patientName = "Test hars";
        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecordPage findPatientRecord = homePage.goToFindPatientRecord();
        PatientRecordPage patientRecordPage = findPatientRecord.searchAndClickOnPatientRecord("name", patientName);
        String patientId = patientRecordPage.getPatientId();
        Assert.assertEquals(patientId, expectedPatientId, "wrong patient found");
    }

    @Test(groups = {"RunAll","Sanity"})
    public void findPatientById() {
        String patientId = "100JH8";
        String expectedPatientName = "Test";
        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecordPage findPatientRecord = homePage.goToFindPatientRecord();
        PatientRecordPage patientRecordPage = findPatientRecord.searchAndClickOnPatientRecord("id", patientId);
        String PatientName = patientRecordPage.getPatientFirstName();
        Assert.assertTrue(PatientName.contains(expectedPatientName), "wrong patient found");
    }

    @Test(groups = {"RunAll","Sanity"})
    public void recordsFoundBYId() {
        String patientId = "100HVL";
        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecordPage findPatientRecord = homePage.goToFindPatientRecord();
        int noOfPatientFound = findPatientRecord.getNoOfPatientFound("id", patientId);
        Assert.assertEquals(noOfPatientFound, 1, "More than one patient for same ID");
    }

    @Test(groups = {"ErrorValidation","RunAll"})
    public void recordsFoundBYName() {
        String patientName = "Gaurav Kumar Jaiswal";
        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecordPage findPatientRecord = homePage.goToFindPatientRecord();
        int noOfPatientFound = findPatientRecord.getNoOfPatientFound("name", patientName);
        Assert.assertEquals(noOfPatientFound, 15, "More than one patient for same ID");
    }

    @Test(groups = {"RunAll","Sanity"})
    public void checkPatientRecordDetail() {
        String patientId = "100JH8";
        String expectedPatientGender = "Male";
        String expectedPatientName = "Test";
        String expectedPatientAddress = "abc";

        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecordPage findPatientRecord = homePage.goToFindPatientRecord();
        PatientRecordPage patientRecordPage = findPatientRecord.searchAndClickOnPatientRecord("id", patientId);
        String patientName = patientRecordPage.getPatientFirstName();
        String patientGender = patientRecordPage.getPatientGender();
        String patientAddress = patientRecordPage.getPatientAddress();

        Assert.assertEquals(patientName, expectedPatientName, "expected and actual patient name not matched");
        Assert.assertTrue(patientGender.contains(expectedPatientGender), "expected and actual patient gender not matched");
        Assert.assertTrue(patientAddress.contains(expectedPatientAddress), "expected and actual patient address not matched");


    }


}
