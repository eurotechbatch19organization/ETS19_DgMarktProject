Feature: Cat-Subcategory-Compare this Product icon function Test

  Background:
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    And Closes the newsletter popup if it appears
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

  @wip
  Scenario: Users can add products to the comparison list by clicking the “Compare This Product” icon TC02-[US-21]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And The user clicks on the Health & Beauty subcategory
    Then The user should see the Health & Beauty page
    Then The user should see the Compare this Product icon appear on product hover
    Then The user clicks on the Compare this Product icon for the  BaByliss 3663U
    Then The user clicks the ‘product comparison’ text within the message ‘Success: You have added BaByliss 3663U - Hair Rollers to your product comparison!’
    Then The user verifies that the "BaByliss 3663U - Hair Rollers" product has been added to the Product Comparison page.