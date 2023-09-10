package parabank_first5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageServicesTypeTest extends BaseTest {
    @Test
    public void navigateToAppointmentScheduling() {
        HomePage homePage = landingPage.login("admin", "Admin123");
        AppointmentSchedulingPage appointmentSchedulingPage = homePage.goToAppointmentScheduling();
        String pagetitle = appointmentSchedulingPage.getPageTitle();
        Assert.assertEquals(pagetitle, "Appointment Scheduling");
    }

    @Test
    public void navigateToManageServicePage() {
        HomePage homePage = landingPage.login("admin", "Admin123");
        AppointmentSchedulingPage appointmentSchedulingPage = homePage.goToAppointmentScheduling();
        ManageServiceTypePage manageServiceTypePage = appointmentSchedulingPage.goToManageServiceTypePage();
        String pageTitle = manageServiceTypePage.getPageTitle();
        Assert.assertEquals(pageTitle, "Manage Service Types", "Page title not matched");

    }

    @Test
    public void addManageServiceType() throws InterruptedException {
        HomePage homePage = landingPage.login("admin", "Admin123");
        AppointmentSchedulingPage appointmentSchedulingPage = homePage.goToAppointmentScheduling();
        ManageServiceTypePage manageServiceTypePage = appointmentSchedulingPage.goToManageServiceTypePage();
        manageServiceTypePage.addNewServicesType("PriyanshuTesting", "12", "lorem ipsum");

         }
    @Test
    public void searchManageServiceType() throws InterruptedException {
        HomePage homePage = landingPage.login("admin", "Admin123");
        AppointmentSchedulingPage appointmentSchedulingPage = homePage.goToAppointmentScheduling();
        ManageServiceTypePage manageServiceTypePage = appointmentSchedulingPage.goToManageServiceTypePage();
        String recentAddServiceName = manageServiceTypePage.getRecentAddServiceName();
        Assert.assertEquals(recentAddServiceName,"baby","actual and expected serviceName not matched");
    }

}
