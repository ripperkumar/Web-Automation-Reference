package parabank_first5;

import org.openqa.selenium.By;
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

    @Test
    public void TestFindPatient() {
        // 1. Arrange
        HomePage homePage = landingPage.login("admin", "Admin123");
        FindPatientRecord findPatientRecord = homePage.goToFindPatientRecord();
        findPatientRecord.searchAndClickOnPatientRecord("name", "Gaurav");

        // 2.Act

        // 3.Assert
    }

    @Test
    public void TestManagePrivilege() throws InterruptedException {
        // 1. Arrange
        HomePage homePage = landingPage.login("admin", "Admin123");
        homePage.goToConfigureMetadata();
        driver.findElement(By.partialLinkText("Manage Privileges")).click();
        driver.findElement(By.xpath("//input[@value='Add New Privilege']")).click();
        driver.findElement(By.id("privilege-field")).clear();
        driver.findElement(By.id("privilege-field")).sendKeys("add Priyanshu");
        driver.findElement(By.id("description-field")).sendKeys("lorem Ipsem sdbak hbaskb ackboascb cajkboacbkc jkabdcl jkad");
        driver.findElement(By.id("save-button")).click();
        // 2.Act

        // 3.Assert
    }

    @Test
    public void TestManageServiceType() throws InterruptedException {
        // 1. Arrange
        HomePage homePage = landingPage.login("admin", "Admin123");
        homePage.goToAppointmentScheduling();
        driver.findElement(By.partialLinkText("Manage Service Types")).click();
        driver.findElement(By.cssSelector(".confirm.appointment-type-label")).click();
        driver.findElement(By.id("name-field")).clear();
        driver.findElement(By.id("name-field")).sendKeys("PriyanshuTesting");
        driver.findElement(By.id("duration-field")).sendKeys("1111");
        driver.findElement(By.id("description-field")).sendKeys("loremIpsum loremIpsum");
        driver.findElement(By.id("save-button")).click();
        Thread.sleep(4000);


        // 2.Act

        // 3.Assert
    }

}
