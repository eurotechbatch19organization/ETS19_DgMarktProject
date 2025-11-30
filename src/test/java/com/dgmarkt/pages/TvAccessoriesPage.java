package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TvAccessoriesPage extends BasePage {

    @FindBy(xpath = "//h1[text()='TV Accessories']")
    private WebElement tvAccessoriesHeader;

    public WebElement getTvAccessoriesHeader() {
        return tvAccessoriesHeader;
    }
}
