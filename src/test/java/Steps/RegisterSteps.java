package Steps;

import Locators.*;
import Utils.RegisterInputs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

public class RegisterSteps extends BaseClass implements Locators {
    @And("New User Signup with the following credentials")
    public void newUserSignupWithTheFollowingCredentials(DataTable table) {
        Map<String, String> info = table.asMap();
        of(lSingUpName).scrollToElement().sentKeys(RandomStringUtils.randomAlphabetic(3) + info.get("name"))
        .of(lSingUpEMail).scrollToElement().sentKeys(RandomStringUtils.randomAlphabetic(3) + info.get("email"))
        .of(lSingUpButton).scrollToElement().click();
        System.setProperty("name", info.get("name"));
        System.setProperty("email", info.get("email"));


    }

    @Then("Signup should be successfull")
    public void signupShouldBeSuccessfull() {
        wait.until(ExpectedConditions.urlContains("signup"));
    }

    @When("the user enters their details")
    public void theUserEntersTheirDetails(DataTable table) {
        Map<String, String> userDetails = table.asMap();

        String firstName = userDetails.get("First name");
        String lastName = userDetails.get("Last name");
        String company = userDetails.get("Company");
        String address = userDetails.get("Address");
        String address2 = userDetails.get("Address2");
        String country = userDetails.get("Country");
        String state = userDetails.get("State");
        String city = userDetails.get("City");
        String zipcode = userDetails.get("Zipcode");
        String mobile = userDetails.get("Mobile Number");
        String password = userDetails.get("Password");

        of(Locators.xpath(gender, "Mr")).scrollToElement().click();
        of(Locators.xpath(singupInput, RegisterInputs.Password.toString())).scrollToElement().sentKeys(password);
        of(Locators.xpath(singupInput, "first_name")).scrollToElement().sentKeys(firstName);
        of(Locators.xpath(singupInput, "last_name")).scrollToElement().sentKeys(lastName);
        of(Locators.xpath(singupInput, "company")).scrollToElement().sentKeys(company);
        of(Locators.xpath(singupInput, "address1")).scrollToElement().sentKeys(address);
        of(Locators.xpath(singupInput, "address2")).scrollToElement().sentKeys(address2);
        select(country, Locators.xpath(singupSelect, "country"));
        of(Locators.xpath(singupInput, "state")).scrollToElement().sentKeys(state);
        of(Locators.xpath(singupInput, "city")).scrollToElement().sentKeys(city);
        of(Locators.xpath(singupInput, "zipcode")).scrollToElement().sentKeys(zipcode);
        of(Locators.xpath(singupInput, "mobile_number")).scrollToElement().sentKeys(mobile);
        of(singupSubmitButton).click();
    }

    private void select(String country, By locator) {
        of(locator).click();
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(country);
    }


}
