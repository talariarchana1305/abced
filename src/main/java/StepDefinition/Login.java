package StepDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	WebDriver driver;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
		File pathToBinary = new File(Util.FIREFOX_PATH);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new WebDriver(ffBinary, firefoxProfile);
		 /*System.setProperty("webdriver.chrome.driver","C:/Users/archana/Downloads/chromedriver_win32 (2)/chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.manage().deleteAllCookies();*/
		    driver.get(" http://www.demo.guru99.com/V4/");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		
		String title = driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("Guru99 Bank Home Page", title);
	    
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr250657");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qAbUqah");
		
	   
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		WebElement loginbtn = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", loginbtn);
		 }
		
	   
	
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		String title = driver.getTitle();
		 System.out.println(title);
		 
		
		 Assert.assertEquals("Guru99 Bank Manager HomePage", title);

	   


}
}