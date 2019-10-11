package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelSearch {
	By hotel = By.xpath("//a[@href='#thhotels']");
	By name = By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']");
	By search = By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']");
	By chickIn = By.xpath("//div[@id='dpd1']//input[contains(@placeholder,'Check in')]");
	By month = By.xpath("//div[14]//div[1]//tr[1]//th[2]");
	By nextButton = By.xpath("//div[14]//div[1]//tr[1]//th[3]");
	By guests = By.xpath("//input[@id='htravellersInput']");
	By child = By.xpath("//button[@id='hchildPlusBtn']");
	
	public void chickIn(WebDriver driver,Properties prop) throws IOException {
		driver.findElement(chickIn).click();
		String str = driver.findElement(month).getText();
		while(!str.equalsIgnoreCase(prop.getProperty("inmonth"))) {
			driver.findElement(nextButton).click();
			str = driver.findElement(month).getText();
		}
		for(int i=1 ; i<=6 ; i++ ) {
			for(int j=1 ; j<=7 ; j++) {
				String str1 = driver.findElement(By.xpath("//div[14]//tr["+i+"]//td["+j+"]")).getText();
				if(str1.equals("1")) {
					for(int k = i ; k <= 6 ; k++) {
						for(int x = j ; x < 7 ; x++) {
							String str2 = driver.findElement(By.xpath("//div[14]//tr["+k+"]//td["+x+"]")).getText();
							System.out.println(str2);
							if(str2.equals(prop.getProperty("indate"))) {
								driver.findElement(By.xpath("//div[14]//tr["+k+"]//td["+x+"]")).click();
							}
						}
					}
				}
			}
		}
	}
	public void chickOut(WebDriver driver,Properties prop) throws IOException{
		String str3 = driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText();
		while(!str3.equalsIgnoreCase(prop.getProperty("outmonth"))) {
			driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[3]")).click();
			str3 = driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText();
		}
		for(int i=1 ; i<=6 ; i++ ) {
			for(int j=1 ; j<=7 ; j++) {
				String str4 = driver.findElement(By.xpath("//div[15]//tr["+i+"]//td["+j+"]")).getText();
				if(str4.equals("1")) {
					for(int k = i ; k <= 6 ; k++) {
						for(int x = j ; x < 7 ; x++) {
							String str5 = driver.findElement(By.xpath("//div[15]//tr["+k+"]//td["+x+"]")).getText();
							System.out.println(str5);
							if(str5.equals(prop.getProperty("outdate"))) {
								driver.findElement(By.xpath("//div[15]//tr["+k+"]//td["+x+"]")).click();
							}
						}
					}
				}
			}
		}
	}
	public void noOfGuest(WebDriver driver,Properties prop) {
		driver.findElement(guests).click();
		driver.findElement(child).click();
		driver.findElement(guests).click();
	}
}
