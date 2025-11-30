package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.TvAccessoriesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TvAccessoriesStepDefs {

    TvAccessoriesPage tvAccessoriesPage= new TvAccessoriesPage();

    @When("from the dropdown menu, the user clicks on the TV Accessories subcategory")
    public void from_the_dropdown_menu_the_user_clicks_on_the_tv_accessories_subcategory() {
        tvAccessoriesPage.getTvAccessoriesSubmenu().click();
    }

    @Then("the user is directed to the TV Accessories page")
    public void the_user_is_directed_to_the_tv_accessories_page() {
        String expectedTitleContains = "TV Accessories";
        String actualTitle = tvAccessoriesPage.getTvAccessoriesHeader().getText();
        Assert.assertTrue(actualTitle.contains(expectedTitleContains));

    }

}
