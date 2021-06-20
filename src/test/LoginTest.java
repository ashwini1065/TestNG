package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
driver = new ChromeDriver();
	
driver.get("https://www.simplilearn.com/");
	
driver.manage().window().maximize();
	
driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

report = new ExtentReports("extentreports.html");
		
	}
@Test
public void LoginTest1() {
	

	test = report.startTest("Login test case");
	WebElement LoginLink = driver.findElement(By.linkText("Log in"));
	
	LoginLink.click();
	
	test.log(LogStatus.PASS, "successfully clicked on the login button");
	
	WebElement UserName = driver.findElement(By.name("user_login"));
	
	UserName.sendKeys("abc@xyz.com");
	
	test.log(LogStatus.PASS, "successfully entered the username");
	
	WebElement Password = driver.findElement(By.id("password"));
	
	Password.sendKeys("abc123");
	
	test.log(LogStatus.PASS, "successfully entered password");
	
	WebElement Rememberme = driver.findElement(By.className("rememberMe"));
	
	Rememberme.click();
	
	WebElement Login = driver.findElement(By.name("btn_login"));
	
	Login.click();
	
	test.log(LogStatus.PASS, "successfully clicked on the login link");
	
	WebElement Error = driver.findElement(By.id("msg_box"));
    
    String ActMsg = Error.getText();
    String ExpMsg = "The email or password you have entered is invalid.";
            
    Assert.assertTrue(Error.isDisplayed());
    
    try {
        Assert.assertEquals(ActMsg, ExpMsg);
        test.log(LogStatus.PASS, "Expected and Actual value matches");
        
    }catch(Throwable e) {
        test.log(LogStatus.FAIL, "Expected and Actual value does not match");
    }
}
	
@AfterMethod
public void aftermethod()
{
	report.endTest(test);
	report.flush();
	driver.close();
}
	

}

