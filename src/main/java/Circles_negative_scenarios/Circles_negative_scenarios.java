package Circles_negative_scenarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Circles_negative_scenarios extends Generic_function{
	public static boolean value;
	public static String str;
	
	/*Browser launch*/
	@Given("browser is open")
	public void browser_launching() throws Exception {
		try {
			browser_launch();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("browser launching");
		}
	}

	/*TC 001 - Validate that Proceed button is disabled when they do not select a provider from the drop down*/
	@When("Click drop down list and do not make a selection and proceed then user should not be able to proceed to next page")
	public void circle_positive_tc_001() throws Exception {
		try {
			click("welcome_login");
			browser_wait(12);
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			browser_wait(20);
			click("circles");
			browser_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circles_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(12);
			click("circles_add_patner_button");
			browser_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "add_patner_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("Object_Locator","add_patner_proceed_button"))).isEnabled(),true);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_negative_tc_001");
		}
	}

	/*TC 002 - Validate that the user is not allowed to login when Username and Password fields are blank*/
	@Given("User will get a validation message when leaving Username and password")
	public void circle_positive_tc_002() throws Exception {
		try {
			browser_handle();
			click("mymed_username");
			click("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_username_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_username_valid_msg"));
			click("mymed_login");
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_password_valid_msg"));
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_negative_tc_002");
		}	
	}

	/*TC 003 - Validate that the user should get a validation message on entering invalid Username  and Password in the Login Page*/
	@Given("Enter incorrect data in the  Username and Password field and verify that the user is getting the validation message")
	public void circle_positive_tc_003() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_username"))).sendKeys(td_reader("mymed_username",0));
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_password"))).sendKeys(td_reader("mymed_password",0));
			click("mymed_login");
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_negative_tc_003");
		}	
	}

	/*TC 004 - Validate that the user is not allowed leaves blank Username field*/
	@Given("User will get validation message when Username field is blank")
	public void circle_positive_tc_004() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_password"))).sendKeys(td_reader("mymed_password",0));
			click("mymed_login");
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_negative_tc_004");
		}	
	}

	/*TC 005 - Validate that the user is not allowed leaves blank Password field*/
	@Given("User will get validation message when Password field is blank")
	public void circle_positive_tc_005() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_username"))).sendKeys(td_reader("mymed_username",0));
			click("mymed_login");
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_negative_tc_005");
		}	
	}

	/*TC 006 - Validate that the user is not allowed to login with valid Usename and invalid Password*/
	@Given("User will get a validation message when login with valid Usename and invalid Password")
	public void circle_positive_tc_006() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_username"))).sendKeys(td_reader("mymed_username",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_password"))).sendKeys(td_reader("mymed_password",0));
			click("mymed_login");
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_negative_tc_006");
		}	
	}

	/*TC 007 - Validate that the user is not allowed to login with invalid Usename and valid Password */
	@Given("User will get a validation message when login with invalid Usename and valid Password")
	public void circle_positive_tc_007() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_username"))).sendKeys(td_reader("mymed_username",0));
			driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_password"))).sendKeys(td_reader("mymed_password",1));
			click("mymed_login");
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
			browser_close();
			browser_switch();
			System.out.println("Circles negative");
			browser_close();
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_negative_tc_007");
		}	
	}
}
