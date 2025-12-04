package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.ComparisonPage;
import com.dgmarkt.pages.HealthAndBeautyPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CompareStepDefs {

    HealthAndBeautyPage healthAndBeautyPage= new HealthAndBeautyPage();
    ComparisonPage comparisonPage = new ComparisonPage();

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
       comparisonPage.hoverToCompareBtn();
    }

    @Then("The user clicks on the Compare this Product icon for the {string}")
    public void the_user_clicks_on_the_compare_this_product_icon_for_the(String productName) {
        comparisonPage.compareButton(productName).click();
    }

    @Then("The user clicks on the close button")
    public void the_user_clicks_on_the_close_button() {
        comparisonPage.comparisonCloseBtn.click();
    }


    @Then("The user clicks the Product Comparison link in the success message")
    public void the_user_clicks_the_product_comparison_text_within_the_message_success_you_have_added_ba_byliss_3663u_hair_rollers_to_your_product_comparison()  {
        comparisonPage.ProductComparisonLinkBtn().click();
    }


    @Then("The user verifies that the {string} product has been added to the Product Comparison page.")
    public void the_user_verifies_that_the_product_has_been_added_to_the_product_comparison_page(String expectedProductName) {
        comparisonPage.verifyProductInCompareList(expectedProductName);
    }



    @Then("The user verifies that only one \"BaByliss 3663U - Hair rollers\" product exists in the comparison list")
    public void the_user_verifies_that_there_is_only_one_ba_byliss_3663u_product() {
        comparisonPage.verifyOnlyOneProductInComparison();
    }

    @Then("The user verifies that only four products are present in the comparison list")
    public void the_user_verifies_that_only_four_products_are_present_in_the_comparison_list() {
           comparisonPage.testMaxFourProductsInComparison();
    }


}
