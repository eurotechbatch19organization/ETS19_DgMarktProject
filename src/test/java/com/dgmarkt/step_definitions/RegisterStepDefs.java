package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterStepDefs {

    LoginPage loginPage;
    RegisterPage register;
    String password;

    public RegisterStepDefs() {
        loginPage = new LoginPage();
        register = new RegisterPage();
        password = register.generatePassword();
    }

    @Given("User is on the main login page and logs in")
    public void user_is_on_the_main_login_page_and_logs_in() {
        loginPage.setUpUI();
    }

    @Given("Navigates to My Account -> Register")
    public void navigates_to_my_account_register() {
        loginPage.myAccountLink.click();
        register.navigateToMyAccountSubmenu("Register");
    }

    @When("The user fills the registration form with valid data")
    public void the_user_fills_the_registration_form_with_valid_data() {
        register.fillRegistrationFormWithValidData();

    }

    @When("The user selects subscription as {string}")
    public void the_user_selects_subscription_as(String choice) {
        if (choice.equalsIgnoreCase("no")) {
            register.selectSubscribeNo();
        } else {
            register.selectSubscribeYes();
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
        register.fillRegistrationForm(
                null,
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                password,
                password
        );
    }

    @When("The user fills the registration form without Last Name")
    public void the_user_fills_the_registration_form_without_last_name() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                null,
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                password,
                password
        );
    }

    @When("The user fills the registration form without Email")
    public void the_user_fills_the_registration_form_without_email() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                null,
                register.faker.number().digits(11),
                password,
                password
        );
    }

    @When("The user fills the registration form without Telephone")
    public void the_user_fills_the_registration_form_without_telephone() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                null,
                password,
                password
        );
    }

    @When("The user fills the registration form without Password")
    public void the_user_fills_the_registration_form_without_password() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                null,
                password
        );
    }

    @When("The user fills the registration form without Password Confirm")
    public void the_user_fills_the_registration_form_without_password_confirm() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                password,
                null
        );
    }

    @When("The user does not agree to Privacy Policy")
    public void the_user_does_not_agree_to_privacy_policy() {
       // Intentionally do not check the privacy policy checkbox
    }

    @When("The user fills the registration form without Last Name and Email")
    public void the_user_fills_the_registration_form_without_last_name_and_email() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                null,
                null,
                register.faker.number().digits(11),
                password,
                password
        );
    }

    @When("The user fills the registration form without Telephone and Password")
    public void the_user_fills_the_registration_form_without_telephone_and_password() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                null,
                null,
                password
        );
    }

    @When("The user fills the registration form without First Name, Last Name and Telephone")
    public void the_user_fills_the_registration_form_without_first_name_last_name_and_telephone() {
        register.fillRegistrationForm(
                null,
                null,
                register.faker.internet().emailAddress(),
                null,
                password,
                password
        );
    }

    @When("The user fills the registration form with invalid Email format")
    public void the_user_fills_the_registration_form_with_invalid_email_format() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                "INVALID",
                register.faker.number().digits(11),
                password,
                password
        );
    }

    @When("The user fills the registration form with mismatched passwords")
    public void the_user_fills_the_registration_form_with_mismatched_passwords() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                "MISMATCH",
                null
        );
    }

    @When("The user fills the registration form with First Name longer than thirty two characters")
    public void the_user_fills_the_registration_form_with_first_name_longer_than_thirty_two_characters() {
        register.fillRegistrationForm(
                "LONG",
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                password,
                password
        );
    }

    @When("The user fills the registration form with Last Name longer than thirty two characters")
    public void the_user_fills_the_registration_form_with_last_name_longer_than_thirty_two_characters() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                "LONG",
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                password,
                password
        );
    }

    @When("The user fills the registration form with Telephone shorter than three characters")
    public void the_user_fills_the_registration_form_with_telephone_shorter_than_three_characters() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                "SHORT",
                password,
                password
        );
    }

    @When("The user fills the registration form with Telephone longer than thirty two characters")
    public void the_user_fills_the_registration_form_with_telephone_longer_than_thirty_two_characters() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                "LONG",
                password,
                password
        );
    }

    @When("The user fills the registration form with Password shorter than four characters")
    public void the_user_fills_the_registration_form_with_password_shorter_than_four_characters() {
        register.fillRegistrationForm(
                register.faker.name().firstName(),
                register.faker.name().lastName(),
                register.faker.internet().emailAddress(),
                register.faker.number().digits(11),
                "SHORT",
                null
        );
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



