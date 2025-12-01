Feature: DGMarkt Registration

  Scenario: Successful registration - SDT19DM-36
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form with valid data
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The user should see success message
    And The user clicks continue on success popup

  Scenario: Verify error message when First Name field is left empty - SDT19DM-40
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without First Name
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "First Name must be between 1 and 32 characters!" should be displayed

  Scenario: Verify error message when Last Name field is empty - SDT19DM-41
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without Last Name
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Last Name must be between 1 and 32 characters!" should be displayed

  Scenario: Verify error message when Email field is left empty - SDT19DM-42
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without Email
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "E-Mail Address does not appear to be valid!" should be displayed

  Scenario: Verify error message when Telephone field is left empty - SDT19DM-44
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without Telephone
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Telephone must be between 3 and 32 characters!" should be displayed

  Scenario: Verify error message when Password field is left empty - SDT19DM-45
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without Password
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Password must be between 4 and 20 characters!" should be displayed

  Scenario: Verify error message when Password Confirm field is left empty - SDT19DM-48
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without Password Confirm
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Password confirmation does not match password!" should be displayed

  Scenario: Verify that user cannot register without agreeing to Privacy Policy - SDT19DM-52
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form with valid data
    And The user selects subscription as "No"
    And The user does not agree to Privacy Policy
    And The user clicks Continue button
    Then The warning message "Warning: You must agree to the Privacy Policy!" should be displayed

  Scenario: Verify error messages for Last Name and Email fields when left empty - SDT19DM-74
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without Last Name and Email
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Last Name must be between 1 and 32 characters!" should be displayed
    And The error message "E-Mail Address does not appear to be valid!" should be displayed

  Scenario: Verify error messages for Telephone and Password fields when left empty - SDT19DM-75
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without Telephone and Password
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "Telephone must be between 3 and 32 characters!" should be displayed
    And The error message "Password must be between 4 and 20 characters!" should be displayed
  @wipYasemin
  Scenario: Verify error messages for First Name, Last Name and Telephone fields when left empty -SDT19DM-76
    Given User is on the main login page and logs in
    And Navigates to My Account -> Register
    When The user fills the registration form without First Name, Last Name and Telephone
    And The user selects subscription as "No"
    And The user agrees to Privacy Policy
    And The user clicks Continue button
    Then The error message "First Name must be between 1 and 32 characters!" should be displayed
    And The error message "Last Name must be between 1 and 32 characters!" should be displayed
    And The error message "Telephone must be between 3 and 32 characters!" should be displayed