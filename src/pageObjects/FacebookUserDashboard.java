package pageObjects;

import org.openqa.selenium.By;

public class FacebookUserDashboard {
	
	public static By profilePicture = By.xpath("//div[contains(@aria-label, 'Profile picture actions') and contains(@role, 'button')]");
	public static By uploadedPost = By.xpath("//div[@class='j83agx80 cbu4d94t ew0dbk1b irj2b8pg']/div[@class='qzhwtbm6 knvmm38d']/span/div[@class='kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql ii04i59q']/div");

	public static By btn_menu = By.xpath("//div[@class='j83agx80 l9j0dhe7']/div[@aria-label='Account']/div");
	public static By option_logout = By.xpath("//div[@class='j83agx80 cbu4d94t ew0dbk1b irj2b8pg']/div[@class='qzhwtbm6 knvmm38d']/span[text()='Log Out']");
	
}
