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
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Homepage;
import pages.Searchresultspage;

public class Search {
	
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

	private Homepage homepage;
	private Searchresultspage searchresultspage;
	
	@Given("user navigate to search bar")
	public void user_navigate_to_search_bar() {
		
		
		
	    
	}

	@When("user enter valid product {string} in search field")
	public void user_enter_valid_product_in_search_field(String validproduct) {
		
		 homepage=new Homepage(driver);
		 homepage.entervalidpodonsearchbox(validproduct);
		
	    
	}

	@When("user click on search button")
	public void user_click_on_search_button() {
		
		
		homepage.clickonsearchbutton();
		
	  
	}

	@Then("user get valid product in reults")
	public void user_get_valid_product_in_reults() {
		
		 searchresultspage=new Searchresultspage(driver);
		 searchresultspage.displaystatusofvalidproduct();
		
		
	    	}

	@When("user enter invalid product {string} in search field")
	public void user_enter_invalid_product_in_search_field(String invalidproduct) {
		
		homepage=new Homepage(driver);
		 homepage.entervalidpodonsearchbox(invalidproduct);
	}

	@Then("user get warning massage")
	public void user_get_warning_massage() {
		
		searchresultspage=new Searchresultspage(driver);
		
		Assert.assertEquals("There is no product that matches the search criteria.", searchresultspage.getmassagetext());
		
	    
	}

	@When("user not enter any product in search field")
	public void user_not_enter_any_product_in_search_field() {
	    
		homepage=new Homepage(driver);
	}
}
