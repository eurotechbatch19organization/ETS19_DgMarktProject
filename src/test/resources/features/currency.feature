Feature: Currency Scenario

  Background:
    Given User should be on the Home Page
    And The user clicks on the currency dropdown


  Scenario: (Without Login)Verify Currency Selection
    When The user selects "Euro" from the dropdown
    Then The user should see the currency symbol "€" displayed on the page



  Scenario: (Without Login) Verify Currency Selection and Add to Cart
    When the user hovers over the Category section
    And The user should be able to see the Category submenu list
    Then The user selects "Euro" from the dropdown
    And The user clicks on "HEALTH & BEAUTY" Category
    Then The user verifies that the selected currency symbol "€" is displayed on the page.
    And The user add "eufy C1 Smart Scale White" to the shopping cart.
    Then The user should see the shopping cart popup
    When The user clicks on the shopping cart link

  @wip
  Scenario: (Without Login)Order Completion With Selected Currency
    When The user selects "Euro" from the dropdown
    And The user clicks on "HEALTH & BEAUTY" Category
    And The user add "eufy C1 Smart Scale White" to the shopping cart.
    Then The user should see the shopping cart popup
    When The user clicks on the shopping cart link
    Then The user verifies that the selected currency symbol "€" is displayed on the page.
    When The user clicks on the Checkout button
    And The user selected "Guest Checkout" option
    And The user clicks on the Continue button
    Then The user fills in all mandatory fields on the billing details.
    And The user completes the other steps to place the order.
    Then The user should see the order confirmation message.








