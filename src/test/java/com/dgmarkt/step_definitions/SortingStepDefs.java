package com.dgmarkt.step_definitions;


import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SortingStepDefs{

        HomePage homePage = new HomePage();
        HealthAndBeautyPage healthAndBeautyPage = new HealthAndBeautyPage();
        TelevisionsPage televisionsPage = new TelevisionsPage();
        NetworkingPage networkingPage = new NetworkingPage();
        TvAccessoriesPage tvAccessoriesPage = new TvAccessoriesPage();

        private BasePage currentCategoryPage;

    private BasePage getCategoryPage(String category) {
        switch (category.toLowerCase().trim()) {
            case "health & beauty":
                return healthAndBeautyPage;
            case "televisions":
                return televisionsPage;
            case "networking":
                return networkingPage;
            case "tv accessories":
                return tvAccessoriesPage;
            default:
                throw new RuntimeException("Unknown category: " + category);
        }
    }

    @Given("The user navigates to the {string} category page")
    public void the_user_navigates_to_the_category_page(String category) {
        homePage.navigateToCategory(category);
        currentCategoryPage = getCategoryPage(category);

    }

    @When("The user selects {string} from Sort By dropdown")
    public void the_user_selects_from_sort_by_dropdown(String sortType) {
        currentCategoryPage.selectSortByOption(sortType);

    }

    @Then("The products should be sorted by {string} in {string} category")
    public void the_products_should_be_sorted_by_in_category(String string, String string2) {


    }
    @Then("The user should verify that dropdown shows {string} as selected option")
    public void the_user_should_verify_that_dropdown_shows_as_selected_option(String expectedSortType) {
        currentCategoryPage.verifySelectedSortOption(expectedSortType);

    }
}

