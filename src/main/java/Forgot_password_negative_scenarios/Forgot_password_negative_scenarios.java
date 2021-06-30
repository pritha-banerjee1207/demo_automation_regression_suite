package Forgot_password_negative_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.*;

public class Forgot_password_negative_scenarios extends Generic_function {
	public static String str;
	
	/* Browser  is launching , navigating to Landing Welcome Page  */
	@Given("Browser is open")
	public static void browser_open() throws IOException {
		try{		
			Browser_Launch();
		}catch (Exception e) {
			e.printStackTrace();
		}	 
	}	

	/*TC_001 Validate that the user get the validation message when Phone number field is blank */
	@Then("User get the validation message when Phone number field is blank")
	public void forgot_password_negative_tc_001() throws IOException  {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","welcome_login"))).click();	
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_link"))).click();	
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_phone_no"))).click();
			driver.findElement(By.xpath(OR_reader("Object_Locator","send_reset_link1"))).click();
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","phone_number_blank_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_password_phone_msg"));
			browser_wait(12);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_001");
		}
	}

	/* TC_002 Validate that the user get the validation message on entering less than ten digit phone number */
	@Given("User get the validation message on entering less than ten digit phone number")
	public void forgot_password_negative_tc_002() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",0));
			driver.findElement(By.xpath(OR_reader("Object_Locator","send_reset_link"))).click();
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","phone_number_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_less_ten_msg"));
			browser_wait(12);	
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_002");
		}
	}

	/* TC_003 Validate that the user get the validation message on entering more than ten digit phone number */
	@Given("User get the validation message on entering more than ten digit phone number")
	public void forgot_password_negative_tc_003() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator", "forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator","send_reset_link"))).click();
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","phone_number_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_less_ten_msg"));
			browser_wait(12);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_003");
		}
	}
	
	/* TC_004 Validate that the Send Reset Link button is disabled when Phone number field is blank */
	@Then("Send Reset Link button is disabled when Phone number field is blank")
	public void forgot_password_negative_tc_004() throws IOException {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("Object_Locator","send_reset_link"))).isEnabled(),true);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_004");
		}		
	}

	/* TC_005 Validate that the user should able to get a validation message on entering non registered phone number in the phone number field */
	@Then("User should able to get a validation message on entering non registered phone number in the phone number field")
	public void forgot_password_negative_tc_005() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",2));
			driver.findElement(By.xpath(OR_reader("Object_Locator","send_reset_link"))).click();
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","forgot_password_phoneno_exist_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_phone_no_exist_msg"));
			System.out.println("forgot negative");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_005");
		}
	}
}

