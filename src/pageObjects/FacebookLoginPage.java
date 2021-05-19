package pageObjects;

import org.openqa.selenium.By;


public class FacebookLoginPage {
	
	public static By txtBox_uName = By.id("email");
	public static By txtBox_pass = By.id("pass");
	public static By btn_login = By.xpath("//button[contains(@name,'login') and contains(@type,'submit')]");

}
