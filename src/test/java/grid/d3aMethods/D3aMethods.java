package grid.d3aMethods;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D3aMethods extends PageObject {
    LoginURL login;

    static String ProjectName = "Smita123";
    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//form[@class='form']/div[3]/button")
    WebElement loginButton;

    @FindBy(xpath = "//h1[text()='Home']")
    WebElement loginTitle;

    @FindBy(xpath = "//div[@class='side-nav__main__wrapper']/div[2]/div[1]/div[1]/button")
    WebElement projectButton;

    @FindBy(xpath = "//span[text()='new project']")
    WebElement createNewProject;

    @FindBy(name = "name")
    WebElement nameProject;

    @FindBy(xpath = "//div[@class='library-name-modal__container']/button")
    WebElement addButton;

    public static WebElement createdProject(String projectName, WebDriver driver) {
        return driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", projectName)));
    }

    public void getURL() {
        login.open();
    }

    public void loginCred() {
        email.sendKeys("smita.sinha0802@gmail.com");
        password.sendKeys("Shopping@123");
        loginButton.click();
    }

    public void verifyLoginSuccessful() {
        loginTitle.isDisplayed();
    }

    public void clickOnProject() {
        projectButton.click();

    }

    public void enterInformationAndAddNewProject() {
        createNewProject.click();
        nameProject.sendKeys(ProjectName);
        addButton.click();
    }

    public void verifyCreatedProject(WebDriver driver) {
        createdProject(ProjectName, driver).isDisplayed();
    }

    public D3aMethods(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
