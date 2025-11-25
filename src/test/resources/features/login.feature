Feature: Login Scenarios

  Scenario: First Login
    Given User is on the main login page
    When User enters valid credentials
    Then User verfies that main page is visible
