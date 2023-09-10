package parabank_first5;

import org.testng.annotations.Test;

public class ManagePrivilageTest extends BaseTest{
    @Test
    public void TestManagePrivilege() throws InterruptedException {
        HomePage homePage = landingPage.login("admin", "Admin123");
        ConfigureMetaDataPage configureMetaData = homePage.goToConfigureMetadata();
        ManagePrivilegesPages managePrivilegesPages = configureMetaData.goToManagePrivilegesPage();
        managePrivilegesPages.addNewPrivilege("priyanshu", "ahcbvic ashcosbi acibcsabo cas oacb bcsaocbca coc oah");

    }

}
