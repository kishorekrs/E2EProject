package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailLandingPage {
	
	public WebDriver driver;
	
	public GmailLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	



	By Signin=By.cssSelector("[data-action='sign in']");
	
	
	public WebElement selectsign() {
		return driver.findElement(Signin);
	}
}
