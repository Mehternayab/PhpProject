package Automation1.PHPTravels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Launch {
	
	By dropdown = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='dropdown-menu']");
	By signup = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Sign Up')]");
	By MyAccount = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]");
	WebDriver driver;
	
	public Properties pro() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Online Test\\Desktop\\Mehter Nayab\\Jars\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		this.driver = driver;
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Online Test\\Desktop\\Mehter Nayab\\PHPTravels\\src\\main\\java\\Automation1\\PHPTravels\\data.properties");
		prop.load(fis);
		return prop;
	}
	public WebDriver getDriver() {
		return driver;
	} 
	
}
