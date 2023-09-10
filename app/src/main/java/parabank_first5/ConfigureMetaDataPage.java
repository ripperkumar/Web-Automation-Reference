package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigureMetaDataPage extends UtilityComponents {
    WebDriver driver;

    public ConfigureMetaDataPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(partialLinkText = "Manage Privileges")
    WebElement managePrivileges;

    public ManagePrivilegesPages goToManagePrivilegesPage() {
        managePrivileges.click();
        return new ManagePrivilegesPages(driver);
    }
}
