package pageObjects;

import org.openqa.selenium.By;

public class FacebookHomePage {
	
	public static By txt_accName = By.xpath("//div[@class='qzhwtbm6 knvmm38d']/span/span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7']");
	
	public static By createPostChannel = By.xpath("//div[@class='m9osqain a5q79mjw jm1wdb64 k4urcfbm']/span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7']");
	public static By createPostForm = By.xpath("//div[@class='j83agx80 cbu4d94t buofh1pr l9j0dhe7']/div[contains(@class,'o6r2urh6 buofh1pr datstx6m l9j0dhe7 oh7imozk x68sjeil') and contains(@role,'presentation')]");
	public static By createPostForm_textField = By.xpath("//div[contains(@class,'notranslate _5rpu') and contains(@role, 'textbox')]");
	public static By createPostForm_btnUploadPhoto = By.xpath("//div[@class='ihqw7lf3 discj3wi l9j0dhe7']/descendant::div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t l9j0dhe7 k4urcfbm']/i[@class='hu5pjgll bixrwtb6']");
	public static By createPostForm_btnPost = By.xpath("//div[contains(@aria-label,'Post') and contains(@role,'button')]/descendant::span[contains(@class, 'a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5') and contains(text(),'Post')]");

}
