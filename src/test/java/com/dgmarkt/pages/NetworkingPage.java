package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NetworkingPage extends BasePage{

    @FindBy(xpath = "//h1[text()='Networking']")
    private WebElement networkingHeader;

    public WebElement getNetworkingHeader() {
        return networkingHeader;
    }
}
