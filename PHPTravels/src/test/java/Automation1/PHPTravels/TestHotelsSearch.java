package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestHotelsSearch {
	@Test
	public void hotelSerch() throws InterruptedException, IOException {
		
		
		Launch l = new Launch();
		HotelSearch hs = new HotelSearch();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='cookyGotItBtn']"))).click();
		*/driver.findElement(hs.hotel);
		driver.findElement(hs.name).click();
		driver.findElement(hs.name).sendKeys(prop.getProperty("hotelname"));
		Thread.sleep(1000);
		driver.findElement(hs.name).sendKeys(Keys.ENTER);
		hs.chickIn(driver,prop);
		hs.chickOut(driver,prop);
		hs.noOfGuest(driver,prop);
		driver.findElement(hs.search).click();
	}
}
