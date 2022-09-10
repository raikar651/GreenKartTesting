package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("url");
		
		
		String browser_property = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		String browser = browser_maven!=null ? browser_maven:browser_property;
		
		if(driver == null) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver_win32//chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
			
			
		}
		
		return driver;
	}

}
