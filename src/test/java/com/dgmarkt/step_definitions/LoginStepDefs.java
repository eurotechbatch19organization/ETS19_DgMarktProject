package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("User is on the main login page")
    public void user_is_on_the_main_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters valid email and password and clicks the Login button")
    public void the_user_enters_valid_email_and_password_and_clicks_the_login_button() {
        loginPage.login();
    }
    @When("Closes the newsletter popup if it appears")
    public void closes_the_newsletter_popup_if_it_appears() {

    }
    @Then("The user should see the main page")
    public void the_user_should_see_the_main_page() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForVisibility(loginPage.myAccountLink, 10);

        Assert.assertTrue("My Account link is not displayed!",
                loginPage.myAccountLink.isDisplayed());
    }

}
