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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.dgmarkt.utilities.BrowserUtils.waitForVisibility;

public class LoginStepDefs {
    private static final Logger log = LogManager.getLogger(LoginStepDefs.class);
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
        waitForVisibility(loginPage.myAccountLink, 10);
        Assert.assertTrue("My Account link is not displayed!",
                loginPage.myAccountLink.isDisplayed());
    }

    @Then("The user clicks on the My Account button")
    public void the_user_clicks_on_the_my_account_button() throws InterruptedException {
        try {
            WebElement popupClose = Driver.get().findElement(By.cssSelector("a.a-close-newsletter, a.a-close-newsletter-full"));
            if (popupClose.isDisplayed()) {
                BrowserUtils.clickWithJS(popupClose);
                BrowserUtils.waitFor(1);
            }
        } catch (Exception ignored) {}

        // 2. sonra My Account'a güvenli şekilde tıkla
        BrowserUtils.waitForClickablility(loginPage.myAccountLink, 5);
        loginPage.myAccountLink.click();

    }

    @Then("The user clicks on the Login2 button")
    public void the_user_clicks_on_the_login2_button() throws InterruptedException {
        loginPage.login2();

    }

    @Then("The user should see the Login or create an account page")
    public void the_user_should_see_the_login_or_create_an_account_page() throws InterruptedException {
        loginPage.verifyLoginPageTitle();

    }

    @When("The user enters E-Mail Address and Password and clicks the Login button")
    public void the_user_enters_e_mail_address_and_password_and_clicks_the_login_button() throws InterruptedException {
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
