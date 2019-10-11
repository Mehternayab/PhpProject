package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestToursSearch {
	@Test
	public void ToursSearch() throws  InterruptedException, IOException {
		Launch l = new Launch();
		ToursSearch ts = new ToursSearch();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		ts.search(driver);
		driver.findElement(ts.city_name).click();
		driver.findElement(By.xpath("//div[contains(text(),'"+prop.getProperty("tourname")+"')]")).click();
		ts.date(driver, prop);
		ts.Guests(driver);
		ts.tourtype(driver);
		driver.findElement(ts.submit).click();
		
	}
}