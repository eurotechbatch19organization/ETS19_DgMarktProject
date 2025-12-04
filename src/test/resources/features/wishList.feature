Feature: Like Icon (Wish List) Scenario

  Background:
    Given User should be on the Home Page

  Scenario: Login Required for Like Icon / TC001-[US-5]
    When The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    When The user enters E-Mail Address and Password and clicks the Login button
    Then The user verifies Login Successful message is displayed

  @wip
  Scenario: Add Product to Wish List / TC003 -[US-5]
    When The user logs in and verifies
    And The user clicks on "HEALTH & BEAUTY" Category
    When The user hovers over the product
    Then The user verifies that the like icon is displayed on the product
    When The user clicks on the like icon of the product
    And The user goes to the Wish List page
    Then The user should verify that the "eufy C1 Smart Scale White" is added to the Wish List
