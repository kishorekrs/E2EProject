package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.Base;

public class ValidatePage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		LandingPage lp= new LandingPage(driver);
		System.out.println(lp.selecttitle().getText());
		Assert.assertEquals(lp.selecttitle().getText(), "FEATURED COURSES");
		log.info("Courses Validation Successfull");
		Assert.assertTrue(lp.getnavbar().isDisplayed());
		log.info("Navigation Bars Displayed Successfully");
		}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
	}
}

