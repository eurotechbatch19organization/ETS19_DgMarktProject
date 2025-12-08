package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.PasswordChangePage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.dgmarkt.utilities.BrowserUtils.waitForVisibility;

public class ChangePasswordStepDefs {

    HomePage homePage = new HomePage();
    PasswordChangePage passwordChangePage = new PasswordChangePage();
    LoginPage loginPage= new LoginPage();

    @Given("the user clicks on the {string} menu")
    public void the_user_clicks_on_the_menu(String myAccount) {
        loginPage.closeNewsletterPopupIfExists();
        loginPage.clickMyAccountToSubMenu(myAccount);
    }

    @When("the user selects {string} from the submenu")
    public void the_user_selects_from_the_submenu(String menuName) {
        homePage.clickMyAccountToSubMenu(menuName);
    }

    @Then("the user confirms they are on the {string} page")
    public void the_user_confirms_they_are_on_the_page(String pageName) {

        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

        if (pageName.equals("Account")) {
            WebElement account = Driver.get().findElement(By.xpath("//a[normalize-space()='Account']"));
            wait.until(ExpectedConditions.visibilityOf(account));
            Assert.assertTrue(account.isDisplayed());
        }
    }

    @When("the user clicks on the {string} section")
    public void the_user_clicks_on_the_section(String sectionName) {
        homePage.clickSection(sectionName);
    }

    @Then("the user enters {string} into the password fields")
    public void the_user_enters_into_the_password_fields(String newPass) {
        passwordChangePage.clickNewChangePassword(newPass);
    }


    @Then("the user is redirected back to the {string} page")
    public void the_user_is_redirected_back_to_the_page(String pageName) {

        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

        if (pageName.equals("Account")) {
            WebElement account = Driver.get().findElement(By.xpath("//a[normalize-space()='Account']"));
            wait.until(ExpectedConditions.visibilityOf(account));
            Assert.assertTrue(account.isDisplayed());
        }
    }

    @Then("the user sees a confirmation message stating {string}")
    public void the_user_sees_a_confirmation_message_stating(String expectedMessage) {
        String actualMessage = Driver.get().findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Then("the user resets the password back to the original one")
    public void the_user_resets_the_password_back_to_the_original_one() {
        passwordChangePage.clickSection("Password");
        waitForVisibility(passwordChangePage.newPasswordInput, 5);
        String originalPassword = ConfigurationReader.get("newChangePassword");
        passwordChangePage.clickNewChangePassword(originalPassword);
    }

    @When("The user logs out of their account")
    public void the_user_logs_out_of_their_account() {
       homePage.logoutwithSelda();

    }

    @When("The user logs in again using the new password {string}")
    public void the_user_logs_in_again_using_the_new_password(String newPass) {
        loginPage.closeNewsletterPopupIfExists();
        BrowserUtils.waitFor(2);
        loginPage.loginWithNewPass();
    }

    @Then("The user navigates to the Password section and resets the password")
    public void the_user_navigates_to_the_password_section_and_resets_the_password() {
        homePage.clickMyAccountToSubMenu("My Account");
        homePage.clickSection("Password");
        waitForVisibility(passwordChangePage.newPasswordInput, 10);
        String originalPassword = ConfigurationReader.get("newChangePassword");
        passwordChangePage.clickNewChangePassword(originalPassword);

    }

    @When("The user enters {string} as new password and {string} as confirm password and clicks Continue")
    public void the_user_enters_as_new_password_and_as_confirm_password_and_clicks_continue(String newPassword, String confirmPassword) {
        passwordChangePage.clickNewChangePassword(newPassword, confirmPassword);

    }
    @Then("The user should see the warning message {string}")
    public void the_user_should_see_the_warning_message(String expectedWarningMessage) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordChangePage.warningMessage));
        String actualMessage = passwordChangePage.warningMessage.getText().trim();
        Assert.assertEquals(expectedWarningMessage, actualMessage);

    }

    @Then("The user should verify that the warning message is {string}")
    public void the_user_should_verify_that_the_warning_message_is(String expectedMessage) {
        String actualMessage = Driver.get()
                .findElement(By.cssSelector(".alert.alert-success"))
                .getText()
                .trim();
        Assert.assertEquals(expectedMessage,actualMessage);



    }


}











