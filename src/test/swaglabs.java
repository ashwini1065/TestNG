package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class swaglabs {		
		WebDriver driver;		
		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			
	driver = new ChromeDriver();
		
   driver.get("https://www.saucedemo.com/");
		
	driver.manage().window().maximize();
		
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);		
		}
	@Test
	public void LoginTest1() {
		
WebElement username = driver.findElement(By.xpath("//*[@id='user-name']"));
username.sendKeys("standard_user");
WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
Password.sendKeys("secret_sauce");
WebElement Login = driver.findElement(By.xpath("//*[@id='login-button']"));
Login.click();		
	}
	
@AfterMethod
	public void addtocart() {
		
		WebElement addcart = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
		addcart.click();
		WebElement cartbutton = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));
		cartbutton.click();
		
	}
@AfterMethod
public void close() {
	
	driver.close();
	
}
}
