package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage{

    @FindBy(xpath = "//h4")
    private List<WebElement> productList;

    @FindBy(xpath = "//button[@class='button-wishlist']")
    private List<WebElement> likeIcons;

    @FindBy(xpath = "//a[text()='wish list']")
    private WebElement wishListLink;

    @FindBy(xpath = "//h2")
    private WebElement wishListHeader;

    /**
     * Bu method ürünlerin üzerine gelmek için kullanılır
     * @param productIndex
     */
    public void getHoverToProduct(int productIndex){
        actions.moveToElement(productList.get(productIndex)).perform();
    }

    /**
     * Bu method beğenme ikonunun görüntülendiğini doğrular
     * Sayfa üzerinde birden fazla ürün olabilir, bu yüzden ürün indeksine göre kontrol yapılır
     * @param productIndex
     */
    public void likeIconIsDisplayed(int productIndex){
        Assert.assertTrue(likeIcons.get(productIndex).isDisplayed());

    }

    /**
     * Bu method beğenme ikonuna tıklamak için kullanılır
     * Sayfa üzerinde birden fazla ürün olabilir, bu yüzden ürün indeksine göre tıklama yapılır
     * @param productIndex
     */
    public void clickLikeIcon(int productIndex){
        likeIcons.get(productIndex).click();
    }

    /**
     * Bu method wish list sayfasına gitmek için kullanılır
     */
    public void goToWishListPage(){
        wishListLink.click();
    }

    /**
     * Bu method wish list sayfasının başlığını doğrular
     */
    public void verifyWishListPageTitle(){
        String expectedTitle = "My Wish List";
        String actualTitle = wishListHeader.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    /**
     * Bu method verilen productName e sahip ürünün wish list sayfasında olduğunu doğrular
     * @param productName
     */
    public void verifyProductAddedToWishList(String productName) {
        WebElement product = Driver.get().findElement(
                By.xpath("//td[contains(text(),'" + productName + "')]"));
        Assert.assertTrue(product.isDisplayed());
    }
    //bunu hocaya sor list içine alıp birden fazla ürün doğrulaması yapayım mı diye

}
