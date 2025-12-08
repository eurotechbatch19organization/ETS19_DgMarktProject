package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingStepDefs {
    HomePage homePage = new HomePage();
    SortingPage sortingPage = new SortingPage(); // ✅ SortingPage kullan

    @Given("The user navigates to the {string} category page")
    public void the_user_navigates_to_the_category_page(String category) {
        homePage.navigateToCategory(category);
    }

    @When("The user selects {string} from Sort By dropdown")
    public void the_user_selects_from_sort_by_dropdown(String sortType) {
        sortingPage.selectSortByOption(sortType);
    }

    @Then("The products should be sorted by {string} in {string} category")
    public void the_products_should_be_sorted_by_in_category(String sortType, String category) {
        sortingPage.verifyProductsSortedBy(sortType, category); // ✅ Tek satır!
    }

    @Then("The user should verify that dropdown shows {string} as selected option")
    public void the_user_should_verify_that_dropdown_shows_as_selected_option(String expectedSortType) {
        sortingPage.verifySelectedSortOption(expectedSortType);
    }
}

