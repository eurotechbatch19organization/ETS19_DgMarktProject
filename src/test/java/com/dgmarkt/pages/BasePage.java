package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasePage {
    {
        PageFactory.initElements(Driver.get(), this);
    }

    Actions actions= new Actions(Driver.get());
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));


    @FindBy(xpath = "//div[@id='pt-menu-7739']/ul/li")
    private List<WebElement> homeTabElements;

    @FindBy(xpath = "//span[text()='Category']")
    private WebElement categoryMenu;

    @FindBy(xpath = "//div[@class='row']//a[@class='a-mega-second-link']")
    private List<WebElement> submenuList;

    @FindBy(xpath = "(//a[contains(text(),'Health & Beauty')])[1]")
    private WebElement healthAndBeautySubmenu;

    @FindBy(xpath = "(//a[contains(text(),'Televisions')])[1]")
    private WebElement televisionsSubmenu;

    @FindBy(xpath = "(//a[contains(text(),'TV Accessories')])[1]")
    private WebElement tvAccessoriesSubmenu;

    @FindBy(xpath = "(//a[contains(text(),'Networking')])[1]")
    private WebElement networkingSubmenu;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountLink;

    @FindBy(id = "pt-logout-link")
    public WebElement logoutButton;

    @FindBy(xpath = "(//span[text()='Continue'])[2]")
    private WebElement continueButton;

    public void logout() {
        myAccountLink.click();
        logoutButton.click();
        BrowserUtils.waitForVisibility(continueButton, 3);
        continueButton.click();
    }

    public WebElement getHealthAndBeautySubmenu() {
        return healthAndBeautySubmenu;
    }
    public WebElement getTelevisionsSubmenu() {
        return televisionsSubmenu;
    }
    public WebElement getTvAccessoriesSubmenu() {
        return tvAccessoriesSubmenu;
    }
    public WebElement getNetworkingSubmenu() {
        return networkingSubmenu;
    }

    @FindBy(xpath = "//span[text()='Currency']")
    private WebElement currencyDropdown;

    @FindBy(css = "a.a-close-newsletter")
    private WebElement closeNewsletterButton;

    public WebElement getCategoryMenu() {
        return categoryMenu;
    }

    public List<WebElement> getSubmenuList() {
        return submenuList;
    }

    public List<String> getHomeTabsTexts() {
        return BrowserUtils.getElementsText(homeTabElements);
    }

    public void hoverToCategory() {
        actions.moveToElement(categoryMenu).perform();
    }

    public List<String> getSubmenuNames() {
        List<String> submenuNames = new ArrayList<>();
        for (WebElement submenu : submenuList) {
            submenuNames.add(submenu.getText());
        }
        return submenuNames;
    }

    /**
     * bu method category altındaki submenulere tıklamak için kullanılıyor.
     * @param categoryName
     */
    public void clickToCategory(String categoryName) {
        hoverToCategory();
        for (WebElement submenu : submenuList) {
            if (submenu.getText().trim().equalsIgnoreCase(categoryName.trim())) {
                submenu.click();
                return;
            }
        }
    }
    public void openCurrencyOptions() {
        currencyDropdown.click();
    }
    public void verifyCategoryTabs(){
        wait.until(ExpectedConditions.visibilityOfAllElements(getSubmenuList()));

        boolean allVisible = getSubmenuList()
                .stream()
                .allMatch(WebElement::isDisplayed);
        Assert.assertTrue("Submenu list is NOT visible!", allVisible);

    }





    /**
     * Bu methodu elimizde olan currency optionslardan birini secmek icin kullaniyoruz.
     * @param currency
     */
    public void selectCurrency(String currency) {
        WebElement currencyOption = Driver.get().findElement(
                By.xpath("//button[contains(text(), '" + currency + "')]")
        );
        currencyOption.click();
    }

    /**
     * Bu method sayfadaki fiyatların seçilen para birimi sembolünü içerip içermediğini doğruluyor.
     * @param symbol
     */
    public void verifyPricesContainSymbol(String symbol) {
        List<WebElement> prices = Driver.get().findElements(By.xpath("//div[@class=\"box-price\"]"));

        for (WebElement price : prices) {
            String priceText = price.getText();

            Assert.assertTrue("Price does not contain the symbol:" + priceText, priceText.contains(symbol));
        }
    }
    public void visibleSymbolsInCurrency(String pageSymbol){

        WebElement symbol =Driver.get().findElement
                (By.xpath("//span[contains(text(),'"+pageSymbol+"')]"));

        Assert.assertTrue(symbol.isDisplayed());

    }
    public void verifyMainPageUrl() {
        String expected = ConfigurationReader.get("urlMain");
        String actual = Driver.get().getCurrentUrl();

        Assert.assertEquals(expected, actual);
    }




}





