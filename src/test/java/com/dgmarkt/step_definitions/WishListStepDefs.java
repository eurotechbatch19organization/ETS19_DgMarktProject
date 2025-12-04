package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.ShoppingCartPage;
import com.dgmarkt.pages.WishListPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListStepDefs {

    WishListPage wishListPage = new WishListPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @When("The user hovers over the product")
    public void the_user_hovers_over_the_product() {
       wishListPage.getHoverToProduct(12);
        BrowserUtils.waitFor(1);
    }
    @Then("The user verifies that the like icon is displayed on the product")
    public void the_user_verifies_that_the_like_icon_is_displayed_on_the_product() {
        wishListPage.likeIconIsDisplayed(2);

    }
    @When("The user clicks on the like icon of the product")
    public void the_user_clicks_on_the_like_icon_of_the_product() {
        wishListPage.clickLikeIcon(2);
        BrowserUtils.waitFor(2);
    }
    @When("The user goes to the Wish List page")
    public void the_user_goes_to_the_wish_list_page() {
        shoppingCartPage.verifySuccessMessageIsDisplayed();
        BrowserUtils.waitFor(1);
        wishListPage.goToWishListPage();
    }
    @Then("The user should verify that the {string} is added to the Wish List")
    public void the_user_should_verify_that_the_is_added_to_the_wish_list(String productName) {
        wishListPage.verifyWishListPageTitle();
        BrowserUtils.waitFor(2);
        wishListPage.verifyProductAddedToWishList(productName);
    }

}
