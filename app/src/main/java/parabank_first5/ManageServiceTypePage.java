package parabank_first5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageServiceTypePage extends UtilityComponents {
    public ManageServiceTypePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".confirm.appointment-type-label")
    WebElement newServiceTypeBtn;
    @FindBy(id = "name-field")
    WebElement serviceName;
    @FindBy(id = "duration-field")
    WebElement serviceDuration;
    @FindBy(id = "description-field")
    WebElement serviceDesc;
    @FindBy(id = "save-button")
    WebElement saveBtn;

    public void addNewServicesType(String sName,String sDuration, String sDesc) {
        newServiceTypeBtn.click();
        serviceName.clear();
        serviceName.sendKeys("PriyanshuTesting");
        serviceDuration.sendKeys("1111");
        serviceDesc.sendKeys("loremIpsum loremIpsum");
        saveBtn.click();
    }
}
