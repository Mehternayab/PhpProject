package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestLogin {
	@Test
	public void login() throws IOException, InterruptedException {
		Launch l = new Launch();
		Registration r = new Registration();
		Login li = new Login();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		driver.findElement(l.MyAccount).click();
		driver.findElement(l.signup).click();
		r.getFirstname(driver).sendKeys(prop.getProperty("firstname"));
		r.getLastname(driver).sendKeys(prop.getProperty("leastname"));
		r.getMobile(driver).sendKeys(prop.getProperty("mobile"));
		r.getEmail(driver).sendKeys(prop.getProperty("Email"));
		r.getPassword(driver).sendKeys(prop.getProperty("password"));
		r.getCpassword(driver).sendKeys(prop.getProperty("cpassword"));
		driver.findElement(By.xpath("//button[@id='cookyGotItBtn']")).click();
		r.getSubmit(driver).click();
		Thread.sleep(5000);
		li.log(driver,prop);
	}
	

}
