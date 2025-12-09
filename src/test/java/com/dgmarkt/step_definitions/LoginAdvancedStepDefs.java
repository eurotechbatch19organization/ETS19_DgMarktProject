package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import static com.dgmarkt.utilities.BrowserUtils.waitForVisibility;

public class LoginAdvancedStepDefs {

    private static final Logger log = LogManager.getLogger(LoginAdvancedStepDefs.class);
    LoginPage loginPage = new LoginPage();

    @When("The user clicks the Logout button and popup button")
    public void the_user_clicks_the_logout_button_and_popup_button() {
        loginPage.logout();
        loginPage.closeNewsletterPopupIfExists();
    }

    @Then("The user should see the {string} button in My Account section")
    public void the_user_should_see_the_button_in_my_account_section(String string) {
        Assert.assertTrue("Login button görünmedi!", loginPage.isLoginButtonVisible());
    }

    @When("the user enters a valid registered e-mail {string} and a wrong password {string}")
    public void the_user_enters_a_valid_registered_e_mail_and_a_wrong_password(String string, String string2) {
        loginPage.login(string, string2);
        BrowserUtils.waitForVisibility(loginPage.getNoMatchWarningTitle(), 10);
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String string) {
        loginPage.verifyErrorMessage(string);
    }

    @Then("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        loginPage.verifyLoginOrCreateAnAccountPage();
    }

    @When("the user enters an invalid e-mail {string} and enters any password {string}")
    public void the_user_enters_an_invalid_e_mail_and_enters_any_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @When("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLogin3Button();
    }

    @Then("the user should see a validation message {string}")
    public void the_user_should_see_a_validation_message(String string) {
        loginPage.verifyErrorMessage(string);
    }

    @When("the user focuses on the password field")
    public void the_user_focuses_on_the_password_field() {
        loginPage.getPasswordBox2().click();
    }

    @When("the user types any password {string}")
    public void the_user_types_any_password(String string) {
        loginPage.getPasswordBox2().sendKeys(string);
    }

    @Then("the user should see the password masked as bullet signs")
    public void the_user_should_see_the_password_masked_as_bullet_signs() {
        String typeAttr = loginPage.getPasswordBox2().getAttribute("type");
        Assert.assertEquals("password", typeAttr);
    }

    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String string) {
        loginPage.getForgotPasswordLink().click();
    }

    @When("the user enters a registered e-mail {string} in the forgotten password field")
    public void the_user_enters_a_registered_e_mail_in_the_forgotten_password_field(String string) {
        loginPage.getEmailBox2().sendKeys(string);
    }

    @When("the user clicks the Continue button")
    public void the_user_clicks_the_continue_button() {
        loginPage.getContiniue2Button().click();
    }

    @Then("the user should see a message {string}")
    public void the_user_should_see_a_message(String expectedMessage) {
        loginPage.verifyForgotPasswordAlert(expectedMessage);
    }

    @When("the user enters an unregistered e-mail {string} in the forgotten password field")
    public void the_user_enters_an_unregistered_e_mail_in_the_forgotten_password_field(String string) {
        loginPage.getEmailBox2().sendKeys(string);
    }

    @Given("the user has already tried to login {int} times with wrong password")
    public void the_user_has_already_tried_to_login_times_with_wrong_password(Integer int1) {
        loginPage.tryToLoginWithWrongPassManyTimes(int1);
    }

    @When("the user enters a valid registered e-mail {string} and enters a wrong password {string}")
    public void the_user_enters_a_valid_registered_e_mail_and_enters_a_wrong_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @Then("the user should see a lockout message {string}")
    public void the_user_should_see_a_lockout_message(String string) {
        loginPage.verifyForgotPasswordAlert(string);

    }

    @Then("the user should not be logged in")
    public void the_user_should_not_be_logged_in() {
        loginPage.getCloseButtonLoginPage().click();
        loginPage.isLoginButtonVisible();
    }

}
