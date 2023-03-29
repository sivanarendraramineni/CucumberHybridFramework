package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	
	 static WebDriver driver;
	
public static WebDriver initBrower(String Browsername ) {
		
		if(Browsername.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(options);
			//WebDriver driver=new ChromeDriver();
		}else if(Browsername.equals("firefox")) {
			WebDriver driver=new FirefoxDriver();
		}else if(Browsername.equals("edge")) {
			WebDriver driver=new EdgeDriver();
		
	}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		return driver;
}
public static WebDriver getDriver() {
	
	return driver;
	
}


}
	
	
