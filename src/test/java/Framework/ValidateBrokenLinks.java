package Framework;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.BrokenPage;
import resources.Base;

public class ValidateBrokenLinks extends Base {

	@BeforeMethod
	public void openBrowser() throws IOException {
		
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void checkBrokenLinks() throws MalformedURLException, IOException {
		SoftAssert sa = new SoftAssert();
		driver.get(prop.getProperty("Brokentest"));
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\Selenium\\Homepage.jpg");
		FileUtils.copyFile(src, des);
		BrokenPage bp = new BrokenPage(driver);
		List<WebElement> lst = bp.getlinkslist();
		System.out.println("list_size :"+lst.size());
		for(WebElement link : lst) {
			String url = link.getAttribute("href");
			HttpURLConnection hp =(HttpURLConnection)new URL(url).openConnection();
			hp.setRequestMethod("HEAD");
			hp.connect();
			int respcode = hp.getResponseCode();
			System.out.println(respcode);
			sa.assertTrue(respcode<400, "Broken Link Name - "+link.getText()+"Failed with Status Code"+respcode);
		}
		sa.assertAll();
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}
