package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.PasswordChangePage;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp(){
        Driver.get().manage().window().setPosition(new Point(-1000,0));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    @After(order=0)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
      Driver.closeDriver();
    }

    @After(value="@LongPasswordNegative",order=1)
            public void tearDownPasswordChange(){
    PasswordChangePage passwordChangePage= new PasswordChangePage();
            // Password sayfasına geri dön
            passwordChangePage.clickSection("Password");

    // Orijinal şifreyi geri yaz
    passwordChangePage.resetToOriginalPassword(
            ConfigurationReader.get("newChangePassword")
            );
    }


}
