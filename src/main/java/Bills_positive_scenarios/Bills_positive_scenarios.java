package Bills_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Bills_positive_scenarios extends Generic_function{
	public static boolean value;
	public static String str,text,driver_name;
	public static WebElement from,to;

	/*Browser launch*/
	@Given("browser is open")
	public void browser_launching() throws Exception {
		try {
			Browser_Launch();
			browser_wait(12);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("browser launching");
		}
	}

	/*TC 001 -Validate that user can able to click on Bills tile from the home page tiles */
	@When("Click on Bills and verify that the user should be navigated to bills page")
	public void bills_positive_tc_001() throws Exception {
		try {
			click("welcome_login");
			browser_wait(12);
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			browser_wait(20);
			click("services");
			click("bills_title_services");
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("bills_positive_tc_001");
		}
	}

	/*TC 002 - Validate that the user can able to view Total bills due below the Bills title*/
	@Given("Total bills due and amount should be visible on the page")
	public void bills_positive_tc_002() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "bills_due_amount"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("bills_negative_tc_002");
		}	
	}

	/*TC 003 - Validate that the user can able to select Newest option from the dropdown*/
	@Given("Click on dropdown and select Newest")
	public void bills_positive_tc_003() throws Exception {
		try {
			click("bills_dropdown");
			text = td_reader("bills_dropdown_option");
			drop_down(OR_reader("Object_Locator", "bills_dropdown_box"),text);
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("bills_positive_tc_003");
		}	
	}
	/*TC 004 - Validate that the user can view bills as two sections such as Due and Paid*/
	@Given("Click on Due section and click on Paid section")
	public void bills_positive_tc_004() throws Exception {
		try {
			click_javascript("bills_due_section");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "bills_due_message"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("bills_paid_section");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "bills_paid_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("bills_positive_tc_004");
		}	
	}
	/*TC 005 - Validate that user can slide the grid below the Bills page title.*/
	@Given("Slide through Total bills due Verify that Your expenses grid is visible")
	public void bills_positive_tc_005() throws Exception {
		try {
			from = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from,to);
			}
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("bills_positive_tc_005");
		}
	}

	/*TC 006 - Validate that the user can able to click on Pay a Bill button*/
	@Given("Click on Pay a Bill button and verify that the user is navigated to bill due section")
	public void bills_positive_tc_006() throws Exception {
		try {
			click("bills_pay_a_bill_button");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "bills_due_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("bills_positive_tc_006");
		}	
	}

	/*TC 007 - Validate that the user can able to click on Explore Services button*/
	@Given("Click on Explore Services button and verify that the user is navigated to Services dashboard")
	public void bills_positive_tc_007() throws Exception {
		try {
			from = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from, to);
			}
			click("bills_explore_services_button");
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("bills_positive_tc_007");
		}	
	}

	/*TC 008 - Validate that the user will get validation message when expense is $0*/
	@Given("you have no expenditures yet. Use a service or upload a bill to pay message should be displayed on the page")
	public void bills_positive_tc_008() throws Exception {
		try {
			click("services");
			click("bills_title_services");
			from = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from, to);
			}
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","bills_zero_expenditure_msg"))).getText();
			Assert.assertEquals(str,td_reader("bills_zero_expenditure_msg"));
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "bills_zero_expenditure_img"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Bills positive");
			browser_close();
		}catch (Exception e) {
			e.getMessage();
			takeScreenShot("bills_positive_tc_008");
		}	
	}
}
