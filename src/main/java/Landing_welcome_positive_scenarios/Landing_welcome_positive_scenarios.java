package Landing_welcome_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_welcome_positive_scenarios extends Generic_function {
	static boolean value;
    static int s;
	
	/*Browser opens and enter URL*/
	@Given("User opens browser and provide URL")
	public static void browser_launching() throws IOException, InterruptedException {
		Browser_Launch();
		s= Dataiter();
	}
	
	/*TC_001 Verify that user is navigated to the Welcome page */
	@Then("User should be navigated to Welcome page")
	public static void landing_welcome_positive_tc_001() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_001");
		}
	}
	
	/*TC_002 Validate that the  user is able to click on 'Login' button and navigated to login page*/
	@When("User clicks on the Login button and navigate to Login page")
	public static void landing_welcome_positive_tc_002() throws IOException {
		try {
			click("welcome_login");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_002");
		}
	}

	/*TC_003 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page*/
	@When("User clicks on Sign up button and navigate to Sign up page")
	public static void landing_welcome_positive_tc_003() throws IOException {
		try {
			driver.navigate().to(getURL());
			click("welcome_signup");
			browser_wait(12);	
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "signup_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("landing positive");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_003");
		}
	}
}
