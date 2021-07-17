package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	
	By Login = By.xpath("//a[contains(@href,'sign_in')]");
	By Coursetitle = By.cssSelector("div[class='text-center'] h2");
	By Navbar = By.cssSelector("nav[class*='navbar']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement selectLogin() {
		return driver.findElement(Login);
	}
	
	public WebElement selecttitle() {
		return driver.findElement(Coursetitle);
	}
	
	public WebElement getnavbar() {
		return driver.findElement(Navbar);
	}
}
