package Circles_positive_scenarios;

import Reusable_Functions.Generic_function;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Circles_positive_scenarios extends Generic_function  {
	public static boolean value;
	public static String str;
	
	/*Browser launch*/
	@Given("browser is open")
	public void browserlaunching() {
		try {
			browser_launch();
		} catch (Exception e) {
			 e.getMessage();
		}
	}
	
	/*TC 001 - Validate that a user is taken to the Circles page when they click on the Circles tab*/
	@Then("check user is taken to the Circles page when they click on the Circles tab")
	public void circle_positive_tc_001() throws IOException {
		try {
			click("welcome_login");
			browser_wait(12);
				driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
				driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password",7));
				click("login");
				browser_wait(20);
				click("circle_click");
				browser_wait(12);
				value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_header_assert"))).isDisplayed();
				Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_001");
		}
     }
	
	/*TC 002 - Validate that a user is able to click on Add a Partner and options pop up*/
	@Then("check  user is able to click on Add a Partner and options pop up")
	public void circle_positive_tc_002() throws IOException {
		try {
			browser_wait(12);
			click("circle_add_partner");
			browser_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_add_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
	    } catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_002");
		}
	}
	
	/*TC 003 - Validate that when a user clicks on Add a Provider option under Add a Partner drop-down, they are directed to the provider screen*/
	@Then("check  user is able to click on Add a Partner then click on Select a partner and select the My Medicare option finally click on Proceed")
	public void circle_positive_tc_003() throws IOException {
		try {
			browser_wait(20);
			click("circle_select_partner");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_mymedicare"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("circle_mymedicare");
			browser_wait(20);
			click("circle_proceed");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_continue"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("circle_continue");
			click("logout");
			}
		catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_003");
		}
	}
	/*TC 004 - Validate that the user is able to click on the 'Forgot username?' link*/
	@Then("check  user is able to click on the Forgot username? link")
	public void circle_positive_tc_004() throws IOException {
		try {
		browser_handle();
        value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_usernamelink"))).isDisplayed();
    	Assert.assertEquals(true,value);
    	click("circle_usernamelink");
    	value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_allfieldsnumber"))).isDisplayed();
    	Assert.assertEquals(true,value);
    	browser_back();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_004");
		}
	}
	/*TC 005 - Validate that the user is able to click on the 'Forgot password?' link*/
	@Then("check  user is able to click on the Forgot password? link")
	public void circle_positive_tc_005() throws IOException {
		try {
			browser_wait(12);
			click("circle_forgotpasswordlink");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_allfieldsnumber"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	browser_back();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_005");
		}
	    	}
	/*TC 006 - Validate that the user is able to enter  the Username and Password in the 'USERNAME' and 'PASSWORD' field*/
	@Then("check  user is able to enter  the Username and Password")
	public void circle_positive_tc_006() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_locator", "circle_username"))).sendKeys(td_reader("circle_user_name"));
			driver.findElement(By.xpath(OR_reader("Object_locator", "circle_password"))).sendKeys(td_reader("circle_password"));
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_006");
		}
	}
	/*TC 007 Validate that the password should be displayed on clicking the eye*/
	@Then("check  user is able to view password on clicking the eye")
	public void circle_positive_tc_007() throws IOException {
		try {
			click("circle_eye");
			str =driver.findElement(By.xpath(OR_reader("Object_locator", "circle_password"))).getAttribute("value");
			Assert.assertEquals(str,"PW27961!");
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_007");
		}
	}
	/*TC 008 Validate that the user is able to Login with valid data*/
	@Then("check  user is able to Login with valid data")
	public void circle_positive_tc_008() throws IOException {
		try {
			click("circle_login");
			browser_close();
	        browser_switch();
	        driverquit();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_008");
		} 
	}


	/*TC 012 - Validate that the user can able to view 'My Medicare’ icon in the Circles page and also it should be clickable */
	@Given("My Medicare logo should be present in the Circles page  and it should be clickable")
	public void circle_positive_tc_012() throws IOException  {
		try {
			Browser_Launch();
			click("welcome_login");
			browser_wait(12);
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",9));
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password",5));
			click("login");
			browser_wait(20);
			click("circle_click");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_mymedicareassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(12);
			click("circle_mymedicareassert");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "circle_mymedicareassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("logout");
			System.out.println("circles positive");
			driverquit();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("circle_positive_tc_012");
		}
		 
	}
}
