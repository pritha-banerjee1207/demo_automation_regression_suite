package Forgot_password_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class Forgot_password_positive_scenarios extends Generic_function {
	static String str;

	/* Browser  is launching , navigating to Landing Welcome Page  */
	@Given("Browser is open")
	public static void browser_open() throws Exception {
		try{		
			Browser_Launch();
		}catch (Exception e) {
			e.printStackTrace();
		}	 
	}	

	/* TC_001 -Validate that the  user should  able to enter 10 digit number in "Phone Number" field*/
	@Then("Click on Login button then click on Forgot Password link and enter phone number in Phone number field")
	public static void forgot_positive_tc_001() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","welcome_login"))).click();	
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_link"))).click();		
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",3));
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_page_title"))).getText();
			Assert.assertEquals(str,td_reader("forgot_password_page_title"));
			browser_wait(12);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_positive_tc_001");
		}
	}

	/* TC_002 -Validate that the user should able to click on the  Send Reset Link button on entering valid phone number in Phone number field*/
	@Given("Verify that Send Reset Link button gets enabled and user can click on it")
	public static void forgot_positive_tc_002() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",3));
			driver.findElement(By.xpath(OR_reader("Object_Locator","send_reset_link"))).click();
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_page_title"))).getText();
			Assert.assertEquals(str,td_reader("forgot_password_page_title"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_positive_tc_002");
		}
	}

	/* TC_003 -Validate that the user is navigated to sign up page on clicking Sign up link*/
	@Given("Click on Sign up link then should be navigated  to  Sign up page")
	public static void forgot_positive_tc_003() throws Exception{
		try {
			browser_back();
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_signup_link"))).click();			
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","signup_page_title"))).getText();
			Assert.assertEquals(str,td_reader("signup_page_title"));
			System.out.println("forgot positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_positive_tc_003");
		}		
	}
}
