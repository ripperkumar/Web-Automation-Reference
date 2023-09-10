package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentSchedulingPage extends UtilityComponents{
    public AppointmentSchedulingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(partialLinkText = "Manage Service Types")
    WebElement manageServiceTypes;

    public ManageServiceTypePage goToManageServiceTypePage() {
        manageServiceTypes.click();
        return new ManageServiceTypePage(driver);
    }
}
