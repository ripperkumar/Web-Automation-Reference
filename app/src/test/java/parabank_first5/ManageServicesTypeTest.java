package parabank_first5;

import org.testng.annotations.Test;

public class ManageServicesTypeTest extends BaseTest {
    @Test
    public void TestManageServiceType() throws InterruptedException {
        HomePage homePage = landingPage.login("admin", "Admin123");
        AppointmentSchedulingPage appointmentSchedulingPage = homePage.goToAppointmentScheduling();
        ManageServiceTypePage manageServiceTypePage = appointmentSchedulingPage.goToManageServiceTypePage();
        manageServiceTypePage.addNewServicesType("PriyanshuTesting","12","lorem ipsum");
    }

}
