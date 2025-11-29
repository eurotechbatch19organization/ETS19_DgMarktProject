package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.TelevisionsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TelevisionsStepDefs {

    HomePage homePage=new HomePage();

    TelevisionsPage televisionsPage= new TelevisionsPage();

    @When("from the dropdown menu, the user clicks on the Televisions subcategory")
    public void from_the_dropdown_menu_the_user_clicks_on_the_televisions_subcategory() {
        televisionsPage.getTelevisionsSubmenu().click();
    }

    @Then("the user is directed to the Televisions page")
    public void the_user_is_directed_to_the_televisions_page() {
        String expectedTitleContains = "Televisions";
        String actualTitle = televisionsPage.getTelevisionsHeader().getText();
        Assert.assertTrue(actualTitle.contains(expectedTitleContains));

    }




}
