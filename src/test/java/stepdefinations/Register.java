package stepdefinations;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import factory.DriverSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Accountpage;
import pages.Accountsuccesspage;
import pages.Homepage;
import pages.Loginpage;
import pages.Registerpage;

public class Register {
	
	ChromeDriver driver;
	@Before
	public void setup(){
		
		
		  //  DriverSetup.initBrower("chrome");
		  // driver=DriverSetup.getDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		//WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("http://tutorialsninja.com/demo/");
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
	private Registerpage registerpage;
	private Accountsuccesspage accountsuccesspage;

	@Given("user navigate to registration page")
	public void user_navigate_to_registration_page() {
		
		homepage=new Homepage(driver);
		homepage.clickonMyaccount();
		homepage.clickonRegister();
		
	  
	}

	@When("user enter the details into fields")
	public void user_enter_the_details_into_fields(DataTable dataTable) {
		
	Map<String, String> datamap = dataTable.asMap(String.class,String.class);
	
	registerpage=new Registerpage(driver);
	
	registerpage.enterfirstname(datamap.get("firstname"));
	registerpage.enterlastname(datamap.get("secondname"));
	registerpage.enteremail(datamap.get("email"));
	registerpage.entertelephone(datamap.get("telephone"));
	registerpage.enterpassword(datamap.get("password"));
	registerpage.enterconfirmpass(datamap.get("confirmpassword"));
		    
	}

	@When("user selects privacy policy")
	public void user_selects_privacy_policy() {
		
		registerpage.clickonprivacypolicy();
		
		
	    
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		registerpage.clickoncontinuebutton();
		
	    
	}

	@Then("user account created successfully")
	public void user_account_created_successfully() {
		
		accountsuccesspage=new Accountsuccesspage(driver);
		
		
	   Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getpageheading() );
	}

	@When("user selects yes for newletter")
	public void user_selects_yes_for_newletter() {
	    
		registerpage.clickyestonewsletter();
		
		
	}

	@Then("user get duplicate email warning")
	public void user_get_duplicate_email_warning() {
		
		registerpage=new Registerpage(driver);

		
		Assert.assertTrue(registerpage.getduplicatewarningmassage().contains("Warning: E-Mail Address is already registered!"));
	   
	}

	@When("user not enter any details")
	public void user_not_enter_any_details() {
		
		registerpage=new Registerpage(driver);
		
		registerpage.enterfirstname("");
		registerpage.enterlastname("");
		registerpage.enteremail("");
		registerpage.entertelephone("");
		registerpage.enterpassword("");
		registerpage.enterconfirmpass("");
	   
	}

	
	@Then("user get warning massage for mandatory fields")
	public void user_get_warning_massage_for_mandatory_fields() {
		registerpage=new Registerpage(driver);

		
		Assert.assertTrue(registerpage.getduplicatewarningmassage().contains("Warning: E-Mail Address is already registered!"));
	    
	}

}

