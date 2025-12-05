Feature: Advanced Login Scenarios

  Background:
    Given User is on the main login page
    When The user enters valid email and password and clicks the Login button
    Then The user should see the main page
    And The user clicks on the My Account button
    And The user clicks on the Login2 button
    Then The user should see the Login or create an account page


  @AC1 @smoke
  Scenario: AC_1 - Successful login with valid E-Mail and password
    When The user enters E-Mail Address and Password and clicks the Login button
    And The user verifies Login Successful message is displayed
    And The user clicks the Logout button
    Then The user should see the "Login" button in My Account section


  @AC2
  Scenario: AC_2 - User can not login with wrong password for a registered e-mail
    When the user enters a valid registered e-mail "cart@mon.com"
    And the user enters a wrong password "WrongPass123!"
    And the user clicks the Login button
    Then the user should see an error message "Warning: No match for E-Mail Address and/or Password."
    And the user should remain on the login page


  @AC3
  Scenario Outline: AC_3 - User can not login with invalid credentials
    When the user enters an invalid e-mail "<email>"
    And the user enters any password "<password>"
    And the user clicks the Login button
    Then the user should see a validation message "<message>"
    And the user should remain on the login page

    Examples:
      | email            | password     | message                                               |
      | invalid          | 123456       | Warning: No match for E-Mail Address and/or Password. |
      | test@test        | 123456       | Warning: No match for E-Mail Address and/or Password. |
      | @test.com        | 123456       | Warning: No match for E-Mail Address and/or Password. |
      | unknown@test.com | Rree.*123456 | Warning: No match for E-Mail Address and/or Password. |


  @AC4
  Scenario Outline: AC_4 - User can not login with blank input boxes
    When the user leaves the e-mail field "<email>"
    And the user leaves the password field "<password>"
    And the user clicks the Login button
    Then the user should see a validation message "<message>"
    And the user should remain on the login page

    Examples:
      | email | password | message                                               |
      | blank | blank    | Warning: No match for E-Mail Address and/or Password. |
      | value | blank    | Warning: No match for E-Mail Address and/or Password. |
      | blank | value    | Warning: No match for E-Mail Address and/or Password. |


  @AC5
  Scenario: AC_5 - Password is displayed as bullet signs by default
    When the user focuses on the password field
    And the user types any password "MySecret123!"
    Then the password field type should be "password"
    And the user should see the password masked as bullet signs


  @AC6
  Scenario: AC_6 - User can use the Forgotten Password functionality with registered e-mail
    When the user clicks the "Forgotten Password" link
    And the user enters a registered e-mail "valid_user@test.com" in the forgotten password field
    And the user clicks the Continue button
    Then the user should see a message "An email with a confirmation link has been sent to your email address."
    And a password reset e-mail should be sent to "valid_user@test.com"


  @AC6
  Scenario: AC_6 - Forgotten Password with unregistered e-mail
    When the user clicks the "Forgotten Password" link
    And the user enters an unregistered e-mail "unknown@test.com" in the forgotten password field
    And the user clicks the Continue button
    Then the user should see a message "Warning: The E-Mail Address was not found in our records."
    And no password reset e-mail should be sent


  @AC7
  Scenario: AC_7 - User can not login after exceeding 5 failed login attempts
    Given the user has already tried to login 5 times with wrong password
    When the user enters a valid registered e-mail "valid_user@test.com"
    And the user enters a wrong password "WrongPass123!"
    And the user clicks the Login button
    Then the user should see a lockout message "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."
    And the user should not be logged in
    And the user should remain on the login page