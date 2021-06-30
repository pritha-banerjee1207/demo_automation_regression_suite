Feature: User should be able to use  Request a Second Opinion functionality

Scenario: Validate that user must be able to view Request for a second opinion under Home page
    When User is on home page
    Then User should redirect to Request a Second Opinion page when clicking on Request a Second Opinion button
    
Scenario: Validate that user must be able to view the texts on the landing page
    Then User should be able to view texts on the page
    
Scenario: Validate that user can able to view  box  with  additional information at the bottom of page
    Then User should be able to view the informations
    
Scenario: Validate that the user should navigated to Upload Scans page when Proceed button is clicked
    Then User should be navigated to Upload Scans page by clicking proceed button
    
Scenario: Validate that user should be able to view the bar with Upload Scans as green color at the top of the page and links are working or not
    Then User should be able to view the bar and links
   
Scenario: Validate that the user should be able to upload scans by clicking on Upload my scans button
    Then User should be able to upload folder from the system
   
Scenario: Validate that the user should be able to view the dialogue box when I do not have a doctor's report checkbox
    Then User should be able to view the Upload scans page
    
Scenario: Validate that the user should be able to upload reports by clicking on Upload my reports button
    Then User should be able to upload file from the system
    
Scenario: Validate that the user should navigated to Upload Scans page by checking Other check box and by entering details
    Then User should be navigated to upload scans page