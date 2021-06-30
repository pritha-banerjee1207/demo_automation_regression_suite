package Refer_a_friend_positive_scenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Refer_a_friend_positive_scenarios extends Generic_function{
	public static boolean value;
	public static WebElement from,to;
	
	/*Browser launch*/
	@Given("Browser is open")	
	public  void browser_launching() throws Exception  {
		try {
			Browser_Launch();
			browser_wait(12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*TC 001 - Validate that user must be able to view Refer a Friend under Home page*/
	@Then("Tell your friends about Mpowered Health text should be present on the page and also logo should be present")
	public static void login_positive_tc_001() throws Exception   {
		try {
			click("welcome_login");
			browser_wait(12);
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			browser_wait(20);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "refer_a_frnd_home_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "refer_a_frnd_home_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_001");
		}
	}
	
	/*TC 002 - Validate that user must be able to click on Refer a Friend button displayed in the home page*/
	@Given("Click on Refer a Friend Verify that the user should navigated to Refer a Friend landing page and Page title should be Refer a friend")
	public static void login_positive_tc_002() throws Exception   {
		try {
			click("refer_a_frnd_home_button");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "refer_a_frnd_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_002");
		}
	}
	
	/*TC 003 - Validate that user must be able to view the referral code text*/
	@Given("Referal code text is visible near Your referal code")
	public static void login_positive_tc_003() throws Exception   {
		try {
			browser_wait(10);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "refer_a_frnd_referral_code"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_003");
		}
	}
	
	/*TC 004 - Validate that the user should able to see a Pop Up box when clicking on Share a link */
	@Given("User can able to click on Share Link button and can able to see a pop up box is displaying")
	public static void login_positive_tc_004() throws Exception{
		try {
			click("refer_a_frnd_share_link_button");	
			browser_wait(20);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_004");
		}
	}
	
	/*TC 005 - Validate that the user should able to copy the link */
	@When("Click on copy the link")
	public static void login_positive_tc_005() throws Exception   {
		try {
			 //Thread.sleep(1000);
			 Actions act = new Actions(driver);			  
			 act.sendKeys(Keys.TAB).build().perform();
			 act.sendKeys(Keys.TAB).build().perform();
			 act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_005");
		}
	}
	
	/*TC 006 - Validate that user can view How its works*/
	@Given("How it work text should be visible")
	public static void login_positive_tc_006() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "refer_a_frnd_howits_work"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_006");
		}
	}
	
	/*TC 007 -Validate that user can view the text Invite your friends to Mpowered Health by sharing your unique invitation code*/
	@When("First grid contains the text Invite your friends to Mpowered Health by sharing your unique invitation code")
	public static void first_grid_text_checker() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "refer_a_frnd_first_grid_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_007");
		}
	}
	
	/*TC 008 -Validate that user can able to slide the two grids visible under How its works*/
	@When("User can able to slide the gird to view the second grid")
	public static void grid_slideer() throws Exception   {
		try {
			from = driver.findElement(By.xpath(OR_reader("Object_locator", "refer_a_frnd_carousal_from")));
			to = driver.findElement(By.xpath(OR_reader("Object_locator", "refer_a_frnd_carousal_to")));
			Actions action = new Actions(driver);
			action.dragAndDrop(from, to).perform();
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "refer_a_frnd_carousal_from"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_007");
		}
	}
	
	/*TC 009 -  Validate that user can able to click on the link More information & FAQ and it will navigated to Frequently asked questions page*/
	@Given("Click on the link More information & FAQ and it will redirected to Frequently asked questions page")
	public static void login_positive_tc_007() throws Exception   {
		try {
			click("refer_a_frnd_faq_link");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_008");
		}
	}
	
	/*TC 010 - Validate that the user should able to view list of frequently asked questions inside Frequently asked questions page*/
	@Given("User should able to view list of Frequently asked questions")
	public static void login_positive_tc_008() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Refer a friend positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_frnd_positive_tc_009");
		}
	}
}