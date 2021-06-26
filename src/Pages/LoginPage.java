package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.LoginTest;
import test.Baseclass;

public class LoginPage {
	
	WebDriver driver;
	ExtentReports report;
    ExtentTest test;
   
    // =====================WebElements=============================
    @FindBy(linkText= "Log in")
    WebElement LoginLink;
    
    @FindBy(name = "user_login")
    WebElement UserName;
    
    @FindBy(id = "password")
    WebElement Password;
    
    @FindBy(className = "rememberMe")
    WebElement Rememberme;
    
    @FindBy(name = "btn_login")
    WebElement Login;
    
    @FindBy(id = "msg_box")
    WebElement Error;
    
    
    // ====================Constructor===========================
    public LoginPage ()
    
    {
    	driver = LoginTest.driver;
    	report = LoginTest.report;
    	test = LoginTest.test;
    	PageFactory.initElements(driver, this);
    }
	
	//================ Methods =================================
	public void  login(String uname, String pass)
	{
	
		test = report.startTest("Login test case");
		//WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		test.log(LogStatus.PASS, "successfully clicked on the login button");
		
        //WebElement UserName = driver.findElement(By.name("user_login"));
		
		UserName.sendKeys(uname);
		
		test.log(LogStatus.PASS, "successfully entered the username");
		
		//WebElement Password = driver.findElement(By.id("password"));
		
		Password.sendKeys(pass);
		
		test.log(LogStatus.PASS, "successfully entered password");
		
    	//WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		
		Rememberme.click();
		
       //WebElement Login = driver.findElement(By.name("btn_login"));
		
		Login.click();
		
		test.log(LogStatus.PASS, "successfully clicked on the login link");
		
		//WebElement Error = driver.findElement(By.id("msg_box"));
	    
	    String ActMsg = Error.getText();
	    String ExpMsg = "The email or password you have entered is invalid.";
	            
	    Assert.assertTrue(Error.isDisplayed());
	}
	

}
