package utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InstantiateWebdriver {
	
	protected static WebDriver driver;
	
	@Test
	@Parameters({"browserName"})
	protected static void instantiateDriver(String browserType){
		
		try{
			
			switch(browserType){
			
				case "chrome": 	System.setProperty("webdriver.chrome.driver", "C:\\Kumar\\Software\\chromedriver_win32_90\\chromedriver.exe");
								
								Map<String, Object> prefs = new HashMap<String, Object>();
								prefs.put("profile.default_content_setting_values.notifications", 2);
				
								ChromeOptions options = new ChromeOptions();
								options.setExperimentalOption("prefs",prefs);
								
								DesiredCapabilities capabilities = DesiredCapabilities.chrome();
								capabilities.setCapability("goog:chromeOptions",options);
								
								driver = new ChromeDriver(capabilities);
								driver.manage().window().maximize();
								
								break;
				
				default: System.out.println("Please specify correct browser name");
			}
		}
		catch(Exception e){
			System.out.println("Error while intantiating webdriver: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	

}
