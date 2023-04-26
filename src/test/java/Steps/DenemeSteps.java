package Steps;

import Locators.Locators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class DenemeSteps extends BaseClass implements Locators {
    @Given("user on {string}")
    public void userOn(String url) {
        url="https://automationexercise.com/";
        open(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSignupButton));
    }

    @When("user click Login-Sign button")
    public void userClickLoginSignButton() {
        of(lSignupButton).click();
        wait.until(ExpectedConditions.urlContains("login"));

    }

    @And("user login with the following credentials")
    public void userLoginWithTheFollowingCredentials(DataTable table) {
        Map<String, String> info = table.asMap();
        of(lInputEmail).sentKeys(info.get("username"));
        of(lInputPassword).sentKeys(info.get("password")).
        of(lSubmitButton).click();


    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLogoutButton));
    }
}
