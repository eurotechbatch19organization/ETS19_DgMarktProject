package com.dgmarkt.pages;


import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


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

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement noMatchWarningTitle;

    @FindBy(xpath = "//a[text()='Forgotten Password']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continiue2Button;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successInConfirmationLinkSendMessage;

    @FindBy(xpath = "//a[@class='a-close-frm']")
    private WebElement closeButtonLoginPage;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alertedAlertSamet;



    private By AlertMessageLoc =
            By.xpath("//div[contains(@class,'alert')]");
            //By.cssSelector("div.alert.alert-dismissible");


    public WebElement getNoMatchWarningTitle() {
        return noMatchWarningTitle;
    }

    public WebElement getPasswordBox2() {
        return passwordBox2;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getEmailBox2() {
        return emailBox2;
    }

    public WebElement getCloseButtonLoginPage() {
        return closeButtonLoginPage;
    }

    public WebElement getContiniue2Button() {
        return continiue2Button;
    }

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

    public void login2() {
        login2Btn.click();
    }

    public void verifyLoginPageTitle() {
        String actualPageTitle = loginOrCreateAnAccountPageTitle.getText();
        String expectedPageTitle = "Login or create an account";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    public void login3() {
        emailBox2.sendKeys(ConfigurationReader.get("myAccountEmail"));
        passwordBox2.sendKeys(ConfigurationReader.get("myAccountPassword"));
        login3Btn.click();
    }

    public void login(String email, String password) {
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        login3Btn.click();
    }

    /**
     * change password test case lerim icin olusturdugum login methodu
     */
    public void loginWithSelda() {
        emailBox2.sendKeys(ConfigurationReader.get("myChangeEmail"));
        passwordBox2.sendKeys(ConfigurationReader.get("newChangePassword"));
        login3Btn.click();
    }

    public void verifyLoginSuccess() {
        String actualPageTitle = CongratulationLoginSuccessfullyPageTitle.getText();
        String expectedPageTitle = " Congratulation! Login Successfully";

        if (actualPageTitle.contains("Congratulation!")) {
            actualPageTitle = " Congratulation! Login Successfully";
        }
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    public boolean isLoginButtonVisible() {
        myAccountLink.click();
        BrowserUtils.waitForVisibility(login2Btn, 3 );
        try {
            return login2Btn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void verifyErrorMessage(String  message) {
        String actualPageTitle = noMatchWarningTitle.getText().trim();
        String expectedPageTitle = message;

        if (actualPageTitle.contains("No match for E-Mail")) {
            actualPageTitle = " Warning: No match for E-Mail Address and/or Password.";
        }
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    public void verifyLoginOrCreateAnAccountPage() {
        String actualPageTitle = loginOrCreateAnAccountPageTitle.getText();
        String expectedPageTitle = "Login or create an account";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    public void clickLogin3Button() {
        login3Btn.click();
    }

    public void verifyConfirmationLinkInEmail(String text) {
        String actualPageTitle = successInConfirmationLinkSendMessage.getText();
        String expectedPageTitle = " An email with a confirmation link has been sent your email address.";

        if (actualPageTitle.contains("An email with a confirmation")) {
            actualPageTitle = " An email with a confirmation link has been sent your email address.";
        }
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    public void verifyForgotPasswordAlert(String expectedMessage) {
        System.out.println(alertedAlertSamet.getText());
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertMessageLoc));

        String raw = alert.getText();
        String actualPageTitle = raw.split("\\R")[0].trim();

        Assert.assertEquals(expectedMessage, actualPageTitle);
    }

    public void tryToLoginWithWrongPassManyTimes(Integer times) {
        for (int i = 0; i < times; i++) {
            emailBox2.sendKeys(ConfigurationReader.get("E-mail"));
            passwordBox2.sendKeys("WrongPassword123!");
            login3Btn.click();
        }
    }

}

