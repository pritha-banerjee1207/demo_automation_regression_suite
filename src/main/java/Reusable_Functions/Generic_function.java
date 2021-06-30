package Reusable_Functions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Generic_function {
	public static WebDriver driver;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell,f;
	public static XSSFRow row;
	public static String CellData,path;
	static File file = new File("configuration/config.properties");
	static Properties prop = new Properties();
	public static int iter; 
	public static String mainwindow,firefox= "geck",edge="msedge",chrome="chrome" ;
	public static int col;
	public static Set<String> s1 ;
	public static Iterator<String> i1 ;
	static int size;
	public static boolean value1;
	static List<WebElement> grid_elements,drp_list;
	static List<WebElement> grid_element;
	static WebElement ele,l,from,to,temp;
	static String ere,ptr,value,input;
	public static WebElement val ,element;

	/* Browser launching using driver that is specified in the config.properties file , navigating to Landing Welcome Page and returning driver object*/
	public static void Browser_Launch() throws IOException, InterruptedException {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		path = getDriverPath();
		if(path.contains(firefox))
		{
			System.setProperty("webdriver.gecko.driver",getDriverPath());
			driver = new FirefoxDriver();	
		}
		else if (path.contains(edge)) {
			System.setProperty("webdriver.edge.driver", getDriverPath());
			driver = new EdgeDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver",getDriverPath());
			Map<String, Object> prefs = new HashMap<String, Object>();			
			prefs.put("profile.default_content_setting_values.notifications", 1);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}
  	    driver.navigate().to(getURL());	
	    driver.manage().window().maximize();
	}
	/*Function will return the name of the browser*/
	public static String browser_name() {
				path = getDriverPath();
				if(path.contains(edge))
				{
					return edge;
				}
				if (path.contains(firefox)) {
					return firefox;
				}
				return chrome;	
	}
	
	
	/* Browser launch*/
	public WebDriver browser_launch() throws IOException {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		path = getDriverPath();
		if(path.contains(firefox))
		{
			
			System.setProperty("webdriver.gecko.driver",getDriverPath());
			driver = new FirefoxDriver();	
		}
		else if (path.contains(edge)) {
			System.setProperty("webdriver.edge.driver", getDriverPath());
			driver = new EdgeDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver",getDriverPath());
			driver = new ChromeDriver();		
		}
		driver.navigate().to(getURL());
		driver.manage().window().maximize();
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(getmedicareURL());
      	driver.switchTo().window(tabs.get(0));
		return driver;
	}

	/*My medicare URL getter*/
	public static String getmedicareURL() {
		String Medicare= prop.getProperty("Medicare");
		if(Medicare!=null) return Medicare ;
		else throw new RuntimeException ("Medicare URL is not specified in the Config.properties");
	}
	
	/*Request second opinion URL getter*/
	public static String getsourl() {
		path= prop.getProperty("so_url");
		if(path!=null) return path ;
		else throw new RuntimeException (" SO URL is not specified in the Config.properties");
	}
	
	/* Second opinion dashboard URL getter*/
	public static String geturl() {
		path= prop.getProperty("so_dashboard_url");
		if(path!=null) return path ;
		else throw new RuntimeException (" SO dashboard URL is not specified in the Config.properties");
	}
	
	/*Bills carousal rotation for chrome and edge browser*/
	public void chrome_edge_slide(WebElement from, WebElement to)  {
		try {
			from = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader("Object_locator", "bills_carousel_to")));
			Actions action = new Actions(driver);
			action.dragAndDrop(from, to).perform();
			browser_wait(20);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/*Bills carousal rotation for chrome browser*/
	public void firefox_slide(WebElement from)  {
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(from, -100, 0).click();
			action.build().perform();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/* Upload scans in chrome and edge browsers  */
	public static void upload_files(File file ,String obj)  {
		try {			
			temp=driver.findElement(By.xpath(OR_reader("Object_Locator",obj)));
			temp.sendKeys(file.getAbsolutePath());			
			browser_wait(20);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/* Upload scans in firefox browsers  */
	public static void ff_upload_files(File file)  {
		try {	
	    Thread.sleep(1000);
		StringSelection ss = new StringSelection(file.getAbsolutePath());
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/*To get test data iteration value from config.properties file*/
	public static int Dataiter() {            
		iter=Integer.parseInt(prop.getProperty("Data_iteration"));
		return iter;		
	}	

	/* Reading chrome driver path from config.properties file */
	public static String getDriverPath() {
		String driverpath= prop.getProperty("Driverpath");
		if(driverpath!=null) return driverpath ;
		else throw new RuntimeException ("Driverpath is not specified in the Config.properties");
	}

	/* Reading URL from config.properties file */
	public static String getURL() {
		String URL= prop.getProperty("URL");
		if(URL!=null) return URL ;
		else throw new RuntimeException ("URL is not specified in the Config.properties");
	}

	/* Reading Excel file path  from config.properties   */
	public static String getFilepath() {
		String filepath= prop.getProperty("Filepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}

	/*To get directory path of screenshots folder*/

	public static String getDir() {
		String dirpath= prop.getProperty("Dirpath");
		if(dirpath!=null) return dirpath ;
		else throw new RuntimeException ("user Dir is not specified in the Config.properties");
	}
	
	/* Reading Dicom images folder path  from config.properties   */
	public static String getimage() {
	     path= prop.getProperty("Dicom_images");
		if(path!=null) return path ;
		else throw new RuntimeException ("Image path is not specified in the Config.properties");
	}
	
	/* Reading Doctor's report file path  from config.properties   */
	public static String getreport() {
		 path= prop.getProperty("Report");
		if(path!=null) return path ;
		else throw new RuntimeException (" Report path is not specified in the Config.properties");
	}
	
	/* Reading Pofile picture file path  from config.properties   */
	public static String getprofilepic() {
		path= prop.getProperty("Profile_pic");
		if(path!=null) return path ;
		else throw new RuntimeException ("Profile pic is not specified in the Config.properties");
	}


	/*  Taking Screenshot of failed test cases  */
	public static  void takeScreenShot(String fileName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(getDir()+fileName+".png"));
	}

	/* Click operation for a particular fieldname that is passing to this function through finding locator value of fieldname using OR_reader function*/
	public static void click(String fieldname) throws IOException {
		driver.findElement(By.xpath(OR_reader("Object_Locator", fieldname))).click();
	}

	/* Refresh function to refresh the current URL opened in browser */
	public static void browser_refresh() {
		driver.navigate().refresh();
	}

	/* To wait the browser till the time passed to this function */
	public static void browser_wait(int time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}

	/*Function to clear the value in a particular field*/
	public static void field_clear(String fieldname) throws IOException {
		val = driver.findElement(By.xpath(OR_reader("Object_Locator", fieldname)));
		val.clear();
	}

	/* To find object locator value of a particular fieldname passing to this function by loading Excel workbook*/
	public static  String OR_reader(String sheetname,String Fieldname) throws IOException  {
		File src=new File(getFilepath());
		FileInputStream finput;
		finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		row = sheet.getRow(0);
		for(int i=1;i<rowCount;i++) {
			cell = sheet.getRow(i).getCell(0);
			CellData = cell.getStringCellValue();
			if(CellData.equals(Fieldname))
			{
				f= sheet.getRow(i).getCell(2);
				path = f.getStringCellValue();
				break;
			}
			else
			{
				continue;
			}
		}
		return path;
	}

	/* To read test data value of a particular fieldname passing to this function using findRow function to get row number from excel sheet  */
	public static String td_reader(String fieldname) {
		sheet = workbook.getSheetAt(0);
		col= Dataiter();
		String td_value=sheet.getRow(findRow(fieldname)).getCell(col).getStringCellValue();
		return td_value;
	}

	/* To read test data value of a particular fieldname using index  where its values are seperated with a comma within cell in excel sheet  */
	public static String td_reader(String fieldname,int index){
		sheet = workbook.getSheetAt(0);
		col= Dataiter();
		String td_value = sheet.getRow(findRow(fieldname)).getCell(col).getStringCellValue();
		String[] str = td_value.split(",");
		return str[index];
	}

	/* To get row number of a particular fieldname passing to this function from excel sheet  */
	public static int findRow(String fieldname) {
		sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getRichStringCellValue().getString().trim().equals(fieldname)) {
					return row.getRowNum();  
				}
			}
		}       
		return 0;
	}

	/*To switch the browser*/
	public static void browser_switch() {
		driver.switchTo().window(mainwindow);
	}

	/*To close the browser */
	public static void browser_close() {
		driver.close();
	}

	/*To quit the browser */ 
	public static void driverquit() {
		driver.quit();	
	}

	/*To go back to the browser */
	public static void browser_back() {
		driver.navigate().back();
	}

	/* Function used to handle multiple window*/
	public static void browser_handle() {
		mainwindow = driver.getWindowHandle();
		s1 = driver.getWindowHandles();
		i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}    
	}

	/* To click multiple tabs inside home page*/
	public static void grid_tiles(String grid_path) throws IOException, InterruptedException {
		size = driver.findElements(By.xpath(grid_path)).size();
		try {
			for (int i=0; i<size;i++)
			{	
				grid_elements =driver.findElements(By.xpath(grid_path));	
				ele = grid_elements.get(i);
				ere= ele.getText();
				if(ere.equalsIgnoreCase("Wallet")) {
					ele.click();
					value1 = driver.findElement(By.xpath(OR_reader("Object_Locator", "wallet_page_title"))).isDisplayed();
					Assert.assertEquals(true,value1);	
					Thread.sleep(2000);
					browser_back();
				}else if(ere.equalsIgnoreCase("Second Opinions"))
				{
					ele.click();
					value1 = driver.findElement(By.xpath(OR_reader("Object_Locator", "second_opinion_title"))).isDisplayed();
					Assert.assertEquals(true,value1);	
					Thread.sleep(2000);
					browser_back();
				}
				else {
					try {
						ele.click();
						value = driver.findElement(By.xpath(OR_reader("Object_Locator", ere))).getText();
						value1 = driver.findElement(By.xpath(OR_reader("Object_Locator", ere))).isDisplayed();
						Assert.assertEquals(true,ere.equalsIgnoreCase(value));
						Assert.assertEquals(true,value1);	
						Thread.sleep(2000);
						browser_back();
					}catch(Exception e) {
						click("tab_ok");
					}
				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		browser_wait(5);
	}

	/* To click multiple tabs inside services page*/
	public static void grid_tile(String grid_path) throws IOException, InterruptedException {
		size = driver.findElements(By.xpath(grid_path)).size();

		for (int i=0; i<size;i++)
		{	
			grid_elements =driver.findElements(By.xpath(grid_path));	
			ele = grid_elements.get(i);
			ere= ele.getText();

			if(ere.equalsIgnoreCase("Second Opinions")) {
				ele.click();
				value1 = driver.findElement(By.xpath(OR_reader("Object_Locator", "second_opinion_title"))).isDisplayed();
				Assert.assertEquals(true,value1);	
				browser_wait(10);
				browser_back();
			}else if(ere.equalsIgnoreCase("Bills"))
			{
				ele.click();
				browser_wait(10);
				browser_back();
			}
			else {
				try {
					if (ptr.equalsIgnoreCase(ere)) {
						value = driver.findElement(By.xpath(OR_reader("Object_Locator", ere))).getText();
						Assert.assertEquals(true,value);

					}
				}catch(Exception e) {
					ele.click();
					browser_wait(10);
					takeScreenShot(ere);
					click("tab_ok");			
				}

			}
		}

	}

	/* To click multiple tabs inside utilities page*/
	public static void utilities_grid_tile(String grid_path) throws IOException, InterruptedException {
		size = driver.findElements(By.xpath(grid_path)).size();
		for (int i=0; i<size;i++)
		{	
			grid_elements =driver.findElements(By.xpath(grid_path));	
			ele = grid_elements.get(i);
			ere= ele.getText();
			if(ere.equalsIgnoreCase("Wallet")) {
				ele.click();
				browser_wait(40);
				value1 = driver.findElement(By.xpath(OR_reader("Object_Locator", "utilities_add_card"))).isDisplayed();
				Assert.assertEquals(true,value1);	
				browser_wait(20);
				click_javascript("utilities");
			}else if(ere.equalsIgnoreCase("Award Points"))
			{
				ele.click();
				browser_wait(30);
				value1 = driver.findElement(By.xpath(OR_reader("Object_Locator", "award_points_title"))).isDisplayed();
				Assert.assertEquals(true,value1);
				browser_back();
			}
			else {
				try {
					if (ptr.equalsIgnoreCase(ere)) {
						value = driver.findElement(By.xpath(OR_reader("Object_Locator", ere))).getText();
						Assert.assertEquals(true,value);
					}
				}catch(Exception e) {
					ele.click();
					Thread.sleep(2000);
					takeScreenShot(ere);
					click("tab_ok");
				}
			}
		}
	}

	/* To select value passed as text from a dropdown menu if the element is input*/
	public static void drop_down(String drp_click,String text) throws IOException {
		drp_list = driver.findElements(By.xpath(drp_click));
		int size= drp_list.size();	
		for( int i=0; i<size;i++){
			ele = drp_list.get(i);
			ere= ele.getText();
			if(ere.equalsIgnoreCase(text)) {
				ele.click();
			}

		}
	}

	/*To click element using JavascriptExecutor */
	public static void click_javascript(String fieldname) throws IOException {
		element= driver.findElement(By.xpath(OR_reader("Object_Locator", fieldname)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/* To clear the field by fieldname passing to this function*/
	public static void backspace(String fieldname) throws IOException {
		l = driver.findElement(By.xpath(OR_reader("Object_Locator", fieldname)));
		input = l.getAttribute("value");
		for (int i = 1; i <= input.length(); i++) {
			l.sendKeys(Keys.BACK_SPACE);
		}
	}

	/* To select value passed as text if the drop down is select type*/	
	public static void selectdrop_down(String field,String text) throws IOException {
		Select dropdown = new Select(driver.findElement(By.xpath(OR_reader("Object_Locator", field))));  
		dropdown.selectByVisibleText(text);
	}

	/* Function to scroll down the page*/	
	public static void scrolldown() throws IOException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
}


