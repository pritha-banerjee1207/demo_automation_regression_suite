package Award_points_positive_scenarios;

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

public class Award_points_positive_scenarios extends Generic_function{
	public static boolean value;
	static WebElement ele;
	String ere;
	public static WebElement fr;
	static String str,text;
	static List<WebElement> grid_elements,drp_list;

	@Given("Browser is open")
	public static void browser_is_open() {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Validate that the user is navigated to Welcome page*/
	@And("User clicks on Welcome Login button")
	public static void Award_point_positive_welcome() throws IOException {
		try {
			click("welcome_login");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_welcome()");
		}
	}

	/*TC 001 - Validate that the user is able to navigated to Utilities screen */
	@When("User should click on Utilities tab and navigated to Utilities Dashboard")
	public static void Award_point_positive_tc_001() throws IOException{
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",11));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",8));
			click("login");
			browser_wait(12);
			click("utilities");
			browser_wait(20);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_001()");
		}
	}

	/*TC 002 - Validate that user can click the Tile "Award Points"in the Utilities dashboard*/
	@When("User should be able to click on Award point tile and to Award points page successfully")
	public static void Award_point_positive_tc_002()throws InterruptedException, IOException {
		try {
			click("award_points");
			browser_wait(20);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "award_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "award_point_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "your_award_point_history"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			takeScreenShot("Award_point_positive_tc_002()");
		}	
		Thread.sleep(2000);
	}

	/*TC 003 - Validate that user is able to redeem points  in the Award points dashboard.*/
	@When("User should be able to click on the Redeem Points button and navigated to redeem award points page")
	public static void Award_point_positive_tc_003() throws IOException {
		try {
			click("awardpoints_redeem_button");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "redeem_award_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			Thread.sleep(1000);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "available_award_point"))).isDisplayed();
			Assert.assertEquals(true,value);
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
			ele.sendKeys(td_reader("redeem_points_amount",0));
			Thread.sleep(6000);
			click("redeem_points_email");
			//  			click("redeem_points");
			Thread.sleep(6000);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_003()");
		}
	}

	/*TC 004 - Validate that the user is able to navigate to the 'redeemed' page */
	@When("User should be able to navigated to the redeemed page successfully")
	public static void Award_point_positive_tc_004() throws IOException {
		try {
			//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "redeemed_title"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//		        browser_wait(20);
			//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "redeemed_points"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "availed_gift"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			click("goto_dashboard_button");
			//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "your_award_point_history"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			Thread.sleep(5000);
			System.out.println("Award points positive");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_004()");
		}
	}
}
