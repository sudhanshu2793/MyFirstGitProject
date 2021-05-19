package testScenarios;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pageObjects.FacebookHomePage;
import pageObjects.FacebookLoginPage;
import pageObjects.FacebookUserDashboard;
import utility.InstantiateWebdriver;
import utility.UsefulMethods;
import utility.UsefulVariables;

public class PostStatusOnFacebook extends InstantiateWebdriver {

	//public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions action;
	
	@Test(enabled=false)
	  public static void setDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Kumar\\Software\\chromedriver_win32_90\\chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--start-maximized");
		//options.addArguments("--disable-notifications");
		
		
		options.setExperimentalOption("prefs",prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("goog:chromeOptions",options);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		
	  }
	
	@Test
	@Parameters({"URL"})
	  public static void launchFacebookURL(String URL) {
		
		driver.get(URL);
		Assert.assertEquals(driver.getCurrentUrl(), URL);
		System.out.println("URL matched");
		
		
	  }
	  
	
	@Test(dependsOnMethods={"launchFacebookURL"})
	@Parameters({"loginName","password", "accountName"})
	public static void loginToFacebook(String userName, String pwd, String accName) throws InterruptedException{
		driver.findElement(FacebookLoginPage.txtBox_uName).sendKeys(userName);
		driver.findElement(FacebookLoginPage.txtBox_pass).sendKeys(pwd);
		driver.findElement(FacebookLoginPage.btn_login).click();
		Thread.sleep(10000);
		UsefulMethods.highlightWebElement(driver.findElement(FacebookHomePage.txt_accName));
		Assert.assertEquals(driver.findElement(FacebookHomePage.txt_accName).getText(), accName);
		System.out.println("Successfully Logged In.");
		
	}
	
	
	@Test(dependsOnMethods={"loginToFacebook"}, groups={"notRun"})
	public static void openCreatePostWindow(){
		
		try{
			
			driver.findElement(FacebookHomePage.createPostChannel).click();
			Thread.sleep(5000);
			Assert.assertTrue(driver.findElement(FacebookHomePage.createPostForm).isDisplayed());
		}
		catch(Exception e){
			System.out.println("Execption while opening create post. Error says: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	@Test(dependsOnMethods={"openCreatePostWindow"}, groups={"notRun"})
	@Parameters({"verbiageOfPost"})
	public static void createpost(String postVerbiage){
		
		try{
			action = new Actions(driver);
			action.moveToElement(driver.findElement(FacebookHomePage.createPostForm_textField)).sendKeys(postVerbiage).build().perform();
			driver.findElement(FacebookHomePage.createPostForm_btnUploadPhoto).click();
			Screen desiredWindowElement = new Screen();
			Pattern windowDialogBox = new Pattern(UsefulVariables.imagePath+"\\WindowsDialog.JPG".toString());
			
			System.out.println("Uploading Photo");
			
			if((desiredWindowElement.exists(windowDialogBox))!=null){
				
				System.out.println("Windows dialog Box opened.");
				
				Pattern textField = new Pattern(UsefulVariables.imagePath+"\\ImagePathField.JPG".toString());
				desiredWindowElement.type(textField, UsefulVariables.imagePath+"\\Keshav.jpg".toString());
				
				Pattern openButton = new Pattern(UsefulVariables.imagePath+"\\OpenButton.JPG".toString());
				desiredWindowElement.click(openButton);
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(FacebookHomePage.createPostForm_btnPost)));
				Thread.sleep(5000);
				driver.findElement(FacebookHomePage.createPostForm_btnPost).click();
				Thread.sleep(5000);
				
			}
			else{
				System.out.println("Windows Dialog Box didn't open");
			}
		}
			
		catch(Exception e){
			System.out.println("Execption while opening create post. Error says: "+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Test(dependsOnMethods={"createpost"}, groups={"notRun"})
	@Parameters({"verbiageOfPost"})
	public static void verifyUploadedPost(String uploadedText){
		
		try{
			
			
			driver.findElement(FacebookHomePage.txt_accName).click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(FacebookUserDashboard.profilePicture));
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FacebookUserDashboard.uploadedPost));
			System.out.println("Text = = "+driver.findElement(FacebookUserDashboard.uploadedPost).getAttribute("innerHTML"));
			Assert.assertEquals(driver.findElement(FacebookUserDashboard.uploadedPost).getAttribute("innerHTML"), uploadedText);
			UsefulMethods.highlightWebElement(driver.findElement(FacebookUserDashboard.uploadedPost));
			System.out.println("Post successfully uploaded"); 
			
		}
		
		catch(Exception e){
			System.out.println("Execption while verifying uploaded post. Error says: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	@Test(dependsOnMethods={"verifyUploadedPost"}, groups={"notRun"})
	public static void logOut(){
		
		try{
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FacebookUserDashboard.btn_menu));
			action = new Actions(driver); 
			action.moveToElement(driver.findElement(FacebookUserDashboard.btn_menu)).click().build().perform();
			Thread.sleep(2000);
			driver.findElement(FacebookUserDashboard.option_logout).click();
		}
		catch(Exception e){
			System.out.println("Execption while logging out of facebook. Error says: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	@AfterTest
	public void quitDriver(){
		
		driver.quit();
		
	}*/
	
}
