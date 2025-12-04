package com.dgmarkt.pages;

import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordChangePage extends BasePage{

    @FindBy(xpath = "//a[normalize-space()='Account']")
    public WebElement accountLink;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//a[normalize-space()='Password']")
    private WebElement changePasswordHeader;

    @FindBy(id = "input-password")
    public WebElement newPasswordInput;

    @FindBy(id= "input-confirm")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;



    /**
     * cift parametreli versiyonu farkli parolalar icin kullanilir
     * @param newPassword,  confirmPassword
     */
    public void clickNewChangePassword(String newPassword ,String confirmPassword ){
        newPasswordInput.sendKeys(newPassword);
        passwordConfirmInput.sendKeys(confirmPassword);
        continueBtn.click();
    }

    /**
     * tek parametreli versiyonu ayni parolalar icin kullanilir
     * @param password
     */

    public void clickNewChangePassword(String password){
        newPasswordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(password);
        continueBtn.click();
    }

    /**
     * bu method parola degistirme islemlerininin sonunda orijinal parolaya donmek icin kullanilir
     */
    public void resetToOriginalPassword(String originalPassword) {
        newPasswordInput.clear();
        newPasswordInput.sendKeys(originalPassword);
        passwordConfirmInput.clear();
        passwordConfirmInput.sendKeys(originalPassword);
        continueBtn.click();
    }

    public void verifySuccessMessage() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'alert-success')]")
        ));

        String actual = alert.getText().trim()
                .replace("×", "")
                .trim();

        String expected = "Success: Your password has been successfully updated.";

        Assert.assertTrue(
                "Expected success message not found! Actual message: " + actual,
                actual.contains(expected)
        );
    }

    public WebElement getFreshAccountLink() {
        return Driver.get().findElement(By.xpath("//a[normalize-space()='Account']"));
    }


}
