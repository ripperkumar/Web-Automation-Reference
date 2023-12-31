package parabank_first5;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @Test(groups = {"ErrorValidation","RunAll","Sanity"})
    public void sucessfulLogin() throws InterruptedException, IOException {
        String givenStatus = "admin";
        HomePage homePage = landingPage.login("admin", "Admin123");
        String status = homePage.getUserStatus();
        Assert.assertTrue(status.contains(givenStatus),"Wrong user status");
    }

    @Test(groups = {"ErrorValidation","RunAll"})
    public void invalidUserCredValidation() {
        landingPage.login("ad", "Admin123");
        String errormessg = landingPage.getLoginErrorMessg();
        Assert.assertTrue(errormessg.contains("Invalid username/password."), "wrong error messg");
    }

    @Test(groups = {"ErrorValidation","RunAll"})
    public void emptyUserCredValidation(){
        landingPage.login("", "");
        String errorMessg = landingPage.getLoginErrorMessg();
        Assert.assertTrue(errorMessg.contains("Invalid username/password."), "wrong error messg");
    }
}
