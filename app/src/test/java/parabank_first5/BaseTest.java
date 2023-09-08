package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initialiseDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream propertyfile = new FileInputStream("/Users/testvagrant/Desktop/parabank_first5/app/src/main/resources/GlobalData.properties");
        properties.load(propertyfile);
        String broswerName = properties.getProperty("browser");
        if (broswerName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (broswerName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        driver = initialiseDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }
}
