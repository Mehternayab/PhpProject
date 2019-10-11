package Automation1.PHPTravels;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FlightSearch {
	By flight = By.xpath("//a[@href='#thflight']");
	By toLocation = By.xpath("//div[@id='s2id_origin']//span[@class='select2-chosen'][contains(text(),'Enter Location')]");
	By tLocation = By.xpath("//div[@id='s2id_origin']//a[@class='select2-choice select2-default']");
	By fromLocation = By.xpath("//div[@id='s2id_destination']//span[@class='select2-chosen'][contains(text(),'Enter Location')]");
	By fLocation = By.xpath("//div[@id='s2id_destination']//a[@class='select2-choice select2-default']");
	By oneway = By.xpath("//div[@class='tab-content shad RTL_shad search-form']//div[1]//div[1]//div[1]//ins[1]");
	By search = By.xpath("//button[@class='btn-primary btn btn-lg btn-block pfb0']");
	By departure = By.xpath("//input[@id='departure']");
	By month = By.xpath("//div[16]//div[1]//tr[1]//th[2]");
	By nextbtn = By.xpath("//div[16]//div[1]//tr[1]//th[3]");
	By guestsbtn = By.xpath("//div[@class='col-md-1 form-group go-right col-xs-12']//input[@placeholder='0']");
	By madult = By.xpath("//select[@id='madult']");
	By mchildren = By.xpath("//select[@id='mchildren']");
	By minfant = By.xpath("//select[@id='minfant']");
	By submit = By.xpath("//button[@id='sumManualPassenger']");
	
	public void toLocation(WebDriver driver) throws InterruptedException {
		driver.findElement(toLocation).click();
		driver.findElement(tLocation).sendKeys("Del");
		Thread.sleep(1000);
		driver.findElement(tLocation).sendKeys(Keys.ENTER);
		
	}
	
	public void fromLocation(WebDriver driver) throws InterruptedException {
		driver.findElement(fromLocation).click();
		driver.findElement(fLocation).sendKeys("chenn");
		Thread.sleep(1000);
		driver.findElement(fLocation).sendKeys(Keys.ENTER);
		
	}
	
	public void departure(WebDriver driver,Properties prop) {
		driver.findElement(departure).click();
		String str = driver.findElement(month).getText();
		while(!str.equalsIgnoreCase(prop.getProperty("inmonth"))) {
			driver.findElement(nextbtn).click();
			str = driver.findElement(month).getText();
		}
		for(int i=1 ; i<=6 ; i++ ) {
			for(int j=1 ; j<=7 ; j++) {
				String str1 = driver.findElement(By.xpath("//div[16]//tr["+i+"]//td["+j+"]")).getText();
				if(str1.equals("1")) {
					for(int k = i ; k <= 6 ; k++) {
						for(int x = j ; x < 7 ; x++) {
							String str2 = driver.findElement(By.xpath("//div[16]//tr["+k+"]//td["+x+"]")).getText();
							System.out.println(str2);
							if(str2.equals(prop.getProperty("indate"))) {
								driver.findElement(By.xpath("//div[16]//tr["+k+"]//td["+x+"]")).click();
							}
						}
					}
				}
			}
		}
	}
	
	public void guests(WebDriver driver,Properties prop) {
		driver.findElement(guestsbtn).click();
		driver.findElement(madult).click();
		driver.findElement(madult).sendKeys(prop.getProperty("noofguests"));
		driver.findElement(By.xpath("//select[@id='madult']//option[contains(text(),'"+prop.getProperty("noofguests")+"')]")).click();
		
		driver.findElement(mchildren).click();
		driver.findElement(mchildren).sendKeys(prop.getProperty("noofguests"));
		driver.findElement(By.xpath("//select[@id='mchildren']//option[contains(text(),'"+prop.getProperty("noofguests")+"')]")).click();
		
		driver.findElement(minfant).click();
		driver.findElement(submit).click();
	}
}
