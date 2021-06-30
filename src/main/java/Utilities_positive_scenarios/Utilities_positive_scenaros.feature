Feature: User should be able to click on the Utilities tab and able to use all the services under Utilities

Scenario: Validate that the user is able to navigate to Utilities screen
    When User is on home page
    Then User should redirect to Utilities Dashboard when clicks on Utilities tab
    
Scenario: Validate that user can click options provided in the left side navigator
    Then User should able to click on left side navigator options
    
Scenario: Validate that user can check the Tiles in the Utilities dashboard
    Then User should able to click all tiles in utilities dashboard
       
Scenario: Validate that user is able to add card details  in the Wallet dashboard
    Then User should able to add card details 
    
Scenario: Validate that user is able to add bank details  in the Wallet dashboard
    Then User should able to add bank details
    
Scenario: Validate that user is able to redeem points  in the Award points dashboard
    Then User is able to redeem points







   