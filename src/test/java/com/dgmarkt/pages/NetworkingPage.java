package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NetworkingPage extends BasePage{

    @FindBy(xpath = "(//a[contains(text(),'Networking')])[1]")
    private WebElement networkingSubmenu;

    @FindBy(xpath = "//h1[text()='Networking']")
    private WebElement networkingHeader;

    public WebElement getNetworkingSubmenu() {
        return networkingSubmenu;
    }
    public WebElement getNetworkingHeader() {
        return networkingHeader;
    }
}
