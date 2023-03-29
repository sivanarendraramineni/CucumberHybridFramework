
package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverSetup;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myhooks {
	
	WebDriver driver;
	@Before
	public void setup(){
		
		
		    DriverSetup.initBrower("chrome");
		   driver=DriverSetup.getDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://tutorialsninja.com/demo/");
			
		}
	@After
	public void close() {
		
		driver.quit();
	}
		
	}
	
	

