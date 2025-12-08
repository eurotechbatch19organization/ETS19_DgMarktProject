
Feature: Cat-Subcategory-Compare this Product icon function Test

  Background:
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    Then The user should see the main page
    And The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    When The user enters E-Mail Address and Password and clicks the Login button
    Then The user verifies Login Successful message is displayed



  Scenario: The “Compare this Product” icon appears on product hover TC01-[US-21]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And The user clicks on the Health & Beauty subcategory
    Then The user should see the Health & Beauty page
    Then The user should see the Compare this Product icon appear on product hover



  Scenario: Users can add products to the comparison list by clicking the “Compare This Product” icon TC02-[US-21]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And The user clicks on the Health & Beauty subcategory
    Then The user should see the Health & Beauty page
    Then The user clicks on the Compare this Product icon for the "Capsule Plate 6pcs"
    Then The user clicks the Product Comparison link in the success message
    Then The user verifies that the "Capsule Plate 6pcs" product has been added to the Product Comparison page.



  Scenario: Users cannot add the same product to the comparison list more than once TC04-[US-21]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And The user clicks on the Health & Beauty subcategory
    Then The user clicks on the Compare this Product icon for the "BaByliss 3663U - Hair rollers"
    Then The user clicks on the close button
    Then The user clicks on the Compare this Product icon for the "BaByliss 3663U - Hair rollers"
    Then The user clicks the Product Comparison link in the success message
    Then The user verifies that only one "BaByliss 3663U - Hair rollers" product exists in the comparison list


  Scenario: Users cannot add more than four products to the comparison list TC03-[US-21]
      When the user locates the Category section on the homepage
      And the user hovers over the Category section
      And The user clicks on the Health & Beauty subcategory
      Then The user clicks on the Compare this Product icon for the "BaByliss 3663U - Hair rollers"
      Then The user clicks on the close button
      Then The user clicks on the Compare this Product icon for the "Capsule Plate 6pcs"
      Then The user clicks on the close button
      Then The user clicks on the Compare this Product icon for the "eufy C1 Smart Scale White"
      Then The user clicks on the close button
      Then The user clicks on the Compare this Product icon for the "eufy P1 Smart Scale Blue and Black"
      Then The user clicks on the close button
      Then The user clicks on the Compare this Product icon for the "Fitbit Aria Air Smart Bathroom Scale"
      Then The user clicks the Product Comparison link in the success message
      Then The user verifies that only four products are present in the comparison list