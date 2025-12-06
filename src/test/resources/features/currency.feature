Feature: Currency Scenario

  Background:
    Given User should be on the Home Page


  Scenario: (Without Login)Verify Currency Selection / TC001 – [US-22]
    When The user clicks on the currency dropdown
    And The user selects "Euro" from the dropdown
    Then The user should see the currency symbol "€" displayed on the page


  Scenario: (Without Login) Verify Currency Selection and Add to Cart / TC006-[US-22]
    When The user clicks on the currency dropdown
    Then the user hovers over the Category section
    And The user should be able to see the Category submenu list
    Then The user selects "Euro" from the dropdown
    And The user clicks on "HEALTH & BEAUTY" Category
    Then The user verifies that the selected currency symbol "€" is displayed on the page.
    And The user add "eufy C1 Smart Scale White" to the shopping cart.
    Then The user should see the shopping cart popup
    When The user clicks on the shopping cart link


  Scenario: (Without Login)Order Completion With Selected Currency / TC006-[US-22]
    When The user clicks on the currency dropdown
    Then The user selects "Euro" from the dropdown
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


  Scenario: (With Login) Verify Currency Selection /TC005-[US-22]
    When The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    When The user enters E-Mail Address and Password and clicks the Login button
    Then The user verifies Login Successful message is displayed
    And The user clicks on the currency dropdown
    When The user selects "Euro" from the dropdown
    Then The user should see the currency symbol "€" displayed on the page


  Scenario: (With Login) Order Completion With Selected Currency / TC00(2,3,4)-[US-22]
    When The user logs in and verifies
    And The user clicks on the currency dropdown
    When The user selects "Pound Sterling" from the dropdown
    Then The user should see the currency symbol "£" displayed on the page
    And The user clicks on "TV Accessories" Category
    And The user add "Belkin HDMI cable - 1.5 m" to the shopping cart.
    Then The user should see the shopping cart popup
    When The user clicks on the shopping cart link
    Then The user verifies that the selected currency symbol "£" is displayed on the page.
    When The user clicks on the Checkout button
    Then the user verifies that the address in the Billing Details section is selected
    And The user clicks on the Continue button
    And The user clicks Continue on the Delivery Details step
    And The user completes the Delivery Method step
    And The user completes Payment Method step
    Then The user should see the order confirmation message.










