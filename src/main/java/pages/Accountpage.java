package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	
ChromeDriver driver;
	
	public Accountpage(ChromeDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement Edityouraccountinformation;
	
	public boolean displaystatusofEdityouraccountinformation() {
		
		return Edityouraccountinformation.isDisplayed();
	}

}
