package Framework;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.GmailLandingPage;
import resources.Base;

public class GmailPage extends Base{
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver= initializeDriver();
		driver.get(prop.getProperty("newurl"));
	}
	
	@Test
	public void login() {
		GmailLandingPage gp= new GmailLandingPage(driver);
		gp.selectsign().click();
		
	}

	
}
