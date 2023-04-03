package stepdefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import factory.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Accountpage;
import pages.Homepage;
import pages.Loginpage;

public class Login {
	
	ChromeDriver driver;
	@Before
	public void setup(){
		
		
		  
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://tutorialsninja.com/demo/");
			
		}
	@After
	public void close(Scenario scenario) {
		
		
		String scenarioname=scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) {
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", scenarioname);
		}
		
		driver.quit();
	}
		
	
	private Loginpage loginpage;
	private Homepage homepage;
	private Accountpage accountpage;
	

	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		
		
		homepage=new Homepage(driver);
		homepage.clickonMyaccount();
		homepage.clickonLogin();
	
		
	}
	@When("user entered valid email address {string} into email field")
	public void user_entered_valid_email_address_into_email_field(String email) {
		
		loginpage=new Loginpage(driver);
		
		loginpage.enteremail(email);
		
	    
	}

	@When("user enter valid password {string} into password fied")
	public void user_enter_valid_password_into_password_fied(String password) {
		
		loginpage.enterpassword(password);
			    
	}

	@When("click on login button")
	public void click_on_login_button() {
		
		loginpage.clickonLoginbutton();
		
	    
	}

	@Then("user loggedin successfully")
	public void user_loggedin_successfully() {
		accountpage=new Accountpage(driver);
		
	    Assert.assertTrue(accountpage.displaystatusofEdityouraccountinformation());
	}
	
	@When("user entered invalid email {string} into email field")
	public void user_entered_invalid_email_into_email_field(String invalidemail) {
		
		loginpage=new Loginpage(driver);
		loginpage.enteremail(invalidemail);
			}

	@When("user entered invalid password {string} into password field")
	public void user_entered_invalid_password_into_password_field(String invalidpassword) {
		
		loginpage.enterpassword(invalidpassword);
		
	    	}

	@Then("user get warning massage for invalid credentials")
	public void user_get_warning_massage_for_invalid_credentials() {
		Assert.assertTrue(loginpage.getwarningmassagetext().contains("Warning: No match for E-Mail Address and/or Password."));
	    
	}

	@When("user not entered any email")
	public void user_not_entered_any_email() {
		
		loginpage=new Loginpage(driver);
		loginpage.enteremail("");
	    	}

	@When("user not enter any password")
	public void user_not_enter_any_password() {
		
		loginpage.enterpassword("");
	    	}

	}
	

