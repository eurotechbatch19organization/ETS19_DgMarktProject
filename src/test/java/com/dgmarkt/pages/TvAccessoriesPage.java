package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TvAccessoriesPage extends BasePage {


    @FindBy(xpath = "(//a[contains(text(),'TV Accessories')])[1]")
    private WebElement tvAccessoriesSubmenu;

    @FindBy(xpath = "//h1[text()='TV Accessories']")
    private WebElement tvAccessoriesHeader;

    public WebElement getTvAccessoriesSubmenu() {
        return tvAccessoriesSubmenu;
    }
    public WebElement getTvAccessoriesHeader() {
        return tvAccessoriesHeader;
    }
}
