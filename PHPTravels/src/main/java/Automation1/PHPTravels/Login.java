package Automation1.PHPTravels;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	By myaccount = By.xpath("//ul[2]/ul[1]/li[1]/a[1]");
	By logout = By.xpath("//ul[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
	By Email = By.xpath("//input[@placeholder='Email']");
	By pass = By.xpath("//input[@placeholder='Password']");
	By login = By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']");
	
	public void log(WebDriver driver, Properties prop) {
		driver.findElement(myaccount).click();
		driver.findElement(logout).click();
		driver.findElement(Email).click();
		driver.findElement(Email).sendKeys(prop.getProperty("Email")); 
		driver.findElement(pass).click();
		driver.findElement(pass).sendKeys(prop.getProperty("password"));
		driver.findElement(login).click();
	}
}
