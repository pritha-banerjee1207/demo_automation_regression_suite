Feature: User should be able to click on the Services tab and  navigates to Services page

  Scenario: Validate that the user is able to login with valid credentials
    Given Browser is open and User clicks on the login button and navigated to the login page
    
  Scenario: Validate that the user is able to click on the Second Opinion tab
    When User should be able to click on the second opinion tab
    
    Scenario: Validate that the user is able to click on Resume Cases and is navigated to uplaod scans page
    Then User clicks on Resume Cases
    
   Scenario: Validate that user should be able to view the bar with Upload Scans as green color at the top of the page and links are working or not
    Then User should be able to view the bar and links
    
    Scenario: Validate that the user should be able to upload scans by clicking on Upload my scans button
    Then User should be able to upload folder from the system
    
    Scenario: Validate that the user should be able to view the dialogue box when I do not have a doctor's report checkbox
    Then User should be able to view the Upload scans page
    
    Scenario: Validate that the user should be able to upload reports by clicking on Upload my reports button
    Then User should be able to upload file from the system
    
    Scenario: Validate that User is able to click on Requested tab
    Then User clicks on the Requested tab
    
    Scenario: Validate that User is able to click on Reviewed tag
    Then User clicks on the Reviewed tag