Feature: Password Change Functionality

  Background:
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    And Closes the newsletter popup if it appears
    Then The user should see the main page
    And The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page


  @wip
  Scenario Outline: Verify that passwords with minimum 4 characters are accepted successfully - TC005 [US-08]
    Given The user Login with credentials
    And the user selects "My Account" from the submenu
    Then the user confirms they are on the "Account" page
    When the user clicks on the "Password" section
    Then the user confirms they are on the "Change Password" page
    Then the user enters "<password>" into the password fields
    Then the user sees a confirmation message stating "Success: Your password has been successfully updated."
    And the user resets the password back to the original one

    Examples:
      | password |
      | 1234     |
      | abcd     |
      | @@@@     |


