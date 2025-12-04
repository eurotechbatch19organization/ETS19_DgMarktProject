package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.dgmarkt.utilities.Driver.driver;

public class ComparisonPage extends BasePage{

   @FindBy(xpath = "//h1[text()='Product Comparison']")
   private WebElement comparisonPageTitle;

   @FindBy(css = "table.table-bordered td a strong")
   private List<WebElement> productNames;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement comparisonCloseBtn;



    /**
     * bu metod Comparison Page sayfasının tamamen yüklendiğini doğrular.
     */
    public void waitForComparisonPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(comparisonPageTitle));
    }


    /**
     * bu metod ürünün Product Comparison sayfasına eklenip eklenmediğini kontrol eder.
     * @param expectedProductName
     */
    public void verifyProductInCompareList(String expectedProductName){
        waitForComparisonPageToLoad();
        List<String>products= BrowserUtils.getElementsText(productNames);
        Assert.assertTrue(products.contains(expectedProductName));
    }

    /**
     * bu metod ürünün sadece bir defa listede yer aldığını doğrular
     */
    public void verifyOnlyOneProductInComparison() {
        waitForComparisonPageToLoad();
        Assert.assertEquals(1,productNames.size());
    }

    /**
     * bu metod Product Comparison sayfasında en fazla 4 ürün olduğunu kontrol eder.
     */
    public void testMaxFourProductsInComparison()  {
        Assert.assertTrue("Karşılaştırmada 4ten fazla ürün var!", productNames.size() <= 4);
    }



}
