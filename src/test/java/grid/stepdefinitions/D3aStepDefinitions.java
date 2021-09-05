package grid.stepdefinitions;

import grid.d3aMethods.D3aMethods;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Builder;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class D3aStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    D3aMethods d3aLocators;

    @Before
    public void defaultWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("open the d3a page")
    public void openURl() {
        d3aLocators.getURL();
    }

    @When("enter the valid credential")
    public void enterTheValidCredential() {
        d3aLocators.loginCred();
    }

    @Then("verify if user is able to login")
    public void verifyIfUserIsAbleToLogin() {
        d3aLocators.verifyLoginSuccessful();
    }

    @Given("login with correct credential")
    public void loginWithCorrectCredential() {
        d3aLocators.getURL();
        d3aLocators.loginCred();
    }

    @When("enter all information")
    public void enterAllInformation() {
        d3aLocators.clickOnProject();
        d3aLocators.enterInformationAndAddNewProject();
    }

    @Then("verify project created")
    public void verifyProjectCreated() {
        d3aLocators.verifyCreatedProject(driver);
    }

    @When("click on project")
    public void clickOnProject() {
        d3aLocators.clickOnProject();
    }

    @Then("verify created project is available")
    public void verifyCreatedProjectIsAvailable() {
        d3aLocators.verifyCreatedProject(driver);
    }
}
