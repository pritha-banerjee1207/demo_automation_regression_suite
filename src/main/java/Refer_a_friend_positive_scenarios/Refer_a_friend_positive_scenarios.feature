Feature: Test refer a friend positive functionality

Scenario:  Validate that user must be able to view Refer a Friend under Home page
  Given  Browser is open
  Then  Tell your friends about Mpowered Health text should be present on the page and also logo should be present
  
Scenario: Validate that user must be able to click on Refer a Friend button displayed in the home page
  Given Click on Refer a Friend Verify that the user should navigated to Refer a Friend landing page and Page title should be Refer a friend

Scenario: Validate that user must be able to view the referral code text
   Given Referal code text is visible near Your referal code
   
Scenario: Validate that the user should able to see a Pop Up box when clicking on Share a link
   Given   User can able to click on Share Link button and can able to see a pop up box is displaying
   
Scenario: Validate that the user should able to copy the link
   When Click on copy the link
   
Scenario: Validate that user can view How its works
   Given  How it work text should be visible
   
Scenario: Validate that user can view the text Invite your friends to Mpowered Health by sharing your unique invitation code
   When First grid contains the text Invite your friends to Mpowered Health by sharing your unique invitation code
   
Scenario: Validate that user can able to slide the two grids visible under How its works
   When User can able to slide the gird to view the second grid
   
Scenario: Validate that user can able to click on the link More information & FAQ and it will navigated to Frequently asked questions page
  Given Click on the link More information & FAQ and it will redirected to Frequently asked questions page
  
Scenario: Validate that the user should able to view list of frequently asked questions inside Frequently asked questions page
   Given User should able to view list of Frequently asked questions