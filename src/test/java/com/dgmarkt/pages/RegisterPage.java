package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    private Faker faker = new Faker();

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-register-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-register-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@name='newsletter' and @value='0']")
    private WebElement subscribeNo;

    @FindBy(xpath = "//input[@name='newsletter' and @value='1']")
    private WebElement subscribeYes;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[contains(text(),'Your Account Has Been Created')]")
    private WebElement successMessage;

    @FindBy(xpath = "//button[contains(.,'Continue')]")
    private WebElement continueAfterAccountCreated;

    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div[contains(@class,'text-danger')]")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div[contains(@class,'text-danger')]")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//input[@id='input-register-email']/following-sibling::div[contains(@class,'text-danger')]")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div[contains(@class,'text-danger')]")
    private WebElement telephoneErrorMessage;

    @FindBy(xpath = "//input[@id='input-register-password']/following-sibling::div[contains(@class,'text-danger')]")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div[contains(@class,'text-danger')]")
    private WebElement passwordConfirmErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement warningMessage;

    public void enterFirstName(String text) {
        firstName.sendKeys(text);
    }

    public void enterLastName(String text) {
        lastName.sendKeys(text);
    }

    public void enterEmail(String text) {
        email.sendKeys(text);
    }

    public void enterTelephone(String text) {
        telephone.sendKeys(text);
    }

    public void enterPassword(String passwordText) {
        password.sendKeys(passwordText);
    }

    public void enterPasswordConfirm(String confirmText) {
        passwordConfirm.sendKeys(confirmText);
    }

    public void selectSubscribeNo() {
        subscribeNo.click();
    }

    public void selectSubscribeYes() {
        subscribeYes.click();
    }

    public void agreePrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        BrowserUtils.waitForVisibility(successMessage, 10);
        return successMessage.isDisplayed();
    }

    public void clickContinueAfterAccountCreated() {
        String xpath = "(//a[normalize-space()='Continue'] | " +
                "//button[normalize-space()='Continue'] | " +
                "//button[.//span[normalize-space()='Continue']])";

        WebElement continueBtn = Driver.get().findElement(By.xpath(xpath));
        BrowserUtils.waitForClickablility(continueBtn, 10);
        BrowserUtils.clickWithJS(continueBtn);
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public String getFirstNameErrorMessage() {
        BrowserUtils.waitForVisibility(firstNameErrorMessage, 10);
        return firstNameErrorMessage.getText();
    }

    public String getLastNameErrorMessage() {
        BrowserUtils.waitForVisibility(lastNameErrorMessage, 10);
        return lastNameErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        BrowserUtils.waitForVisibility(emailErrorMessage, 10);
        return emailErrorMessage.getText();
    }

    public String getTelephoneErrorMessage() {
        BrowserUtils.waitForVisibility(telephoneErrorMessage, 10);
        return telephoneErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        BrowserUtils.waitForVisibility(passwordErrorMessage, 10);
        return passwordErrorMessage.getText();
    }

    public String getPasswordConfirmErrorMessage() {
        BrowserUtils.waitForVisibility(passwordConfirmErrorMessage, 10);
        return passwordConfirmErrorMessage.getText();
    }

    public String getWarningMessage() {
        BrowserUtils.waitForVisibility(warningMessage, 10);
        return warningMessage.getText().trim();
    }

    /**
     * Flexible registration form filler with custom parameters
     * @param firstNameValue - null to skip, "LONG" for 33 chars, or custom value
     * @param lastNameValue - null to skip, "LONG" for 33 chars, or custom value
     * @param emailValue - null to skip, "INVALID" for invalid format, or custom value
     * @param telephoneValue - null to skip, "SHORT" for 2 digits, "LONG" for 33 digits, or custom value
     * @param passwordValue - null to skip, "SHORT" for 3 chars, "MISMATCH" for different confirm, or custom value
     * @param confirmPasswordValue - null to skip, or custom value
     */
    public void fillRegistrationForm(String firstNameValue,
                                     String lastNameValue,
                                     String emailValue,
                                     String telephoneValue,
                                     String passwordValue,
                                     String confirmPasswordValue) {

        // First Name
        if (firstNameValue != null) {
            if (firstNameValue.equals("LONG")) {
                enterFirstName(faker.lorem().characters(33));
            } else {
                enterFirstName(firstNameValue);
            }
        }

        // Last Name
        if (lastNameValue != null) {
            if (lastNameValue.equals("LONG")) {
                enterLastName(faker.lorem().characters(33));
            } else {
                enterLastName(lastNameValue);
            }
        }

        // Email
        if (emailValue != null) {
            if (emailValue.equals("INVALID")) {
                enterEmail("invalidEmailFormat");
            } else {
                enterEmail(emailValue);
            }
        }

        // Telephone
        if (telephoneValue != null) {
            if (telephoneValue.equals("SHORT")) {
                enterTelephone(faker.number().digits(2));
            } else if (telephoneValue.equals("LONG")) {
                enterTelephone(faker.number().digits(33));
            } else {
                enterTelephone(telephoneValue);
            }
        }

        // Password
        if (passwordValue != null) {
            if (passwordValue.equals("SHORT")) {
                String shortPass = faker.lorem().characters(3);
                enterPassword(shortPass);
                if (confirmPasswordValue == null) {
                    enterPasswordConfirm(shortPass);
                }
            } else if (passwordValue.equals("MISMATCH")) {
                String pass1 = faker.internet().password(8, 12, true, true);
                String pass2 = faker.internet().password(8, 12, true, true);
                enterPassword(pass1);
                enterPasswordConfirm(pass2);
                return; // Don't process confirmPasswordValue for MISMATCH
            } else {
                enterPassword(passwordValue);
            }
        }

        // Password Confirm
        if (confirmPasswordValue != null && passwordValue != null && !passwordValue.equals("MISMATCH")) {
            enterPasswordConfirm(confirmPasswordValue);
        }
    }

    /**
     * Helper method to fill form with valid random data
     */
    public void fillRegistrationFormWithValidData() {
        String password = faker.internet().password(8, 12, true, true);
        fillRegistrationForm(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.number().digits(11),
                password,
                password
        );
    }
}



