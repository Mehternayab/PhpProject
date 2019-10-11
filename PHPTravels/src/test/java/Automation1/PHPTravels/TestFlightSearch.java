package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestFlightSearch {
	@Test
	public void flightSearch() throws IOException, InterruptedException {
		Launch l = new Launch();
		FlightSearch fs = new FlightSearch();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		driver.findElement(fs.flight).click();
		fs.toLocation(driver);
		fs.fromLocation(driver);
		fs.departure(driver, prop);
		driver.findElement(fs.oneway).click();
		fs.guests(driver,prop);
		driver.findElement(fs.search).click();		
	}

}