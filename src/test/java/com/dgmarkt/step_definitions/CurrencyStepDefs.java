package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.ShoppingCartPage;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CurrencyStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Given("User should be on the Home Page")
    public void user_should_be_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.login();
    }
    @When("The user clicks on the currency dropdown")
    public void the_user_clicks_on_the_currency_dropdown() {
        homePage.openCurrencyOptions();

    }
    @When("The user selects {string} from the dropdown")
    public void the_user_selects_from_the_dropdown(String currency) {
        homePage.selectCurrency(currency);
        loginPage.closeNewsletterPopupIfExists();

    }
    @Then("The user should see the currency symbol {string} displayed on the page")
    public void the_user_should_see_the_currency_symbol_displayed_on_the_page(String currencySymbol){
        homePage.visibleSymbolsInCurrency(currencySymbol);

    }

    @And("The user clicks on {string} Category")
    public void the_user_clicks_on_category(String categoryName) {
        homePage.clickToCategory(categoryName);

    }
    @Then("The user verifies that the selected currency symbol {string} is displayed on the page.")
    public void the_user_verifies_that_the_selected_currency_symbol_is_displayed_on_the_page(String symbol) {
        homePage.verifyPricesContainSymbol(symbol);

    }
}
