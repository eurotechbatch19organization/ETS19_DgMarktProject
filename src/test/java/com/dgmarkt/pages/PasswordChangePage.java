package com.dgmarkt.pages;

import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordChangePage extends BasePage{


    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//a[normalize-space()='Password']")
    private WebElement changePasswordHeader;

    @FindBy(id = "input-password")
    public WebElement newPasswordInput;     // tekrar bakılacak private

    @FindBy(id= "input-confirm")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;

    // ------------ SCROLL -------------
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element
        );
    }

    /**
     * change Password sayfasina gider
     */
    public void clickChangePasswordHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordHeader));
        scrollIntoView(changePasswordHeader);
        changePasswordHeader.click();
    }


    // ---------- SAFE TYPE ----------
    private void waitAndType(WebElement element, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        scrollIntoView(el);
        el.clear();
        el.sendKeys(text);
    }

    /**
     * Change Password sayfasinda yeni sifre belirler
     * @param newPassword
     * @param confirmPassword
     */
    public void clickNewChangePassword(String newPassword, String confirmPassword) {
        waitAndType(newPasswordInput, newPassword);
        waitAndType(passwordConfirmInput, confirmPassword);
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    /**
     * Change Password sayfasinda yeni sifre belirler
     * @param password
     */
    public void clickNewChangePassword(String password) {
        waitAndType(newPasswordInput, password);
        waitAndType(passwordConfirmInput, password);
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    /**
     * Change Password sayfasinda orijinal sifreye dondurur
     * @param originalPassword
     */
    public void resetToOriginalPassword(String originalPassword) {
        waitAndType(newPasswordInput, originalPassword);
        waitAndType(passwordConfirmInput, originalPassword);
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    // ---------- SUCCESS VERIFY ----------
    public void verifySuccessMessage() {

        WebElement alert = wait.until(
                ExpectedConditions.visibilityOf(successMessage)
        );

        String actual = alert.getText()
                .replace("×", "")
                .trim();

        String expected = "Success: Your password has been successfully updated.";

        Assert.assertTrue(
                "Expected success message not found! Actual message: " + actual,
                actual.contains(expected)
        );
    }



}
