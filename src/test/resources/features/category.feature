Feature: Home Page Functionality

 Background:  Scenario: First Login
   Given User is on the main login page
   When The user enters valid email and password and clicks the Login button
   And Closes the newsletter popup if it appears
   Then The user should see the main page


  Scenario: Verifying Category Menu Visibility on the Home Page-TC001-[US-12]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And The user should be able to see the Category submenu list
    And The submenu should contain the following items:
    | HEALTH & BEAUTY |
    | TELEVISIONS     |
    | TV ACCESSORIES  |
    | NETWORKING      |


  Scenario: Navigating to the Health & Beauty Page via Category Hover-TC005-[US-12]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And from the dropdown menu, the user clicks on the Health & Beauty subcategory
    Then the user is directed to the Health & Beauty page


  Scenario: Navigating to the Televisions Page via Category Hover-TC006-[US-12]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And from the dropdown menu, the user clicks on the Televisions subcategory
    Then the user is directed to the Televisions page


  Scenario: Navigating to the TV Accessories Page via Category Hover-TC007-[US-12]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    When from the dropdown menu, the user clicks on the TV Accessories subcategory
    Then the user is directed to the TV Accessories page


  Scenario: Navigating to the Networking Page via Category Hover-TC008-[US-12]
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    When from the dropdown menu, the user clicks on the Networking subcategory
    Then the user is directed to the Networking page


  Scenario: Viewing Category Submenus after Login-TC002-[US-12]
    Given The user clicks on the My Account button
    When The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    When The user enters E-Mail Address and Password and clicks the Login button
    Then The user verifies Login Successful message is displayed
    When the user locates the Category section on the homepage
    And the user hovers over the Category section
    And The user should be able to see the Category submenu list
    And The submenu should contain the following items:
      | HEALTH & BEAUTY |
      | TELEVISIONS     |
      | TV ACCESSORIES  |
      | NETWORKING      |






