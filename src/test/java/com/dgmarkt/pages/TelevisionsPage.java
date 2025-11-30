package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelevisionsPage extends BasePage{

    @FindBy(xpath = "//h1[text()='Televisions']")
    private WebElement televisionsHeader;

    public WebElement getTelevisionsHeader() {
        return televisionsHeader;
    }
}
