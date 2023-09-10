package parabank_first5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(css = ".confirm.right")
    WebElement saveBtn;

    @FindBy(css = "#manageAppointmentsTypeTitle>h1")
    WebElement pageTitle;
    @FindBy(css = "tbody[role='alert']>tr:first-child>td:first-child")
    WebElement recentAddServiceName;

    @FindBy(css = "tbody[role='alert']>tr")
    List<WebElement> servicesName;

    By pageTitleBy = By.cssSelector("#manageAppointmentsTypeTitle>h1");
    By recentAddSerNameBy = By.cssSelector("tbody[role='alert']>tr:first-child>td:first-child");
    By serviceNameBy = By.cssSelector("tbody[role='alert']>tr>td:first-child");

    public String getRecentAddServiceName() {
        waitForElementToAppear(recentAddSerNameBy);
        return recentAddServiceName.getText();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void addNewServicesType(String sName, String sDuration, String sDesc) {
        newServiceTypeBtn.click();
        serviceName.clear();
        serviceName.sendKeys("PriyanshuTesting");
        serviceDuration.sendKeys("1111");
        serviceDesc.sendKeys("loremIpsum loremIpsum");
        saveBtn.click();
    }


    public String searchServiceType(String sname) {
        WebElement serName = null;
        WebElement nextBtn = driver.findElement(By.id("appointmentTypesTable_next"));
        do{
            serName = servicesName.stream().filter(service ->
                    service.findElement(By.cssSelector("td:first-child")).getText().contains(sname)).findFirst().orElse(null);
            nextBtn.click();
        }
        while (serName != null);
        return serName.getText();
    }
}
