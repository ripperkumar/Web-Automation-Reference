package parabank_first5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManagePrivilegesPages extends UtilityComponents {
    public ManagePrivilegesPages(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#content>h3")
    WebElement pageTitle;
    @FindBy(xpath = "//input[@value='Add New Privilege']")
    WebElement addNewPrivilegebtn;
    @FindBy(id = "privilege-field")
    WebElement privilegeName;
    @FindBy(id = "description-field")
    WebElement privilegeDesc;
    @FindBy(id = "save-button")
    WebElement saveBtn;

    @FindBy(css = ".toast-type-success > p")
    WebElement savedPrivtoastMessg;
    @FindBy(css = "#list-privileges_filter > label > input")
    WebElement searchBar;

    @FindBy(css = "tbody[role='alert']>tr")
    List<WebElement> privileges;

    By privilegeBy = By.cssSelector("tbody[role='alert']>tr");
    By saveToastPrivMessg = By.cssSelector(".toast-type-success > p");

    public void addNewPrivilege(String pName, String pDesc) {
        addNewPrivilegebtn.click();
        privilegeName.clear();
        privilegeName.sendKeys(pName);
        privilegeDesc.sendKeys(pDesc);
        saveBtn.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getSavePrivToastaMessg() {
        waitForElementToAppear(saveToastPrivMessg);
        return savedPrivtoastMessg.getText();
    }


    public List<WebElement> getPatientsRecord() {
        waitForElementToAppear(privilegeBy);
        return privileges;
    }


    public String searchPrivilege(String priv) {
    searchBar.sendKeys(priv);
        WebElement privilege = getPatientsRecord().stream().filter(patients ->
                patients.findElement(By.cssSelector("td:nth-child(1)")).getText().contains(priv)).findFirst().orElse(null);
        return privilege!=null?privilege.getText():"No entries to display";

    }
}
