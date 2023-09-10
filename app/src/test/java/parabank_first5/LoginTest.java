package parabank_first5;

import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest{
    @Test
    public void TestRegisterPatient() throws InterruptedException, IOException {

        HomePage homePage = landingPage.login("admin", "Admin123");
    }
}
