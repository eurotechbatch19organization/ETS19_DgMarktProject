package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add to Cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[text()='shopping cart']")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//div[@class='alert alert-fix alert-success alert-dismissible']")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class=\"radio\"][2]/descendant::input")
    private WebElement guestCheckoutRadioButton;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(id = "input-payment-email")
    private WebElement email;

    @FindBy(name = "telephone")
    private WebElement phone;

    @FindBy(name = "address_1")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "postcode")
    private WebElement postcode;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement termsAndConditionsCheckbox;

    @FindBy(id="button-confirm")
    public WebElement confirmOrderButton;

    @FindBy(xpath="//h1")
    private WebElement orderConfirmationMessage;

    /**
     * Bu method verilen productName e sahip urune tiklar
     *
     * @param productName
     */
    public void clickToProduct(String productName) {
        WebElement productLink = Driver.get().findElement(
                By.xpath("//a[contains(text(), '" + productName + "')]")
        );
        productLink.click();
    }

    /**
     * Bu method ürün sepete eklendikten sonra çıkan pop-up ta yer alan
     * success message in görünür olduğunu doğrular
     */
    public void verifySuccessMessageIsDisplayed() {
        Assert.assertTrue(successMessage.isDisplayed());
    }

    /**
     * Bu method ürün sepete eklendikten sonra çıkan pop-up ta yer alan
     * shopping cart linkine tıklar
     */
    public void clickToShoppingCartLink() {
        shoppingCartLink.click();
    }

    public void clickToCheckoutButton() {
        checkoutButton.click();
    }

    /**
     * Bu method checkout sayfasında Guest Checkout radio buttona tıklar.
     * Register Account seçeneğine basmak isterseniz;
     * guestCheckoutRadioButton locatoründeki [2] rakamını [1] yapınız.
     */
    public void selectGuestCheckoutRadioButton() {
        guestCheckoutRadioButton.click();
    }

    /**
     * Bu method billing details kısmındaki zorunlu alanları doldurur
     */
    public void fillBillingDetails() {

        firstName.sendKeys("Irem"+ Keys.TAB);
        lastName.sendKeys("Yokus"+ Keys.TAB);
        email.sendKeys("test@gmail.com"+ Keys.TAB);
        phone.sendKeys("5555555555"+ Keys.TAB);
        address.sendKeys("Test Mahallesi 12"+ Keys.TAB);
        city.sendKeys("Istanbul"+ Keys.TAB);
        postcode.sendKeys("34000"+ Keys.TAB);

  }
  /**
     * Bu method billing details kısmında Region/State dropdownından istenilen state i seçer
     * Chatgpt den yardım aldım.
     * @param stateName
     */
    public void selectRegionState(String stateName) {
        WebElement regionDropdown = Driver.get().findElement(By.id("input-payment-zone"));
        Select select = new Select(regionDropdown);
        select.selectByVisibleText(stateName);
    }

    /**
     * Bu method sayfadaki görünür olan Continue butonuna tıklar
     * Continue locatorı birden fazla olduğundan tek bir şekilde yapınca ilk gördüğüne tıklıyor
     * ve diğer adımlarda hata veriyordu.
     * Bu yüzden tüm continue butonlarını listeye aldım ve tek tek görünür ve aktif olanı bulup tıkladım.
     * Chatgpt den de yardım aldım.
     */
    public void clickVisibleContinue() {
        List<WebElement> continueButtons = Driver.get().
                findElements(By.xpath("//input[@value='Continue']"));

        for (WebElement button : continueButtons) {
            if (button.isDisplayed() && button.isEnabled()) {
                button.click();
                return;
            }
        }
    }

    /**
     * Bu method sipariş onay mesajının doğru olduğunu doğrular
     */
    public void verifyOrderConfirmationMessage() {
      //  wait.until(ExpectedConditions.visibilityOf(orderConfirmationMessage));
        String expectedMessage = "Your Order Has Been Placed!";
        String actualMessage = orderConfirmationMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

}
