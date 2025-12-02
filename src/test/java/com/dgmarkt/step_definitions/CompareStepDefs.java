package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HealthAndBeautyPage;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CompareStepDefs {

    HealthAndBeautyPage healthAndBeautyPage= new HealthAndBeautyPage();

    @When("The user clicks on the Health & Beauty subcategory")
    public void the_user_clicks_on_the_health_beauty_subcategory() {
        healthAndBeautyPage.getHealthAndBeautySubmenu().click();
    }
    @Then("The user should see the Health & Beauty page")
    public void the_user_should_see_the_health_beauty_page() {
        String expectedHeader = "Health & Beauty";
        String actualHeader = healthAndBeautyPage.getHealthAndBeautyHeader().getText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }

    @Then("The user should see the Compare this Product icon appear on product hover")
    public void the_user_should_see_the_compare_this_product_icon_appear_on_product_hover() {
       healthAndBeautyPage.hoverToCompareBtn();
    }


    @Then("The user clicks on the Compare this Product icon for the  BaByliss 3663U")
    public void the_user_clicks_on_the_compare_this_product_icon_for_the_ba_byliss_3663u() {
        healthAndBeautyPage.CompareBtn().click();
    }

    @Then("The user clicks the ‘product comparison’ text within the message ‘Success: You have added BaByliss 3663U - Hair Rollers to your product comparison!’")
    public void the_user_clicks_the_product_comparison_text_within_the_message_success_you_have_added_ba_byliss_3663u_hair_rollers_to_your_product_comparison() throws InterruptedException {
        healthAndBeautyPage.ProductComparisonLinkBtn().click();


    }

    @Then("The user verifies that the {string} product has been added to the Product Comparison page.")
    public void the_user_verifies_that_the_product_has_been_added_to_the_product_comparison_page(String expectedProductName) {
        healthAndBeautyPage.verifyProductInCompareList(expectedProductName);


    }







}
