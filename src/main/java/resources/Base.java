package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Kishore kumar\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
			{
				DesiredCapabilities ds = DesiredCapabilities.chrome();
				ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				ChromeOptions co = new ChromeOptions();
				co.merge(ds);
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kishore kumar\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver(co);
		}
		return driver;
	}
	

}
