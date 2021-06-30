Feature: Test Your profile positive functionality

  Scenario: Validate that the  Your Profile  title  should be present in  Your Profile screen
    Given browser is open
    Then check Your Profile  title  should be present in  Your Profile screen

  Scenario: Validate that dialogue box will appear and able to enter the security code and password , when user click on edit icon
    When User click on edit icon a dialogue box will appear

  Scenario: Validate that the user is able to edit  the profile details
    Then User is able to edit  the profile details

  Scenario: Validate that user is able to add Email ID in contact details
    And User is able to add Email ID in contact details

  Scenario: Validate that the user is able to Activate , Edit and  Deactivate the Email ID
    When User is able to Activate , Edit and  Deactivate the Email ID

  Scenario: Validate that user is able to add Phone Number in contact details.
    Then User is able to add Phone Number in contact details

  Scenario: Validate that the user is able to Activate , Edit and  Deactivate the Phone Number
    Then User is able to Activate , Edit and  Deactivate the Phone Number

  Scenario: Validate that user is able to add Address in contact details.
    Then User is able to add Address in contact details.

  Scenario: Validate that the user is able to Activate , Edit , Primary and  Deactivate the Address
    Then User is able to Activate , Edit , Primary and  Deactivate the Address

  Scenario: Validate that user is able to add Plan coverage
    Then User is able to add Plan coverage

  Scenario: Validate that the user is able to Activate , Edit , Make primary and  Deactivate the Plan coverage
    Then User is able to Activate , Edit , Make primary and  Deactivate the Plan coverage

  Scenario: Validate that the user is able to change the password
    Then User is able to change the password

  Scenario: Validate that the password should be displayed on clicking the eye and user can able to save the details
    Then The password should be displayed on clicking the eye and  user can able to save the details