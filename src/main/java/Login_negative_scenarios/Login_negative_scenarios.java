package Login_negative_scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_negative_scenarios extends Generic_function {
	public static String str1,str2="";
	public static String valid_msg="";


	@Given("Browser is open")
	public static void browser_launching() throws Exception {
		Browser_Launch();
		click("welcome_login");
	}

	/*TC_001 - Validate that the user is not allowed to login when 'Phone number' and 'Password' fields are blank*/
	@And("User clicks on Login button")
	public static void login_negative_tc_001() throws IOException {
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			click("login");
			browser_wait(20);
			str1= driver.findElement(By.xpath(OR_reader("Object_Locator","login_validate_msg"))).getAttribute("oninvalid");
			valid_msg=str1.substring(24,49);
			Assert.assertEquals(valid_msg,Generic_function.td_reader("login_validate_msg",0));
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_001");
		}
	}

	/*TC_002 - Validate that the user should get a validation message on entering invalid credentials in the 'Login' Page*/
	@When("user enter invalid phone no and password")
	public void login_negative_tc_002() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",0));
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_password"))).sendKeys(Generic_function.td_reader("login_password",0));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_002");
		}
	}

	/*TC_003 - Validate that user is not allowed to enter more than 10 digits in the 'Phone number' field */
	@When("User enters phone number with more than ten digits")
	public void login_negative_tc_003() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",1));
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_password"))).sendKeys(Generic_function.td_reader("login_password",1));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_003");
		}
	}

	/*TC_004 Validation messages should be displayed when user enters invalid details  */
	@Then("validation messages should be displayed")
	public static void login_negative_validation_msg() throws IOException {
		try {
			browser_refresh();
			str1= driver.findElement(By.xpath(OR_reader("Object_Locator","login_negative_validate_msg"))).getText();
			Assert.assertEquals(str1.substring(2),td_reader("login_negative_validate_msg"));
			if(end_case=="True"||end_case=="False") {
				browser_close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_validation_msg");
		}
	}

	/*TC_005 - Validate that the user is not allowed to login with invalid 'Phone number' and valid 'Password' */
	@When("user enters invalid Phone number and valid Password")
	public static void login_negative_tc_005() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",2));
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_password"))).sendKeys(Generic_function.td_reader("login_password",2));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_005");
		}
	}

	/*TC_006 - Validate that the user is not allowed to login with invalid Password and valid phone number */
	@When("user enters invalid Password and valid phone number")
	public static void login_negative_tc_006() throws InterruptedException, IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",3));
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_password"))).sendKeys(Generic_function.td_reader("login_password",3));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_006");
		}
	}

	/*TC_007 - Validate that user is not able to login on leaving 'Phone number' field blank and only giving valid 'Password' */
	@When("user leaves Phone number field blank")
	public static void login_negative_tc_007() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_password"))).sendKeys(Generic_function.td_reader("login_password",4));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_007");
		}
	}

	public static String end_case="";
	/*TC_008 - Validate that user is not able to login on leaving 'Password' field blank and only giving valid 'Phone number' */
	@When("user leaves Password field blank")
	public static void login_negative_tc_008() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",4));
			click("login");
			end_case="True";
			System.out.println("login negative");
		}catch(Exception e) {
			e.printStackTrace();
			end_case="False";
			takeScreenShot("signup_negative_tc_008");
		}
	}
}