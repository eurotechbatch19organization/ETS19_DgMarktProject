package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.RegisterPage;
import com.dgmarkt.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterStepDefs {

    LoginPage loginPage = new LoginPage();
    RegisterPage register = new RegisterPage();
    Faker faker = new Faker();

    @Given("User is on the main login page and logs in")
    public void user_is_on_the_main_login_page_and_logs_in() {
        loginPage.setUpUI();
    }

    @Given("Navigates to My Account -> Register")
    public void navigates_to_my_account_register() {
        loginPage.myAccountLink.click();
        register.registerLink.click();      // ilgili menuye gitme method u kullanıalcak
    }

    @When("The user fills the registration form with valid data")
    public void the_user_fills_the_registration_form_with_valid_data() {

        String password = faker.internet().password(8, 12, true, true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user selects subscription as {string}")
    public void the_user_selects_subscription_as(String choice) {
        if (choice.equalsIgnoreCase("no")) {
            register.selectSubscribeNo();
        }
    }

    @When("The user agrees to Privacy Policy")
    public void the_user_agrees_to_privacy_policy() {
        register.agreePrivacyPolicy();
    }

    @When("The user clicks Continue button")
    public void the_user_clicks_continue_button() {
        register.clickContinue();
    }

    @Then("The user should see success message")
    public void the_user_should_see_success_message() throws InterruptedException {
        Assert.assertTrue("Success message is not displayed!",
                register.isSuccessMessageDisplayed());

        System.out.println("Success message is displayed successfully!");
    }

    @Then("The user clicks continue on success popup")
    public void the_user_clicks_continue_on_success_popup() {
        register.clickContinueAfterAccountCreated();
    }

    @When("The user fills the registration form without First Name")
    public void the_user_fills_the_registration_form_without_first_name() {
       String password = faker.internet().password(8, 12, true, true);

        // First Name intentionally left empty
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);

    }

    @When("The user fills the registration form without Last Name")
    public void the_user_fills_the_registration_form_without_last_name() {
        String password = faker.internet().password(8, 12, true, true);

        register.enterFirstName(faker.name().firstName());
        // Last Name intentionally left empty
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form without Email")
    public void the_user_fills_the_registration_form_without_email() {
       String password = faker.internet().password(8, 12, true, true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        // Email intentionally left empty
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form without Telephone")
    public void the_user_fills_the_registration_form_without_telephone() {
       String password = faker.internet().password(8, 12, true, true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        // Telephone intentionally left empty
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form without Password")
    public void the_user_fills_the_registration_form_without_password() {
        String password = faker.internet().password(8, 12, true, true);
        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        // Password intentionally left empty
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form without Password Confirm")
    public void the_user_fills_the_registration_form_without_password_confirm() {
     String password = faker.internet().password(8, 12, true, true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        // Password Confirm intentionally left empty
    }

    @When("The user does not agree to Privacy Policy")
    public void the_user_does_not_agree_to_privacy_policy() {
       // Intentionally do not check the privacy policy checkbox
    }

    @When("The user fills the registration form without Last Name and Email")
    public void the_user_fills_the_registration_form_without_last_name_and_email() {
         String password = faker.internet().password(8, 12, true, true);

          register.enterFirstName(faker.name().firstName());
          // Last Name intentionally left empty
          // Email intentionally left empty
          register.enterTelephone(faker.number().digits(11));
          register.enterPassword(password);
          register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form without Telephone and Password")
    public void the_user_fills_the_registration_form_without_telephone_and_password() {
        String password = faker.internet().password(8, 12, true, true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        // Telephone intentionally left empty
        // Password intentionally left empty
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form without First Name, Last Name and Telephone")
    public void the_user_fills_the_registration_form_without_first_name_last_name_and_telephone() {
        String password = faker.internet().password(8, 12, true, true);

        // First Name intentionally left empty
        // Last Name intentionally left empty
        register.enterEmail(faker.internet().emailAddress());
        // Telephone intentionally left empty
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form with invalid Email format")
    public void the_user_fills_the_registration_form_with_invalid_email_format() {
        String password = faker.internet().password(8, 12, true, true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail("invalidEmailFormat"); // Invalid email format
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form with mismatched passwords")
    public void the_user_fills_the_registration_form_with_mismatched_passwords() {
        String password = faker.internet().password(8, 12, true, true);
        String differentPassword = faker.internet().password(8,12,true,true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(differentPassword); // Mismatched password
    }

    @When("The user fills the registration form with First Name longer than thirty two characters")
    public void the_user_fills_the_registration_form_with_first_name_longer_than_thirty_two_characters() {
      String password = faker.internet().password(8,12,true,true);

        register.enterFirstName(faker.lorem().characters(33));
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form with Last Name longer than thirty two characters")
    public void the_user_fills_the_registration_form_with_last_name_longer_than_thirty_two_characters() {
        String password = faker.internet().password(8,12,true,true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.lorem().characters(33));
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(11));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form with Telephone shorter than three characters")
    public void the_user_fills_the_registration_form_with_telephone_shorter_than_three_characters() {
        String password = faker.internet().password(8,12,true,true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(2));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form with Telephone longer than thirty two characters")
    public void the_user_fills_the_registration_form_with_telephone_longer_than_thirty_two_characters() {
        String password = faker.internet().password(8,12,true,true);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterTelephone(faker.number().digits(33));
        register.enterPassword(password);
        register.enterPasswordConfirm(password);
    }

    @When("The user fills the registration form with Password shorter than four characters")
    public void the_user_fills_the_registration_form_with_password_shorter_than_four_characters() {
        String shortPassword = faker.lorem().characters(3);

        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(faker.internet().emailAddress());
        register.enterPassword(shortPassword);
        register.enterPasswordConfirm(shortPassword);
    }

    @Then("The error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage = "";

        if (expectedErrorMessage.contains("First Name")) {
            actualErrorMessage = register.getFirstNameErrorMessage();
        } else if (expectedErrorMessage.contains("Last Name")) {
            actualErrorMessage = register.getLastNameErrorMessage();
        } else if (expectedErrorMessage.contains("E-Mail")) {
            actualErrorMessage = register.getEmailErrorMessage();
        } else if (expectedErrorMessage.contains("Telephone")) {
            actualErrorMessage = register.getTelephoneErrorMessage();
        } else if (expectedErrorMessage.contains("Password must be")) {
            actualErrorMessage = register.getPasswordErrorMessage();
        } else if (expectedErrorMessage.contains("Password confirmation")) {
            actualErrorMessage = register.getPasswordConfirmErrorMessage();
        }

        Assert.assertEquals("Error message does not match!",
                expectedErrorMessage,
                actualErrorMessage);

        System.out.println("Expected error message displayed: " + actualErrorMessage);
    }

    @Then("The warning message {string} should be displayed")
    public void the_warning_message_should_be_displayed(String expectedWarningMessage) {
        String actualWarningMessage = register.getWarningMessage();

        Assert.assertTrue("Warning message does not contain expected text!",
                actualWarningMessage.contains(expectedWarningMessage));

        System.out.println("Expected warning message displayed: " + actualWarningMessage);
    }

}



