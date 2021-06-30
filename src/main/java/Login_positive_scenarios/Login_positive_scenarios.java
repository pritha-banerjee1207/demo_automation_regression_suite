package Login_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_positive_scenarios extends Generic_function {
public static boolean value;
    
	@Given("browser is open")
	/*Browser launch*/
	public static void browser_launching() throws Exception  {
		   try {
				   Browser_Launch();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	@Then("check  the  Phone number  field is prefixed with country code")
	/*TC 001 - Validate that the'Phone number' field is prefixed with '+1' country code*/
	public static void login_positive_tc_001() throws IOException   {
		try {
			click("welcome_login");
			browser_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "plus_one"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_001");
		}
     }

	@Given("User click on Forgot password")
	/*TC 002 - Validate that the user is able to click on the 'Forgot password?' link*/
	public static void login_positive_tc_002() throws IOException  {
//		try {
//			click("forgot_password_link");
//			browser_wait(12);
//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "forgot_password_title"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			} catch (IOException e) {
//				e.printStackTrace();
//				takeScreenShot("login_positive_tc_002");
//		}
	}

	@Given("User click on Sign up")
	/*TC 003 - Validate that the user is able click on the 'Sign up' link*/
	public static void login_positive_tc_003() throws IOException  {
//       try {
//			driver.navigate().back();
//			click("sign_up_link");
//			browser_wait(12);
//			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_first_name"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			}  catch (IOException e) {
//				e.printStackTrace();
//				takeScreenShot("login_positive_tc_003");
//		}
	}

	@Given("User enter  the Password")
	/*TC 004 -  Validate that the user is able to enter  the Password in the Password field*/
	public static void login_positive_tc_004() throws IOException {
		try {
//			driver.navigate().back();
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",5));
			} catch (IOException e) {
				e.printStackTrace();
				takeScreenShot("login_positive_tc_004");
		}
	}

	@When("User enters valid phonenumber and password and User click on login")
	/*TC 005 - Validate that the user is able to Login with valid data*/
	public static void login_positive_tc_005() throws IOException  {
		try {
			browser_refresh();
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",6));
			click("login");
			browser_wait(12);		
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_005");	
		}
	}

	@Given("User click on Logout")
	/*TC 006 - Validate that the user is navigated to 'Landing page' on clicking the 'Log out' option*/
	public static void login_positive_tc_006() throws IOException {
		try {
			click("logout");
			browser_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("login positive");
			browser_close();
		} catch (IOException e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_006");	
		}
		}
}
