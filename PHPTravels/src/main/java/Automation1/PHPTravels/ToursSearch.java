package Automation1.PHPTravels;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ToursSearch {
	By city_name = By.xpath("//span[contains(text(),'Search by Listing or City Name')]");
	By toursbtn = By.xpath("//a[@href='#tours']");
	By cookyGotItBtn = By.xpath("//button[@id='cookyGotItBtn']");
	By chickin = By.xpath("//div[@id='tchkin']//input[@placeholder='Check in']");
	By month = By.xpath("//div[11]//div[1]//tr[1]//th[2]");
	By nextbtn = By.xpath("//div[11]//div[1]//tr[1]//th[3]");
	By adults = By.xpath("//select[@id='adults']");
	By submit = By.xpath("//div[1]/form[1]/div[5]/button[1]");
	
	public void search(WebDriver driver) throws InterruptedException {
		driver.findElement(toursbtn).click();
		Thread.sleep(1000);
		driver.findElement(cookyGotItBtn).click();
	}
	
	public void date(WebDriver driver,Properties prop) {
		driver.findElement(chickin).click();
		String str = driver.findElement(month).getText();
		while(!str.equalsIgnoreCase(prop.getProperty("inmonth"))) {
			driver.findElement(nextbtn).click();
			str = driver.findElement(month).getText();
		}
		for(int i=1 ; i<=6 ; i++ ) {
			for(int j=1 ; j<=7 ; j++) {
				String str1 = driver.findElement(By.xpath("//div[11]//tr["+i+"]//td["+j+"]")).getText();
				if(str1.equals("1")) {
					for(int k = i ; k <= 6 ; k++) {
						for(int x = j ; x < 7 ; x++) {
							String str2 = driver.findElement(By.xpath("//div[11]//tr["+k+"]//td["+x+"]")).getText();
							if(str2.equals(prop.getProperty("indate"))) {
								driver.findElement(By.xpath("//div[11]//tr["+k+"]//td["+x+"]")).click();
							}
						}
					}
				}
			}
		}
	}
	
	public void Guests(WebDriver driver) {
		driver.findElement(adults).click();
		Select dropdown = new Select(driver.findElement(adults));  
		dropdown.selectByVisibleText("5 Guests"); 
	}
	
	public void tourtype(WebDriver driver) {
		driver.findElement(By.xpath("//select[@id='tourtype']")).click();
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='tourtype']")));  
		dropdown1.selectByVisibleText("Holidays");
	}
}
