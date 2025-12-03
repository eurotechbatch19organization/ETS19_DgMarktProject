Feature: DGMarkt Registration

  Background:
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
  @wipYasemin
  Scenario: Successful registration - SDT19DM-36
    When The user fills the registration form with valid data
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The user should see success message
    And The user clicks continue on success popup

  Scenario: Verify error message when First Name field is left empty - SDT19DM-40
    When The user fills the registration form without First Name
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "First Name must be between 1 and 32 characters!" should be displayed

  Scenario: Verify error message when Last Name field is empty - SDT19DM-41
    When The user fills the registration form without Last Name
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Last Name must be between 1 and 32 characters!" should be displayed

  Scenario: Verify error message when Email field is left empty - SDT19DM-42
    When The user fills the registration form without Email
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "E-Mail Address does not appear to be valid!" should be displayed

  Scenario: Verify error message when Telephone field is left empty - SDT19DM-44
    When The user fills the registration form without Telephone
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Telephone must be between 3 and 32 characters!" should be displayed

  Scenario: Verify error message when Password field is left empty - SDT19DM-45
    When The user fills the registration form without Password
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Password must be between 4 and 20 characters!" should be displayed

  Scenario: Verify error message when Password Confirm field is left empty - SDT19DM-48
    When The user fills the registration form without Password Confirm
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Password confirmation does not match password!" should be displayed

  Scenario: Verify that user cannot register without agreeing to Privacy Policy - SDT19DM-52
    When The user fills the registration form with valid data
    And The user selects subscription as "No"
    And The user does not agree to Privacy Policy
    And The user clicks Continue button
    Then The warning message "Warning: You must agree to the Privacy Policy!" should be displayed

  Scenario: Verify error messages for Last Name and Email fields when left empty - SDT19DM-74
    When The user fills the registration form without Last Name and Email
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Last Name must be between 1 and 32 characters!" should be displayed
    And The error message "E-Mail Address does not appear to be valid!" should be displayed

  Scenario: Verify error messages for Telephone and Password fields when left empty - SDT19DM-75
    When The user fills the registration form without Telephone and Password
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Telephone must be between 3 and 32 characters!" should be displayed
    And The error message "Password must be between 4 and 20 characters!" should be displayed

  Scenario: Verify error messages for First Name, Last Name and Telephone fields when left empty -SDT19DM-76
    When The user fills the registration form without First Name, Last Name and Telephone
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "First Name must be between 1 and 32 characters!" should be displayed
    And The error message "Last Name must be between 1 and 32 characters!" should be displayed
    And The error message "Telephone must be between 3 and 32 characters!" should be displayed

  Scenario: Verify error message when Email format is invalid - SDT19DM-43
    When The user fills the registration form with invalid Email format
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "E-Mail Address does not appear to be valid!" should be displayed

  Scenario: Verify error when Password and Password Confirm do not match - SDT19DM-49
    When The user fills the registration form with mismatched passwords
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Password confirmation does not match password!" should be displayed

  Scenario: Verify error for First Name longer than 32 characters  - SDT19DM-54
    When The user fills the registration form with First Name longer than thirty two characters
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "First Name must be between 1 and 32 characters!" should be displayed

  Scenario: Verify error for Last Name longer than 32 characters - SDT19DM-55
    When The user fills the registration form with Last Name longer than thirty two characters
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Last Name must be between 1 and 32 characters!" should be displayed

  Scenario: Verify error for Telephone shorter than 3 characters - SDT19DM-57
    When The user fills the registration form with Telephone shorter than three characters
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Telephone must be between 3 and 32 characters!" should be displayed

  Scenario: Verify error for Telephone longer than 32 characters - SDT19DM-58
    When The user fills the registration form with Telephone longer than thirty two characters
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Telephone must be between 3 and 32 characters!" should be displayed

  Scenario: Verify error when Password is shorter than 4 characters - SDT19DM-59
    When The user fills the registration form with Password shorter than four characters
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Password must be between 4 and 20 characters!" should be displayed
