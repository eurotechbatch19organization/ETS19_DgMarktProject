package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.ShoppingCartPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ShoppingCartStepDefs {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoginPage loginPage = new LoginPage();

    @And("The user add {string} to the shopping cart.")
    public void the_user_add_to_the_shopping_cart(String productName) {
        shoppingCartPage.clickToProduct(productName);
        shoppingCartPage.addToCartButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("The user should see the shopping cart popup")
    public void the_user_should_see_the_shopping_cart_popup() {
        shoppingCartPage.verifySuccessMessageIsDisplayed();

    }

    @When("The user clicks on the shopping cart link")
    public void the_user_clicks_on_the_shopping_cart_link() {
        shoppingCartPage.clickToShoppingCartLink();

    }

    @When("The user clicks on the Checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        shoppingCartPage.clickToCheckoutButton();

    }

    @When("The user selected {string} option")
    public void the_user_selected_option(String guestOption) {
        shoppingCartPage.selectGuestCheckoutRadioButton();
    }

    @When("The user clicks on the Continue button")
    public void the_user_clicks_on_the_continue_button() {
        shoppingCartPage.clickVisibleContinue();
    }

    @Then("The user fills in all mandatory fields on the billing details.")
    public void the_user_fills_in_all_mandatory_fields_on_the_billing_details() {
        shoppingCartPage.fillBillingDetails();
        shoppingCartPage.selectRegionState("Bristol");
        shoppingCartPage.clickVisibleContinue();
        BrowserUtils.waitFor(2);
    }

    @Then("The user completes the other steps to place the order.")
    public void the_user_completes_the_other_steps_to_place_the_order() {
        shoppingCartPage.clickVisibleContinue();
        shoppingCartPage.termsAndConditionsCheckbox.click();
        shoppingCartPage.clickVisibleContinue();
    }

    @Then("The user should see the order confirmation message.")
    public void the_user_should_see_the_order_confirmation_message() {
        shoppingCartPage.confirmOrderButton.click();
        BrowserUtils.waitFor(5);
        shoppingCartPage.verifyOrderConfirmationMessage();

    }

    @When("The user logs in and verifies")
    public void the_user_logs_in_and_verifies() {
        loginPage.myAccountLink.click();
        loginPage.login2();
        loginPage.verifyLoginPageTitle();
        loginPage.login3();
        loginPage.verifyLoginSuccess();
    }

    @Then("the user verifies that the address in the Billing Details section is selected")
    public void the_user_verifies_that_the_address_in_the_billing_details_section_is_selected() {
        shoppingCartPage.verifyExistingAddressIsSelected();
    }

    @When("The user clicks Continue on the Delivery Details step")
    public void the_user_clicks_continue_on_the_delivery_details_step() {
        shoppingCartPage.verifyExistingAddressIsSelected();
        shoppingCartPage.clickDeliveryDetailsContinue();
    }
    @Then("The user completes the Delivery Method step")
    public void the_user_completes_the_delivery_method_step() {
        shoppingCartPage.verifyFlatRateIsSelected();
        shoppingCartPage.continueButtonFlatRate.click();
    }
    @Then("The user completes Payment Method step")
    public void the_user_completes_payment_method_step() {
     shoppingCartPage.verifyCashOnDeliveryIsSelected();
        shoppingCartPage.termsAndConditionsCheckbox.click();
        shoppingCartPage.continueButtonPaymentMethod.click();
    }
}
