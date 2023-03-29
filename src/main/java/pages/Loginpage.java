package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	ChromeDriver driver;
	
	public Loginpage(ChromeDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Loginbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement Warningmassage;
	
	

	
	public void enteremail(String email ) {
		
		emailField.sendKeys(email);
	}
	
	public void enterpassword(String password) {
		
		passwordField.sendKeys(password);
	}
	
	public void clickonLoginbutton() {
		Loginbutton.click();
	}
	
	public String getwarningmassagetext() {
		
		return Warningmassage.getText();
	}
}


