
Feature: Like Icon (Wish List) Scenario

  Background:
    Given User should be on the Home Page

  Scenario: Login Required for Like Icon / TC001-[US-5]
    When The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    When The user enters E-Mail Address and Password and clicks the Login button
    Then The user verifies Login Successful message is displayed


  Scenario: Add Product to Wish List / TC003 -[US-5]
    When The user logs in and verifies
    And The user clicks on "HEALTH & BEAUTY" Category
    When The user hovers over the product
    Then The user verifies that the like icon is displayed on the product
    When The user clicks on the like icon of the product
    And The user goes to the Wish List page
    Then The user should verify that the "eufy C1 Smart Scale White" is added to the Wish List


  Scenario: Delete Product from Wish List / TC004 -[US-5]
    When The user logs in and verifies
    And The user verifies that the like icon is displayed on the homepage
    And The user clicks on the like icon on the homepage
    Then The user should verify that the "eufy C1 Smart Scale White" is added to the Wish List
    When The user clicks on the Remove button of the product
    Then The user verifies that the product is removed from the Wish List page
    And The user verifies that the "eufy C1 Smart Scale White" is not displayed in the wishlist


  Scenario: Add Product to Cart From Wish List / TC005 -[US-5]
    When The user logs in and verifies
    And The user verifies that the like icon is displayed on the homepage
    And The user clicks on the like icon on the homepage
    Then The user should verify that the "eufy C1 Smart Scale White" is added to the Wish List
    When The user clicks on the Add to Cart button of the product
    Then The user verifies that the product is added to the Cart successfully
    When The user clicks on the shopping cart link
    Then The user verifies that the "eufy C1 Smart Scale White" is displayed in the cart page


  Scenario:Add Product Without Login / TC002-[US-5]
    And The user clicks on "HEALTH & BEAUTY" Category
    When The user hovers over the product
    Then The user verifies that the like icon is displayed on the product
    When The user clicks on the like icon of the product
    Then The user should see a message prompting to log in or create an account

