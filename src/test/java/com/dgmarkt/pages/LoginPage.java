package com.dgmarkt.pages;


import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailBox;

    @FindBy(name = "password")
    private WebElement passwordBox;

    @FindBy(css = "input[name='login']")
    private WebElement loginBtn;

    @FindBy(css = "a.a-close-newsletter")
    private WebElement closeNewsletterButton;

    @FindBy(css = "a[title='My Account']")
    public WebElement myAccountLink;

    public void login() {
        emailBox.sendKeys(ConfigurationReader.get("firstEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("firstPassword"));
        loginBtn.click();
        closeNewsletterPopupIfExists();
    }

    private void closeNewsletterPopupIfExists() {
        try {
            BrowserUtils.waitForClickablility(closeNewsletterButton, 10).click();
        } catch (Exception ignored) {
        }
    }

    public void setUpUI() {
        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
        login();
    }

}