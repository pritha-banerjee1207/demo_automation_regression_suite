package Utilities_negative_scenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_negative_scenarios  extends Generic_function{
	static boolean value;
	static String balance,text,ere,str;
	static WebElement ele;
	
	/*Browser opens and user is on home page */ 	
	@When("User is on home page")
	public void user_is_on_home_page() {
		try {
			Browser_Launch();
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",10));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",10));
			click("login");
			browser_wait(40);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/* TC_001 -Validate that the user is able to navigate to Utilities screen */
	@Then("User should redirect to Utilities Dashboard when clicks on Utilities tab")
	public static void utilities_negative_tc_001() throws Exception {
		try {
			click("utilities");
			browser_wait(20);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
			}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_001");
		}	
	}
	
	/* TC_002 -Validate that user gets validation message on leaving fields blank in the Add Card page */
	@Then("User should get validation message on leaving fields blank")
	public void utilities_negative_tc_002() throws IOException {
		try{
			click("wallet");
			browser_wait(30);
			click_javascript("utilities_add_card");
			browser_wait(10);
			click("utilities_save_button");
			browser_wait(30);
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_save_as_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_save_as_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_name_on_card_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_name_on_card_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_zip_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_zip_code_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_phone_number_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_phone_number_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_address_valid_msg"))).getText(); 
			Assert.assertEquals(str,td_reader("utilities_address_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_country_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_country_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_state_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_state_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_city_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_city_valid_msg"));
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_002");
		}	
	}
	
	/* TC_003 -Validate that user gets validation message on entering invalid details in the Add Card page*/
	@Then("User should get validation message on entering invalid details")
	public static void utilities_negative_tc_003() throws Exception {
		try {
			browser_wait(2);
			click_javascript("utilities");
			click_javascript("wallet");
			browser_wait(30);
			click_javascript("utilities_add_card");
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_save_as"))).sendKeys(td_reader("utilities_save_as"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_name_on_card"))).sendKeys(td_reader("utilities_name_on_card"));
			Thread.sleep(1000);
			Robot robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_NUMPAD4);
				robot.keyPress(KeyEvent.VK_NUMPAD2);
				robot.keyPress(KeyEvent.VK_NUMPAD4);
				robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_BACK_SLASH);
			robot.keyPress(KeyEvent.VK_TAB); 
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_zip_code"))).sendKeys(td_reader("utilities_zip_code",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_phone_number"))).sendKeys(td_reader("utilities_phone_number",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_address"))).sendKeys(td_reader("utilities_address")); 			
			browser_wait(30);
			click_javascript("utilities_save_button");
		}catch (Exception e) {
			takeScreenShot("utilities_negative_tc_003");
		}	
	}
	
	/*TC_004- Validate that user gets validation message on leaving fields blank in the Add Bank page */
	@Then("User should get validation message on leaving fields blank in Add Bank page")
	public static void utilities_negative_tc_004() throws Exception {
		try {
			browser_wait(20);	
			click_javascript("utilities");
			click_javascript("wallet");
			browser_wait(30);
			click_javascript("utilities_add_bank");
			click("utilities_bank_saveas");
			click("utilities_account_name");
			click("utilities_routing_no");
			click("utilities_account_number");
			click("utilities_routing_no");	
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_save_as_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_save_as_valid_msg"));  
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_account_holder_name_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_holder_name_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_routing_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_routing_no_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_account_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_no_valid_msg"));  
	}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_004");
		}	
	}
	
	/* TC_005 - Validate that user gets validation message on entering invalid details in the Add Bank page*/
	@Then("User should get validation message on entering invalid details in Add Bank page")
	public static void utilities_negative_tc_005() throws Exception {
		try {
			browser_wait(20);	
			click_javascript("utilities");
			click_javascript("wallet");
			click_javascript("utilities_add_bank");
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas"));
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_account_name"))).sendKeys(td_reader("utilities_account_name",1));
			browser_wait(10);
			click("utilities_routing_no");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_account_holder_name_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_holder_name_invalid_msg"));  
			browser_wait(5);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_routing_no"))).sendKeys(td_reader("utilities_routing_no",1));
			click("utilities_account_type");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_routing_no_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_routing_no_invalid_msg"));  
			text = td_reader("utilities_account_type");
			drop_down(OR_reader("Object_Locator", "utilities_account_type_list"),text);  
			browser_wait(2);
			driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_account_number"))).sendKeys(td_reader("utilities_account_number",1));
			browser_wait(2);
			click("utilities_routing_no");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","utilities_bank_account_no_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_no_invalid_msg"));  
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_005");
		}	
	}

	/* TC_006 - Validate that user is not able to redeem when the balance is less than 2000 */
	@Then ("User is not able to click on redeem")
	public static void utilities_positive_tc_006() throws Exception{
		try {
			click_javascript("utilities");
			browser_wait(20);
			click_javascript("award_points");
			browser_wait(20);
			value=driver.findElement(By.xpath(OR_reader("Object_Locator", "awardpoints_redeem_button"))).isEnabled();
			if(value==true) {
				Thread.sleep(1000);
				click("awardpoints_redeem_button");				
	}
			else
			{
				browser_back();
			}
			System.out.println("Utilities negative");
			browser_close();
		}catch (Exception e) {
			takeScreenShot("utilities_negative_tc_006");
		}	
	}
		

	
}