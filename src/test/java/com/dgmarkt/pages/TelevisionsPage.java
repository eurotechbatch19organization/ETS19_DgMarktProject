package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelevisionsPage extends BasePage{

    @FindBy(xpath = "(//a[contains(text(),'Televisions')])[1]")
    private WebElement televisionsSubmenu;

    @FindBy(xpath = "//h1[text()='Televisions']")
    private WebElement televisionsHeader;


    public WebElement getTelevisionsHeader() {
        return televisionsHeader;
    }
    public WebElement getTelevisionsSubmenu() {
        return televisionsSubmenu;
    }
}
