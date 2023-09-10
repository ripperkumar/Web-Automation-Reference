package parabank_first5;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManagePrivilageTest extends BaseTest{

    @Test
    public void navigateToConfigureMetaDataPage() {
        HomePage homePage = landingPage.login("admin", "Admin123");
        ConfigureMetaDataPage configureMetaData = homePage.goToConfigureMetadata();
        String pageTitle = configureMetaData.getPageTitle();
        Assert.assertEquals(pageTitle,"Configure Metadata","Wrong page Title");
    }

    @Test
    public void navigateToManagePrivilagePage(){
        String expectedPageTitle= "Manage Privileges";
        HomePage homePage = landingPage.login("admin", "Admin123");
        ConfigureMetaDataPage configureMetaData = homePage.goToConfigureMetadata();
        ManagePrivilegesPages managePrivilegesPages = configureMetaData.goToManagePrivilegesPage();
        String pageTitle = managePrivilegesPages.getPageTitle();
        Assert.assertEquals(pageTitle,expectedPageTitle,"wrong page Title");
    }
    @Test
    public void AddPrivilege() throws InterruptedException {
        String expectedToastMessg="Saved privilege";
        HomePage homePage = landingPage.login("admin", "Admin123");
        ConfigureMetaDataPage configureMetaData = homePage.goToConfigureMetadata();
        ManagePrivilegesPages managePrivilegesPages = configureMetaData.goToManagePrivilegesPage();
        managePrivilegesPages.addNewPrivilege("priyanshu", "ahcbvic ashcosbi acibcsabo cas oacb bcsaocbca coc oah");
        String toastMessg = managePrivilegesPages.getSavePrivToastaMessg();
        Assert.assertEquals(toastMessg,expectedToastMessg,"privilege not saved");
    }
    @Test
    public void SearchPrivilege(){
        String expectedPrivilege="priyanshu";
        String privToBeSearch = "pri";
        HomePage homePage = landingPage.login("admin", "Admin123");
        ConfigureMetaDataPage configureMetaData = homePage.goToConfigureMetadata();
        ManagePrivilegesPages managePrivilegesPages = configureMetaData.goToManagePrivilegesPage();
        String privilege = managePrivilegesPages.searchPrivilege(privToBeSearch);
        Assert.assertTrue(privilege.contains(expectedPrivilege),"privilege not matched");
    }
    @Test
    public void SearchPrivilegeNotFound() {
        String expectedPrivilege="No entries to display";
        String privToBeSearch = "lorem Ipsum";
        HomePage homePage = landingPage.login("admin", "Admin123");
        ConfigureMetaDataPage configureMetaData = homePage.goToConfigureMetadata();
        ManagePrivilegesPages managePrivilegesPages = configureMetaData.goToManagePrivilegesPage();
        String privilege = managePrivilegesPages.searchPrivilege(privToBeSearch);
        Assert.assertTrue(privilege.contains(expectedPrivilege),"privilege not matched");
    }
}
