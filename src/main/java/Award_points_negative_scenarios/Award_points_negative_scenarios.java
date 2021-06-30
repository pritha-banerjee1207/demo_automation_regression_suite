package Award_points_negative_scenarios;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Award_points_negative_scenarios extends Generic_function{
	public static boolean value;
	static WebElement ele;
	String ere;
	public static WebElement fr;
	static String str,text;
	static List<WebElement> grid_elements,drp_list;

	@Given("Browser is open")
	public void browser_is_open() {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Validate that the user is navigated to Welcome page*/
	@And("User clicks on Welcome Login button")
	public static void user_clicks_on_welcome_login_button() throws IOException {
		try {
			click("welcome_login");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@When("User should click on Utilities tab and navigated to Utilities Dashboard")
	public static void user_should_click_on_utilities_tab_and_navigated_to_utilities_dashboard() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",9));
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password",5));
			click("login");
			browser_wait(12);
			click("utilities");
			browser_wait(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 001 - Validate that user gets validation message on entering amount more than the available amount in "Redeem Award Points" page */
	@When("User should get validation message on entering amount more than the available amount in the Enter Amount field")
	public static void Award_point_negative_tc_001() throws IOException, InterruptedException {
		try {
			click("award_points");
			Thread.sleep(6000);
			click("awardpoints_redeem_button");
			Thread.sleep(2000);
			click("redeem_points_giftcard");
			ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_giftcard")));
			ele.sendKeys(td_reader("redeem_points_giftcard"));
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "award_points_reedem"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("redeem_points_amount");
			ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_amount")));
			ele.sendKeys(Keys.BACK_SPACE);
			ele.sendKeys(td_reader("redeem_points_amount",1)); 
			click("redeem_points_email");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","amount_exceed_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("Amount exceeds range"));
			Thread.sleep(4000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_001");
		}	

	}

	/*TC 002 - Validate that user gets validation message on entering amount less than the available amount in "Redeem Award Points" page */
	@When("User should get validation message on entering amount less than the available amount in the Enter Amount field")
	public static void Award_point_negative_tc_002() throws IOException {
		try {
			browser_refresh();
			click("redeem_points_giftcard");
			ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_giftcard")));
			ele.sendKeys(td_reader("redeem_points_giftcard"));
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "award_points_reedem"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("redeem_points_amount");
			ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_amount")));
			ele.sendKeys(Keys.BACK_SPACE);
			ele.sendKeys(td_reader("redeem_points_amount",2));
			click("redeem_points_email");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_amount_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("redeem_points_amount_valid_msg"));   
			Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_002)");
		}
	}

	/*TC 003 -  Validate that user is not able to click on the 'Redeem' button on leaving the field 'Select a gift card' blank" */
	@When("User should get validation message clicking on the Redeem button on leaving the field Select a gift card blank")
	public static void Award_point_negative_tc_003() throws IOException, InterruptedException {
		try {
			browser_refresh();
			click("redeem_points_giftcard");
			value=driver.findElement(By.xpath(OR_reader("Object_Locator", "redeem_points"))).isEnabled();
			Assert.assertEquals(value,false);
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_003");
		}
	}

	/*TC 004 -  Validate that user is not able to click on the 'Redeem' button on leaving the field 'Enter Amount' blank on "Redeem Award Points" page */
	@When("User should get validation message clicking on the Redeem button on leaving the field Enter Amount blank")
	public static void Award_point_negative_tc_004() throws IOException{
		try {
			browser_refresh();
			click("redeem_points_giftcard");
			ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_giftcard")));
			ele.sendKeys(td_reader("redeem_points_giftcard"));
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "award_points_reedem"))).isDisplayed();
			Assert.assertEquals(true,value);
			ele=driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_amount")));
			ele.sendKeys(Keys.BACK_SPACE);
			click("redeem_points_email");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","redeem_points_amount_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("redeem_points_amount_valid_msg"));   
			Thread.sleep(1000);
			System.out.println("Award points negative");
			browser_close();
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_004");
		}		
	}
}
