package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public abstract class BasePage {
    {
        PageFactory.initElements(Driver.get(), this);
    }

    Actions actions = new Actions(Driver.get());
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));


    @FindBy(xpath = "//div[@id='pt-menu-7739']/ul/li")
    private List<WebElement> homeTabElements;

    @FindBy(xpath = "//span[text()='Category']")
    private WebElement categoryMenu;

    @FindBy(xpath = "//div[@class='row']//a[@class='a-mega-second-link']")
    private List<WebElement> submenuList;

    @FindBy(xpath = "(//a[contains(text(),'Health & Beauty')])[1]")
    private WebElement healthAndBeautySubmenu;

    @FindBy(xpath = "//h1[text()='Health & Beauty']")
    private WebElement healthAndBeautyHeader;


    @FindBy(css = "a[title='My Account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Currency']")
    private WebElement currencyDropdown;



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

    @FindBy(xpath = "//a[contains(@href, 'product_id=7064674')]/following-sibling::div[@class='button-group']//button[@class='button-compare']")
    private WebElement compareButton;

    @FindBy(xpath = "//a[text()='product comparison']")
    private WebElement productComparisonLink;

    @FindBy(id = "input-sort")
    private WebElement sortByDropdown;

    @FindBy(css = ".product-thumb h4 a")
    private List<WebElement> productNameElements;

    @FindBy(css = ".price")
    private List<WebElement> productPriceElements;

    public WebElement getHealthAndBeautySubmenu() {
        return healthAndBeautySubmenu;
    }

    public WebElement getHealthAndBeautyHeader() {
        return healthAndBeautyHeader;
    }


    public List<WebElement> getSubmenuList() {
        return submenuList;
    }


    /**
     * bu method daschboard daki menuleri icine aldigi bir list icerir.SG
     *
     * @return
     */
    public List<String> getHomeTabsTexts() {
        return BrowserUtils.getElementsText(homeTabElements);
    }

    /**
     * bu method category menusune haver yapmak icin kullanilir SG
     */
    public void hoverToCategory() {
        actions.moveToElement(categoryMenu).perform();
    }

    /**
     * bu method category menusundeki submenuleri almak icin kullanilir.SG
     *
     * @return
     */
    public List<String> getSubmenuNames() {
        List<String> submenuNames = new ArrayList<>();
        for (WebElement submenu : submenuList) {
            submenuNames.add(submenu.getText());
        }
        return submenuNames;
    }

    /**
     * bu method category altındaki submenulere tıklamak için kullanılıyor.SG
     *
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

    /**
     * bu method category submenulerinin dogru sayfasina gittigini dogrulamak icin kullanilir.SG
     */
    public void verifyCategoryTabs() {
        wait.until(ExpectedConditions.visibilityOfAllElements(getSubmenuList()));

        boolean allVisible = getSubmenuList()
                .stream()
                .allMatch(WebElement::isDisplayed);
        Assert.assertTrue("Submenu list is NOT visible!", allVisible);

    }

    /**
     * Bu methodu elimizde olan currency optionslardan birini secmek icin kullaniyoruz.
     *
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
     *
     * @param symbol
     */
    public void verifyPricesContainSymbol(String symbol) {
        List<WebElement> prices = Driver.get().findElements(By.xpath("//div[@class=\"box-price\"]"));

        for (WebElement price : prices) {
            String priceText = price.getText();

            Assert.assertTrue("Price does not contain the symbol:" + priceText, priceText.contains(symbol));
        }
    }

    public void visibleSymbolsInCurrency(String pageSymbol) {

        WebElement symbol = Driver.get().findElement
                (By.xpath("//span[contains(text(),'" + pageSymbol + "')]"));

        Assert.assertTrue(symbol.isDisplayed());

    }

    public void verifyMainPageUrl() {
        String expected = ConfigurationReader.get("urlMain");
        String actual = Driver.get().getCurrentUrl();

        Assert.assertEquals(expected, actual);
    }

    /**
     * bu metod Compare this Product butonunu hover yapmak için hazırlanmıştır.
     */

    public void hoverToCompareBtn() {
        actions.moveToElement(compareButton).perform();
    }


    public WebElement compareButton(String productName) {
        return Driver.get().findElement(By.xpath(
                "//a[contains(text(),'" + productName + "')]/ancestor::div[contains(@class,'product-thumb')]//button[contains(@class,'compare')]"
        ));
    }

    /**
     * bu metod ProductComparisonLinkBtn'a click yapabilmek için hazırlanmıştır.
     */

    public WebElement ProductComparisonLinkBtn() {
        return productComparisonLink;
    }

    // Compare list ürün isimleri
    @FindBy(css = "table.table-bordered td a strong")
    private List<WebElement> productNames;

    /**
     * category menusunun alt submenulerine tikladigimizda SG
     * dogru sayfada oldugumuzu gösteren dinamik method
     *
     * @param expectedHeader
     */
    public void veriyfToSubMenuName(String expectedHeader) {

        WebElement header = Driver.get().findElement(By.xpath("//h1[text()='" + expectedHeader + "']"));
        Assert.assertEquals(
                "Page header is not correct!",
                expectedHeader,
                header.getText().trim()
        );
    }

    /**
     * kullanici login olduktan sonra ki My Account menusunun submenulerini icine alan SG
     * dinamik list methodu
     *
     * @param menuName
     */
    public void clickMyAccountToSubMenu(String menuName) {
        BrowserUtils.waitFor(1);
        WebElement submenu = Driver.get().findElement(By.xpath("(//a[text()='" + menuName + "'])[1]"));
        BrowserUtils.clickWithJS(submenu);
    }

    /**
     * bu methodla MyAccount daki submenudeki My Account un sayfasindaki Section'lara gideriz
     * dinamik method
     *
     * @param sectionName
     */
    public void clickSection(String sectionName) {
        WebElement section = Driver.get().findElement(
                By.xpath("//a[normalize-space()='" + sectionName + "']")
        );
        section.click();
    }

    /**
     * ana sayfadaki My Account linkine tiklar SG
     */
    public void clickMyAccountLink(String myAccount) {
        BrowserUtils.waitFor(1);
        wait.until(ExpectedConditions.visibilityOf(myAccountLink));
        clickMyAccountToSubMenu("Password");
    }

    /**
     * Bu method Sort By dropdown'ından istenen sorting tipini seçer
     *
     * @param sortType - "Default", "Name (A - Z)", "Price (Low > High)" vb.
     */
    public void selectSortByOption(String sortType) {
        Select select = new Select(sortByDropdown);
        select.selectByVisibleText(sortType);
    }


    /**
     * Bu method dropdown'da seçili olan sorting tipini döndürür
     *
     * @return Seçili olan sort option
     */
    public String getSelectedSortByOption() {
        Select select = new Select(sortByDropdown);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Bu method sayfadaki tüm ürün isimlerini liste olarak döndürür
     *
     * @return Ürün isimleri listesi
     */
    public List<String> getProductNames() {
        return BrowserUtils.getElementsText(productNameElements);

    }

    /**
     * Bu method sayfadaki tüm ürün fiyatlarını liste olarak döndürür
     *
     * @return Ürün fiyatları listesi (Double)
     */
    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement element : productPriceElements) {
            String priceText = element.getText()
                    .replace("$", "")
                    .replace("€", "")
                    .replace("£", "")
                    .replace(",", "")
                    .trim();
        }
        return prices;
    }

    /**
     * Kategoriye gitmek için bir method
     */
    public void navigateToCategory(String categoryName) {
        clickToCategory(categoryName);
        BrowserUtils.waitFor(2);
        veriyfToSubMenuName(categoryName);
    }
}








