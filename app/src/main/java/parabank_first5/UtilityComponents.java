package parabank_first5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilityComponents {
    WebDriver driver;
    public UtilityComponents(WebDriver driver) {
        this.driver = driver;
    }
    public void selectOption(By findBy, String selectByText) {
        WebElement selectMenu = driver.findElement(findBy);
        Select menuOption = new Select(selectMenu);
        menuOption.selectByVisibleText(selectByText);
    }
    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
}
