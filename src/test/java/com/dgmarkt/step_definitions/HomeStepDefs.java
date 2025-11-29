package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HealthAndBeautyPage;
import com.dgmarkt.pages.HomePage;

import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static com.dgmarkt.pages.BasePage.*;

public class HomeStepDefs {

    HomePage homePage = new HomePage();


    @When("the user locates the Category section on the homepage")
    public void the_user_locates_the_category_section_on_the_homepage() {
        homePage.getHomeTabsTexts();
    }

    @When("the user hovers over the Category section")
    public void the_user_hovers_over_the_category_section() {
        homePage.hoverToCategory();
    }

    @Then("The user should be able to see the Category submenu list")
    public void the_user_should_be_able_to_see_the_category_submenu_list() {
      homePage.verifyCategoryTabs();
    }

    @Then("The submenu should contain the following items:")
    public void the_submenu_should_contain_the_following_items(List<String> expectedSubmenuNames) {
        List<String> actualSubmenuNames = homePage.getSubmenuNames();
        actualSubmenuNames.replaceAll(String::trim);
        Assert.assertEquals("Submenu items do NOT match!",
                expectedSubmenuNames,
                actualSubmenuNames);
        for (WebElement submenu : homePage.getSubmenuList()) {
            System.out.println(submenu.getText());
        }
    }









}
