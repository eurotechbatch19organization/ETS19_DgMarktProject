package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasePage {
    {
        PageFactory.initElements(Driver.get(),this);
     }

    Actions actions= new Actions(Driver.get());
    @FindBy(xpath = "//div[@id='pt-menu-7739']/ul/li")
    private List<WebElement> homeTabElements;

    @FindBy(xpath = "//span[text()='Category']")
    public WebElement categoryMenu;
    @FindBy(xpath = "(//a[contains(text(),'Health & Beauty')])[1]")
    private WebElement healthAndBeautySubmenu;

    @FindBy(xpath = "(//a[contains(text(),'Televisions')])[1]")
    private WebElement televisionsSubmenu;

    @FindBy(xpath = "(//a[contains(text(),'TV Accessories')])[1]")
    private WebElement tvAccessoriesSubmenu;

    @FindBy(xpath = "(//a[contains(text(),'Networking')])[1]")
    private WebElement networkingSubmenu;

    @FindBy(xpath = "//div[@class='row']//a[@class='a-mega-second-link']")
    public List<WebElement> submenuList;


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

















}
