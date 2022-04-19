package main.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By objEmail = By.xpath("//input[@type='email']");
	By objpassword = By.xpath("//input[@type='password']");
	By objLogin = By.xpath("//button[text()='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean verifyLoginPage() {
		if(driver.getTitle().equals("Login • Qureos"))
			return true;
		else
			return false;
	}
	
	public void loginToApp(String userName, String password) {
		driver.findElement(objEmail).clear();
		driver.findElement(objEmail).sendKeys(userName);
		
		driver.findElement(objpassword).clear();
		driver.findElement(objpassword).sendKeys(password);
		driver.findElement(objLogin).click();
		System.out.println("Login as '" + userName + "' user");
	}

}
