package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		
	}
	
	@Test(dataProvider="getData")
	public void basepagenavigation(String Username, String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp= new LandingPage(driver);
		lp.selectLogin().click();
		LoginPage l = new LoginPage(driver);
		l.getUser().sendKeys(Username);
		l.getPass().sendKeys(Password);		
		l.selectLogin().click();
		log.info(Username+" User tried to sign in");
		}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "restricted@tester.com";
		data[0][1] = "12156";
		data[1][0] = "nonrestricted@tester.com";
		data[1][1] = "15235";
		
		return data;
 	}

	@AfterClass
	public void closebrowser() {
		driver.close();
		log.info("Browser Closed");
	}
}
