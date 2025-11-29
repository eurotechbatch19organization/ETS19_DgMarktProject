package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.NetworkingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NetworkingStepDefs {

    NetworkingPage networkingPage= new NetworkingPage();

    @When("from the dropdown menu, the user clicks on the Networking subcategory")
    public void from_the_dropdown_menu_the_user_clicks_on_the_networking_subcategory() {
        networkingPage.getNetworkingSubmenu().click();
    }

    @Then("the user is directed to the Networking page")
    public void the_user_is_directed_to_the_networking_page() {
        String expectedTitleContains = "Networking";
        String actualTitle = networkingPage.getNetworkingHeader().getText();
        Assert.assertTrue(actualTitle.contains(expectedTitleContains));
    }
}
