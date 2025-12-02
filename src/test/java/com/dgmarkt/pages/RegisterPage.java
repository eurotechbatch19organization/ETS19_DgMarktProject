package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

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

    public void agreePrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            BrowserUtils.waitForVisibility(successMessage, 10);
            System.out.println("Success message found: " + successMessage.getText());
            return successMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Success message NOT found. Error: " + e.getMessage());
            System.out.println("Current URL: " + Driver.get().getCurrentUrl());
            return false;
        }
    }

    public void clickContinueAfterAccountCreated() {

        String xpath = "(//a[normalize-space()='Continue'] | " +
                "//button[normalize-space()='Continue'] | " +
                "//button[.//span[normalize-space()='Continue']])";

        try {
            WebElement el = Driver.get().findElement(By.xpath(xpath));
            BrowserUtils.waitForClickablility(el, 10).click();
            return;
        } catch (Exception ignored) {
        }

        try {
            WebElement el = Driver.get().findElement(By.xpath(xpath));
            BrowserUtils.clickWithJS(el);
            return;
        } catch (Exception ignored) {
        }


        throw new RuntimeException("Failed to click Continue button on success popup!");
    }

    public String getFirstNameErrorMessage() {
        try {
            BrowserUtils.waitForVisibility(firstNameErrorMessage, 10);
            return firstNameErrorMessage.getText();
        } catch (Exception e) {
            System.out.println("Error message not found: " + e.getMessage());
            return "";
        }
    }

    public String getLastNameErrorMessage() {
        try {
            BrowserUtils.waitForVisibility(lastNameErrorMessage, 10);
            return lastNameErrorMessage.getText();
        } catch (Exception e) {
            System.out.println("Error message not found: " + e.getMessage());
            return "";
        }
    }

    public String getEmailErrorMessage() {
        try {
            BrowserUtils.waitForVisibility(emailErrorMessage, 10);
            return emailErrorMessage.getText();
        } catch (Exception e) {
            System.out.println("Email error message not found: " + e.getMessage());
            return "";
        }
    }

    public String getTelephoneErrorMessage() {
        try {
            BrowserUtils.waitForVisibility(telephoneErrorMessage, 10);
            return telephoneErrorMessage.getText();
        } catch (Exception e) {
            System.out.println("Telephone error message not found: " + e.getMessage());
            return "";
        }
    }

    public String getPasswordErrorMessage() {
        try {
            BrowserUtils.waitForVisibility(passwordErrorMessage, 10);
            return passwordErrorMessage.getText();
        } catch (Exception e) {
            System.out.println("Password error message not found: " + e.getMessage());
            return "";
        }
    }

    public String getPasswordConfirmErrorMessage() {
        try {
            BrowserUtils.waitForVisibility(passwordConfirmErrorMessage, 10);
            return passwordConfirmErrorMessage.getText();
        } catch (Exception e) {
            System.out.println("Password Confirm error message not found: " + e.getMessage());
            return "";
        }
    }

    public String getWarningMessage() {
        try {
            BrowserUtils.waitForVisibility(warningMessage, 10);
            return warningMessage.getText().trim();
        } catch (Exception e) {
            System.out.println("Warning message not found: " + e.getMessage());
            return "";
        }
    }
}


