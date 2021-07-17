package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.name("email");
	By password = By.id("user_password");
	By submit = By.cssSelector("[type='submit']");
	
	
	public WebElement getUser() {
		return driver.findElement(username);
	}
	
	public WebElement getPass() {
		return driver.findElement(password);
	}
	
	public WebElement selectLogin() {
		return driver.findElement(submit);
	}
}
