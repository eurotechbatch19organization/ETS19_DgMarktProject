@wip
Feature: Search Function Tests

  Background:
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    Then The user should see the main page
    And The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    When The user enters E-Mail Address and Password and clicks the Login button
    Then The user verifies Login Successful message is displayed

  Scenario: Search Engine UI Check-TC001-[US-04]
    When The user clicks on the Search Button
    Then The user should be able to see the Search Engine UI

  Scenario: Search Icon Function Positive Check-TC002-[US-04]
    When The user enter the product name or keyword that want to find "Asus"
    Then The user verifies that included the "Asus" in the related products

  Scenario: Search Icon Empty Check-TC003-[US-04]
    When The user click the Search Button with no data on Search Text Box
    Then The user verifies that showing the related message

  Scenario: Search Icon Negative Function Check-TC004-[US-04]
    When The user enter the keyword that is not related to the products "Nane"
    Then The user verifies that showing the related fault message