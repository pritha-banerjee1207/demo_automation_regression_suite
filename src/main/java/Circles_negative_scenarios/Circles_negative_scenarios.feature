Feature: Test Circle negative functionality

  Scenario: Validate that Proceed button is diabled when they do not select a provider from the drop down
    Given browser is open
    When Click drop down list and do not make a selection and proceed then user should not be able to proceed to next page
    
    Scenario: Validate that the user is not allowed to login when Username and Password fields are blank
    	Given User will get a validation message when leaving Username and password
    
    Scenario: Validate that the user should get a validation message on entering invalid Username  and Password in the Login Page
    	Given Enter incorrect data in the  Username and Password field and verify that the user is getting the validation message
    	
		Scenario: Validate that the user is not allowed leaves blank Username field
			Given User will get validation message when Username field is blank
		
		Scenario: Validate that the user is not allowed leaves blank Password field
			Given User will get validation message when Password field is blank
			
		Scenario: Validate that the user is not allowed to login with valid Usename and invalid Password
			Given User will get a validation message when login with valid Usename and invalid Password
			
		Scenario: Validate that the user is not allowed to login with invalid Usename and valid Password
			Given User will get a validation message when login with invalid Usename and valid Password