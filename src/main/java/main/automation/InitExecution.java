package main.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitExecution {
	
	private WebDriver driver;
	private String browser;
	static final String TEST_DATA = "testData.properties";
	
	
	public InitExecution(String browser) {
		this.browser = browser;
		this.setWebDriver();
	}
		
	private void setWebDriver() {
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			this.driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			this.driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	public String getTestData(String key) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;	
	    fis = new FileInputStream(TEST_DATA);
	    prop = new Properties();
	    prop.load(fis);
	    fis.close();
	    return prop.getProperty(key);	      
	}

}
