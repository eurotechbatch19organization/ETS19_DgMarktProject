Feature: Password Change Functionality

  Background:
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    Then The user should see the main page
    And The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page
    Given The user Login with credentials
    And the user selects "My Account" from the submenu
    Then the user confirms they are on the "Account" page
    When the user clicks on the "Password" section
    Then the user confirms they are on the "Change Password" page



  Scenario Outline: Verify that passwords with minimum 4 characters are accepted successfully - TC005 [US-08]
    Then the user enters "<password>" into the password fields
    Then the user sees a confirmation message stating "Success: Your password has been successfully updated."
    And the user resets the password back to the original one

    Examples:
      | password |
      | 1234     |
      | abcd     |
      | @@@@     |


  Scenario: User updates their password and successfully logs in using the new password-TC001-[US-08]
    Then the user enters "sld4321" into the password fields
    Then the user sees a confirmation message stating "Success: Your password has been successfully updated."
    When The user logs out of their account
    And The user clicks on the My Account button
    And The user clicks on the Login2 button
    And The user logs in again using the new password "sld4321"
    Then The user verifies Login Successful message is displayed
    Then The user navigates to the Password section and resets the password

@wip
  Scenario: Verify warning message for mismatched or incomplete password confirmation-TC006-[US-08]
    When The user enters "sld4321" as new password and "sda432" as confirm password and clicks Continue
    Then The user should see the warning message "Password confirmation does not match password!"

  @wip
  Scenario: Verify warning when the user enters a password shorter than 4 characters-TC002-[US-08]
    When The user enters "123" as new password and "123" as confirm password and clicks Continue
    Then The user should see the warning message "Password must be between 4 and 20 characters!"