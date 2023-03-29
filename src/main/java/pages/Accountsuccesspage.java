package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountsuccesspage {
	
ChromeDriver driver;
	
	public Accountsuccesspage(ChromeDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement pageheading;
	
	public String getpageheading() {
		return pageheading.getText();
		
	}
	
}
