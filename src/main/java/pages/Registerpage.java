package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

	
ChromeDriver driver;
	
	public Registerpage(ChromeDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement Firstname;
	
	@FindBy(id="input-lastname")
	private WebElement Lastname;
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-telephone")
	private WebElement Telephone;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(id="input-confirm")
	private WebElement Confirmpass;
	
	@FindBy(name="agree")
	private WebElement Privacypolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	
	@FindBy(name="newsletter")
	private WebElement Yestonewsletter;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicatewarningmassage;
	
	
	public void enterfirstname(String firstname) {
		
		 Firstname.sendKeys(firstname);
	}
	
	public void enterlastname(String secondname) {
		
		 Lastname.sendKeys(secondname);
	}
	
	public void enteremail(String email) {
		
		 Email.sendKeys(email);
	}
	
	public void entertelephone(String telephone) {
		
		Telephone.sendKeys(telephone);
	}
	
	public void enterpassword(String password) {
		
		Password.sendKeys(password);
	}
	
	public void enterconfirmpass(String confirmpassword) {
		
		Confirmpass.sendKeys(confirmpassword);
	}
	
	public void clickonprivacypolicy()
	{
		Privacypolicy.click();
		
	}
	
	public void clickoncontinuebutton() {
		
		continuebutton.click();
	}
	
	public void clickyestonewsletter() {
		
		Yestonewsletter.click();
	}
	
	public String getduplicatewarningmassage() {
		
		return duplicatewarningmassage.getText();
	}
	
}



