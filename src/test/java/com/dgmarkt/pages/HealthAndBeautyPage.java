package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HealthAndBeautyPage extends BasePage{

    @FindBy(xpath = "(//a[contains(text(),'Health & Beauty')])[1]")
    private WebElement healthAndBeautySubmenu;

    @FindBy(xpath = "//h1[text()='Health & Beauty']")
    private WebElement healthAndBeautyHeader;

    public WebElement getHealthAndBeautySubmenu() {
        return healthAndBeautySubmenu;
    }
    public WebElement getHealthAndBeautyHeader() {
        return healthAndBeautyHeader;
    }
}
