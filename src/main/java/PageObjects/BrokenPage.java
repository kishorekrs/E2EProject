package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenPage {
	
	private WebDriver driver;
	
	public BrokenPage(WebDriver driver) {
		this.driver = driver;
	}

	By links = By.cssSelector("li[class='gf-li'] a");
	
	public List<WebElement> getlinkslist() {
		return driver.findElements(links);
	}
	
}
