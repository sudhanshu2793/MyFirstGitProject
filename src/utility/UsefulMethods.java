package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsefulMethods extends InstantiateWebdriver {

	public static void highlightWebElement(WebElement element){
		
		
		try{
			
			JavascriptExecutor jsExec = (JavascriptExecutor)driver;
			jsExec.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px red;');", element);
			
		}
		catch(Exception e){
			System.out.println("Execption while highlighting element. Error says: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
}
