package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//*[@class='dropdown-toggle search-button']")
    private WebElement searchFirstBtn;

    @FindBy(xpath = "//*[@id='text-search']")
    private WebElement searchTxtBox;

    @FindBy(xpath = "//*[@id='btn-search-category']")
    private WebElement searchSecondBtn;

    @FindBy(xpath = "//*[@class='caption']//h4//a")
    private List<WebElement> searchedProductList;

    @FindBy(xpath = "//*[@id='content']//p[2]")
    private WebElement errorMsg;

   @FindBy(xpath = "//*[@class='ajax-result-container']//p")
   private WebElement wrongWordSearchMsg;

    public void searchFirstBtnClick(){
        searchFirstBtn.click();
    }

    public void searchSecondBtnClick(){
        searchSecondBtn.click();
    }

    public void searchTxtBoxPutText(String searchData){
        searchTxtBox.sendKeys(searchData);
    }

    public void searchEngineUI_validate(){
//        String actualTxt = searchTxtBox.getText();
//        String expectedTxt = "Search entire store here ...";
//        Assert.assertEquals(expectedTxt, actualTxt);
        Assert.assertTrue(searchSecondBtn.isDisplayed());
    }

    public void searchValidation(String string){
        List<String> searchedProducts = BrowserUtils.getElementsText(searchedProductList);
//        for (String products : searchedProducts){
//            System.out.println("products = " + products);
//        }
        Assert.assertTrue(searchedProducts.contains(string));
    }


    public void searchEmptyValidation(){
        String actualMsg = BrowserUtils.getText(errorMsg);
        Assert.assertEquals("There is no product that matches the search criteria.", actualMsg);
    }

    public void searchWrongWordValidation(){

        String actualMsg = BrowserUtils.getText(wrongWordSearchMsg);
        Assert.assertEquals("There are no products to list in this category.",actualMsg);
    }
}
