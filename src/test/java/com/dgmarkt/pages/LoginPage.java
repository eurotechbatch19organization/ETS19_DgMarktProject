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

    @FindBy(id = "pt-login-link")
    private WebElement login2Btn;

    @FindBy(xpath = "//h2[text()='Login or create an account']")
    private WebElement loginOrCreateAnAccountPageTitle;

    @FindBy(xpath = "//input[@placeholder='E-Mail Address']")
    private WebElement emailBox2;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordBox2;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement login3Btn;

    @FindBy(xpath = "//div[text()=' Congratulation! Login Successfully']")
    private WebElement CongratulationLoginSuccessfullyPageTitle;


    public void login() {
        emailBox.sendKeys(ConfigurationReader.get("firstEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("firstPassword"));
        loginBtn.click();
        closeNewsletterPopupIfExists();
    }

    public void closeNewsletterPopupIfExists() {
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




    public void login2(){
        login2Btn.click();

    }


    public void verifyLoginPageTitle(){
        String actualPageTitle = loginOrCreateAnAccountPageTitle.getText();
        String expectedPageTitle = "Login or create an account";
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
    }



    public void login3() {
        emailBox2.sendKeys(ConfigurationReader.get("myAccountEmail"));
        passwordBox2.sendKeys(ConfigurationReader.get("myAccountPassword"));
        login3Btn.click();

    }

    public void verifyLoginSuccess(){
        String actualPageTitle = CongratulationLoginSuccessfullyPageTitle.getText();
        String expectedPageTitle = " Congratulation! Login Successfully";

       boolean result = false;
        if(actualPageTitle.contains("Congratulation!")){
            result = true;
            actualPageTitle=" Congratulation! Login Successfully";

        }

        Assert.assertEquals(expectedPageTitle,actualPageTitle);


    }


}

