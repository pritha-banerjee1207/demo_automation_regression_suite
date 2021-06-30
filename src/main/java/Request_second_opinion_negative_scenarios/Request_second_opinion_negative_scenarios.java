package Request_second_opinion_negative_scenarios;

import Reusable_Functions.Generic_function;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
public class Request_second_opinion_negative_scenarios extends Generic_function{
	public static boolean value;
	public static WebElement ele,fr;
	public static String ere,str;
	public static File file;

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
	public static void Request_second_opinion_negative_welcome() throws IOException {
		try {
			click("welcome_login");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Validate that the user is able to Login with valid credentials*/
	@When("User enters valid phonenumber and password and User click on login")
	public static void Request_second_opinion_negative_login() throws InterruptedException, Exception {
		try {
        	driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",6));
			click("login");
			browser_wait(12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User should be able to click on the Request for second opinion button and navigated to the Second opinion page successfully")
	public static void Request_second_opinion_negative_click() throws IOException {
		try {
			click("request_second_opinion_button");
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//TC_001 Validate that the user is not allowed to leave  check box "self"  unchecked and "Proceed" button is disabled when user unchecked  the check box - 'I agree to DocPanel's terms and condition'
	@When("User should be not able to click on the Proceed button when the check box self and I agree to DocPanels terms and condition is unchecked")
	public static void Request_second_opinion_negative_tc_001() throws IOException, InterruptedException {
		try {
			click("so_self_checkbox");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator","so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_001");
		}	
	}

	//TC_002 Validate that user should navigated to the "Upload your scan page" and should not allowed to  click on "Continue to add clinical details" without "upload my scans"
	@When("User should get a validation message when click on Continue to add clinical details button without upload my scans")
	public static void Request_second_opinion_negative_tc_002() throws IOException {	   
//		try {
//			click("so_agree_to_docpanel_checkbox");
//			browser_wait(10);
//			click("so_proceed_button");
//			Thread.sleep(8000);
//			fr= driver.findElement(By.xpath(OR_reader("Object_Locator","outer_frame")));
//			driver.switchTo().frame(fr);
//			browser_wait(30);
//			click_javascript("so_don’t_have_doctors_checkbox");
//			browser_wait(5);
//			click_javascript("so_i_dont_have_it");
//			click_javascript("so_clinical_details_button");
//			str= driver.findElement(By.xpath(OR_reader("Object_Locator","upload_scan_validation_msg"))).getText();
//			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
//			browser_wait(10);
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("Request_second_opinion_negative_tc_002");
//		}
	}

	//TC_003 Validate that user should get validation message on clicking "Continue to add clinical details" button when the check box "I don not have a doctor's reports" is unchecked
	@When("User should get a validation message when click on Continue to add clinical details button when the check box I don not have a doctors reports is unchecked")
	public static void uRequest_second_opinion_negative_tc_003() throws IOException {
//		try {
//			click_javascript("so_don’t_have_doctors_checkbox");
//			browser_wait(5);
//			click_javascript("so_clinical_details_button");
//			str= driver.findElement(By.xpath(OR_reader("Object_Locator","upload_scan_validation_msg"))).getText();
//			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
//			str= driver.findElement(By.xpath(OR_reader("Object_Locator","upload_report_validation_msg"))).getText();
//			Assert.assertEquals(str,td_reader("upload_report_validation_msg")); 
//			browser_wait(10);
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("Request_second_opinion_negative_tc_003");
//		}
	}

	//TC_004 Validate that user should not allowed to  click on "Continue to add clinical details" without "upload my reports"
	@When("User should get a validation message when click on Continue to add clinical details button without upload my reports")
	public static void Request_second_opinion_negative_tc_004() throws InterruptedException, IOException {
//		try {
//			browser_wait(2);
//			file = new File(getreport());
//			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_upload_report_button"))).sendKeys(file.getAbsolutePath());
//			click_javascript("so_clinical_details_button");
//			str= driver.findElement(By.xpath(OR_reader("Object_Locator","upload_scan_validation_msg"))).getText();
//			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
//			browser_wait(10);
//			driver.navigate().to(getsourl());
//			click_javascript("create_new_case");
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("Request_second_opinion_negative_tc_004");
//		}
	}

	//TC_005 Validate that the user is not allowed to leave  check box "other"  unchecked
	@When("User should not be allowed to uncheck the other check box")
	public static void Request_second_opinion_negative_tc_005()  throws IOException {
		try {
			click("so_other_checkbox");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_005");
		}
	}

	//TC_006 Validate that the user is not allowed to proceed when 'First name' and 'Last name' fields are blank
	@When("validation messages should be displayed when First name and Last name fields are blank")
	public static void Request_second_opinion_negative_tc_006() throws IOException, InterruptedException {
		try {
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","so_first_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_first_name_validation_msg")); 
			browser_wait(4);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			takeScreenShot("Request_second_opinion_negative_tc_006");
		}
	}

	//TC_007 Validate that the user is not allowed leave blank 'First name' field
	@When("validation message should be displayed when First name field is blank")
	public static void Request_second_opinion_negative_tc_007() throws InterruptedException, IOException {	
		try {
			click("so_other_checkbox");
			browser_wait(2);
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","so_first_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_first_name_validation_msg")); 
			browser_wait(4);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_007");
		}
	}

	//TC_008 Validate that the user is not allowed leave blank 'Last name' field
	@When("validation message should be displayed when Last name fields are blank")
	public static void Request_second_opinion_negative_tc_008() throws IOException, InterruptedException {	
		try {
			click("so_other_checkbox");
			browser_wait(2);
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","so_last_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_last_name_validation_msg")); 
			browser_wait(4);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_008");
		}
	}

	//TC_009 Validate that the user should get a validation message on entering invalid 'First name'  and 'Last name' 
	@When("validation messages should be displayed when First name and Last name fields are invalid")
	public static void Request_second_opinion_negative_tc_009() throws IOException, InterruptedException {		
		try {
			click("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",0));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",0));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","so_invalid_first_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_first_name")); 
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","so_invalid_last_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_last_name")); 
			browser_wait(4);
			browser_refresh();
			click("create_new_case");
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_009");
		}
	}

	//TC_010 Validate that the user is not allowed to Proceed with invalid 'First name' and valid 'Last name'
	@When("validation messages should be displayed when invalid First name and valid Last name are given")
	public static void Request_second_opinion_negative_tc_010()  throws IOException, InterruptedException {	
		try {
			click("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",0));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","so_invalid_first_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_first_name")); 
			browser_wait(4);
			browser_refresh();
			click("create_new_case");
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_010");
		}
	}

	//TC_011 Validate that the user is not allowed to Proceed with valid 'First name' and invalid 'Last name'
	@When("validation messages should be displayed when valid First name and invalid Last name are given")
	public static void Request_second_opinion_negative_tc_011()  throws IOException, InterruptedException {
		try {
			click_javascript("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",3));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",3));
			click_javascript("so_other_agree_to_docpanel_checkbox");
			click_javascript("so_iam_legal_guardian_checkbox");
			click_javascript("so_proceed_button");
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","so_invalid_last_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_last_name"));
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_011");
		}
	}

	//TC_012 Validate that the "Proceed" button is disabled when user unchecked  the check box - 'I agree to DocPanel's
	@When("User should be not able to click on the Proceed button when the check box I agree to DocPanels terms and condition is unchecked")
	public static void Request_second_opinion_negative_tc_012()  throws IOException {
		try {
			click("so_iam_legal_guardian_checkbox");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator","so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
			browser_wait(10);
		} catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_012");
		}
	}

	//TC_013 Validate that  "Proceed" button is disabled when the check box - "I am the legal guardian or have the necessary consents to order this second opinion" is unchecked
	@When("User should be not able to click on the Proceed button when the check box I am the legal guardian or have the necessary consents to order this second opinion\" is unchecked")
	public static void Request_second_opinion_negative_tc_013()  throws IOException {
		try {
			click("so_iam_legal_guardian_checkbox");
			click("so_other_agree_to_docpanel_checkbox");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator","so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
			browser_wait(10);
			System.out.println("Request second opinion negative");
		} catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Request_second_opinion_negative_tc_013");
		}
		browser_close();
	}
}

