package Services_positive_scenario;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Services_positive_scenario extends Generic_function {
	static boolean value;
	
	/*Browser opens and enter URL*/ 	
	@Given("Browser is open and User clicks on the login button and navigated to the login page")
	public void services_page_positive_tc_001() throws IOException {
		try {
			   Browser_Launch();
			   click("welcome_login");
			      driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
		          driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",7));
				  click("login");
				  browser_wait(5);
				  value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logout"))).isDisplayed();
				  Assert.assertEquals(true,value);
			} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("servicepage_positive_tc_001");
		}
	}
	
	/*  Validate that the user is able to click on the Services tab */	
	@When("User clicks on the Services tab and is navigated to the Services pages")
	public static void services_page_positive_tc_002() throws IOException{
			try {
				click("services");
				value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logout"))).isDisplayed();
				  Assert.assertEquals(true,value);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				takeScreenShot("servicepage_positive_tc_002");
			}
	}
	
	/* Validate that the user is able to click on the grid tiles*/
	@When("User should be able to click on all the grid tiles")
	public void services_page_positive_tc_003() throws IOException {
		try {
			grid_tile(OR_reader("Object_Locator", "grid_path")); 
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logout"))).isDisplayed();
			  Assert.assertEquals(true,value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot("servicepage_positive_tc_003");
		}
		System.out.println("services positive");
		browser_close();
	}
		}