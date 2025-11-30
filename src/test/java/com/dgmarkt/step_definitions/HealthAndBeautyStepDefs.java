package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.HealthAndBeautyPage;
import com.dgmarkt.pages.HomePage;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static java.sql.DriverManager.getDriver;

public class HealthAndBeautyStepDefs {

    HealthAndBeautyPage healthAndBeautyPage= new HealthAndBeautyPage();

    @When("from the dropdown menu, the user clicks on the Health & Beauty subcategory")
    public void from_the_dropdown_menu_the_user_clicks_on_the_health_beauty_subcategory() {
        healthAndBeautyPage.getHealthAndBeautySubmenu().click();
    }

    @Then("the user is directed to the Health & Beauty page")
    public void the_user_is_directed_to_the_health_beauty_page() {
        String expectedHeader = "Health & Beauty";
        String actualHeader = healthAndBeautyPage.getHealthAndBeautyHeader().getText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }









}
