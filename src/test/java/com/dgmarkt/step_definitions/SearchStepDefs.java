package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.SearchPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefs {

    SearchPage searchPage = new SearchPage();

    @When("The user clicks on the Search Button")
    public void the_user_clicks_on_the_search_button() {
        searchPage.searchFirstBtnClick();

    }
    @Then("The user should be able to see the Search Engine UI")
    public void the_user_should_be_able_to_see_the_search_engine_ui() {
        searchPage.searchEngineUI_validate();
    }


    @When("The user enter the product name or keyword that want to find {string}")
    public void the_user_enter_the_product_name_or_keyword_that_want_to_find(String string) {
        searchPage.searchFirstBtnClick();
        searchPage.searchEngineUI_validate();
        searchPage.searchTxtBoxPutText(string);
        searchPage.searchSecondBtnClick();
    }
    @Then("The user verifies that included the {string} in the related products")
    public void the_user_verifies_that_included_the_in_the_related_products(String string) {

        searchPage.searchValidation(string);
    }


    @When("The user click the Search Button with no data on Search Text Box")
    public void the_user_click_the_search_button_with_no_data_on_search_text_box() {
        searchPage.searchFirstBtnClick();
        searchPage.searchEngineUI_validate();
        searchPage.searchSecondBtnClick();
    }
    @Then("The user verifies that showing the related message")
    public void the_user_verifies_that_showing_the_related_message() {
        BrowserUtils.waitFor(2);
        searchPage.searchEmptyValidation();
    }

    @When("The user enter the keyword that is not related to the products {string}")
    public void the_user_enter_the_keyword_that_is_not_related_to_the_products(String string) {
        searchPage.searchFirstBtnClick();
        searchPage.searchEngineUI_validate();
        searchPage.searchTxtBoxPutText(string);
        //searchPage.searchSecondBtnClick();
    }
    @Then("The user verifies that showing the related fault message")
    public void the_user_verifies_that_showing_the_related_fault_message() {
        BrowserUtils.waitFor(2);
        searchPage.searchWrongWordValidation();
    }

}
