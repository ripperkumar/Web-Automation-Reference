package parabank_first5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePrivilegesPages extends UtilityComponents{
    public ManagePrivilegesPages(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='Add New Privilege']")
    WebElement addNewPrivilegebtn;
    @FindBy(id = "privilege-field")
    WebElement privilegeName;
    @FindBy(id = "description-field")
    WebElement privilegeDesc;
    @FindBy(id = "save-button")
    WebElement saveBtn;


    public void addNewPrivilege(String pName,String pDesc){
        addNewPrivilegebtn.click();
        privilegeName.clear();
        privilegeName.sendKeys(pName);
        privilegeDesc.sendKeys(pDesc);
        saveBtn.click();
    }

}
