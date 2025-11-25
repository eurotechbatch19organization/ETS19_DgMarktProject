package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    {
        PageFactory.initElements(Driver.get(),this);
     }
}
