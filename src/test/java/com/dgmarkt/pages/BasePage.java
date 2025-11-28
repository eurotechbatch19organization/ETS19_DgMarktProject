package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
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
        PageFactory.initElements(Driver.get(),this);
     }

    Actions actions= new Actions(Driver.get());
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));


    @FindBy(xpath = "//div[@id='pt-menu-7739']/ul/li")
    private List<WebElement> homeTabElements;

    @FindBy(xpath = "//span[text()='Category']")
    private WebElement categoryMenu;

    @FindBy(xpath = "//div[@class='row']//a[@class='a-mega-second-link']")
    private List<WebElement> submenuList;

    public WebElement getCategoryMenu() {
        return categoryMenu;
    }

    public List<WebElement> getSubmenuList() {
        return submenuList;
    }

    public List<String > getHomeTabsTexts(){
        return BrowserUtils.getElementsText(homeTabElements);
    }

    public void hoverToCategory(){
        actions.moveToElement(categoryMenu).perform();


    }

    public List<String> getSubmenuNames() {
        List<String> submenuNames = new ArrayList<>();
        for (WebElement submenu : submenuList) {
            submenuNames.add(submenu.getText());
        }
        return submenuNames;
    }

    public void verifyCategoryTabs(){
        wait.until(ExpectedConditions.visibilityOfAllElements(getSubmenuList()));

        boolean allVisible = getSubmenuList()
                .stream()
                .allMatch(WebElement::isDisplayed);
        Assert.assertTrue("Submenu list is NOT visible!", allVisible);

    }
















}
