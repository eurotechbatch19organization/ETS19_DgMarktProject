package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.dgmarkt.utilities.BrowserUtils.waitForVisibility;

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

    @Then("The user should see the main page")
    public void the_user_should_see_the_main_page() {
        waitForVisibility(loginPage.myAccountLink, 10);
        Assert.assertTrue("My Account link is not displayed!",
                loginPage.myAccountLink.isDisplayed());
    }

    @Then("The user clicks on the My Account button")
    public void the_user_clicks_on_the_my_account_button()  {
        loginPage.myAccountLink.click();

    }

    @Then("The user clicks on the Login2 button")
    public void the_user_clicks_on_the_login2_button()  {
        loginPage.login2();

    }

    @Then("The user should see the Login or create an account page")
    public void the_user_should_see_the_login_or_create_an_account_page()  {
        loginPage.verifyLoginPageTitle();

    }

    @When("The user enters E-Mail Address and Password and clicks the Login button")
    public void the_user_enters_e_mail_address_and_password_and_clicks_the_login_button() {
        loginPage.login3();

    }

    @Then("The user verifies Login Successful message is displayed")
    public void the_user_verifies_login_successful_message_is_displayed() {
            loginPage.verifyLoginSuccess();

    }

    @Then("The user Login with credentials")
    public void the_user_login_with_credentials() {
      loginPage.loginWithSelda();
    }




}
