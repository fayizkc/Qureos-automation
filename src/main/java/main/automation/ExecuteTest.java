package main.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.pageobjects.LoginPage;

public class ExecuteTest {
	
	static WebDriver driver;
	
	public static void main(String [] args) throws Exception {		
		InitExecution execute = new InitExecution("firefox");
		WebDriver driver = execute.getWebDriver();
		driver.get("https://app.qureos.com");
		
		LoginPage login = new LoginPage(driver);
		System.out.println(driver.getTitle() + " launched successfully!");
		if(!login.verifyLoginPage())
			throw new Exception("Applicaiton not opened");
		login.loginToApp(execute.getTestData("userName"), execute.getTestData("password"));
		
		if(driver.findElements(By.xpath("//div[text()='Dashboard']")).size()>0) {
			System.out.println("user successfully logged in");
		}else {
			throw new Exception("Loggin failed");
		}		
		driver.quit();
	}

}
