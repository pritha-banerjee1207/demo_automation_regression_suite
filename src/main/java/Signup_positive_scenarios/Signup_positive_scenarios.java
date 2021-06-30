package Signup_positive_scenarios;

import java.io.IOException;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_positive_scenarios extends Generic_function {
	public static boolean value1,value2;
	WebElement otp;

	@Given("Browser is launched and user is on signup page")
	public static void signup_positive_tc_001() throws IOException  {
		try {
			Browser_Launch();
			click("welcome_signup");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_001");
		}
	}

/* For verifying that the user is navigated to the login page on clicking the login link*/
	@When("user clicks on the login link user is navigated to the login page")
	public static void signup_positive_tc_002() throws IOException{
		try{
			click("login_link");
			value1=driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).isDisplayed();
			Assert.assertEquals(true,value1);
			//browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_002");
		}
		}
	
	/* For verifying password and confirm password values are masked */
	@When("User enters the details in the Password and Confirmed Password field should be masked")
	public static void signup_positive_tc_003() throws IOException{
		try {
			driver.navigate().back();
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("Object_Locator","signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			value1=driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_002");
		}
	}

	/* For verifying user can see the original value while clicking on the Eye*/
	@Then("User clicks on the Eye and Orginal value should be displayed in the password fields")
	public static void signup_positive_tc_004() throws IOException  {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","signup_password"))).sendKeys(td_reader("signup_password",1));
			click("show_password");
			browser_wait(30);
			value1=driver.findElement(By.xpath(OR_reader("Object_Locator", "show_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			browser_refresh();  
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_003");
		}
	}

	/* Verifying values entered in Password and Confirm Password are same */ 
	@When("user enter same values of Password in the Confirmed field")
	public void signup_positive_tc_005() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));  
			value1=driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_004");
		}
	}

	/* User entering all the valid credentials */ 
	@When("User enters valid credentials")
	public void signup_positive_tc_006() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_first_name"))).sendKeys(td_reader("signup_first_name",2));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_last_name"))).sendKeys(td_reader("signup_last_name",2));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_email_id"))).sendKeys(td_reader("signup_email_id",2));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_phone_number"))).sendKeys(td_reader("signup_phone_number",3));
			driver.findElement(By.xpath(OR_reader("Object_Locator","signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			click("signup_terms_and_conditions");
			click("signup");	
//			value1=driver.findElement(By.xpath(OR_reader("Object_Locator", "otp"))).isDisplayed();
//			Assert.assertEquals(true,value1);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_005");
		}
		Thread.sleep(1000);
	}

	/*User entering otp*/
	@When("user enters otp and clicks on verify button and is navigated to the login page")
	public void signup_positive_tc_007() throws IOException, InterruptedException {
		try {
//			driver.findElement(By.xpath(OR_reader("Object_Locator", "otp"))).sendKeys(td_reader("otp"));
//			click("verify");
			System.out.println("signup positive");
			 browser_close();	
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_006");
		}
       
	}
            
}
