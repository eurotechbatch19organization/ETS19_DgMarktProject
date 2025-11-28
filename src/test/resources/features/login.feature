Feature: Login Scenarios

  Scenario: First Login
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    And Closes the newsletter popup if it appears
    Then The user should see the main page


    Scenario: Second Login
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    And Closes the newsletter popup if it appears
    Then The user should see the main page
    And The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    When The user enters E-Mail Address and Password and clicks the Login button
    Then The user verifies Login Successful message is displayed



