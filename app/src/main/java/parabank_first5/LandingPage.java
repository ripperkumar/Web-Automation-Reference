package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends UtilityComponents{
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "Isolation Ward")
    WebElement location;
    @FindBy(id = "loginButton")
    WebElement login;

    public HomePage login(String LogInUsername, String LogInpassword) {
        userName.sendKeys(LogInUsername);
        password.sendKeys(LogInpassword);
        location.click();
        login.click();
        HomePage homePage = new HomePage(driver);
        return homePage;
    }

    public void goTo() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }


}
