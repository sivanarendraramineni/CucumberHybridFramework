package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	ChromeDriver driver;
	
	public Homepage(ChromeDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountdrop; 
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchbox;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	private WebElement searchbutton;
	

	public void clickonMyaccount() {
		MyAccountdrop.click();
	}
	
	public void clickonLogin() {
		LoginOption.click();
		
	}
	
	public void clickonRegister() {
		
		RegisterOption.click();
	}
	
	public void entervalidpodonsearchbox(String validproduct) {
		
		searchbox.sendKeys(validproduct);
	}
	
	public void clickonsearchbutton() {
		
		searchbutton.click();
	}
	
}
