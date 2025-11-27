package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeStepDefs {

    HomePage homePage= new HomePage();


    @When("The user should be able to see dashboard page")
    public void the_user_should_be_able_to_see_dashboard_page() {
        homePage.getHomeTabsTexts();

    }
    @Then("The user should be able to hover over the Category Menu")
    public void the_user_should_be_able_to_hover_over_the_category_menu() {
        homePage.hoverToCategory();
    }

    @Then("The user should be able to see the Category submenu list")
    public void the_user_should_be_able_to_see_the_category_submenu_list() {
        homePage.hoverToCategory();
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(homePage.submenuList));

        boolean allVisible = homePage.submenuList
                .stream()
                .allMatch(WebElement::isDisplayed);
        Assert.assertTrue("Submenu list is NOT visible!", allVisible);

    }
    @Then("The submenu should contain the following items:")
    public void the_submenu_should_contain_the_following_items(List<String> expectedSubmenuNames) {
        List<String> actualSubmenuNames = homePage.getSubmenuNames();
        actualSubmenuNames.replaceAll(String::trim);
        Assert.assertEquals("Submenu items do NOT match!",
                expectedSubmenuNames,
                actualSubmenuNames);
        for (WebElement submenu : homePage.submenuList) {
            System.out.println(submenu.getText());
        }

    }





}
