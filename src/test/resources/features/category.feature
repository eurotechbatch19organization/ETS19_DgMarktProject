Feature: Home Page Functionality

 Background:  Scenario: First Login
   Given User is on the main login page
   When The user enters valid email and password and clicks the Login button
   And Closes the newsletter popup if it appears
   Then The user should see the main page
@wip
  Scenario: Verifying Category Menu Visibility on the Home Page
    When The user should be able to see dashboard page
    Then The user should be able to hover over the Category Menu
    And The user should be able to see the Category submenu list
    And The submenu should contain the following items:
    | HEALTH & BEAUTY |
    | TELEVISIONS     |
    | TV ACCESSORIES  |
    | NETWORKING      |
