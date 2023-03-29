package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchresultspage {

ChromeDriver driver;
	
	public Searchresultspage(ChromeDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validhpproduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement massagetext;
	
	public void displaystatusofvalidproduct() {
		
		validhpproduct.isDisplayed();
	}
	
	public String getmassagetext() {
		
		return massagetext.getText();
	}
}
