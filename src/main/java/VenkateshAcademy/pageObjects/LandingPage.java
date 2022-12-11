package VenkateshAcademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VenkateshAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement UserEmail = driver.findElement(By.cssSelector("input#userEmail"));
	//PageFactory
	
	@FindBy(css="input#userEmail")
	WebElement UserEmail;
	
	@FindBy(xpath="//div/input[@id='userPassword']")
	WebElement Userpassword;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement incorrectpassword;
	
	
	
	public void LoginApp(String username,String password) {
		
		UserEmail.sendKeys(username);
		Userpassword.sendKeys(password);
		loginBtn.click();
	}
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String geterrormessage() {
		
		waitforWebElementtoAppear(incorrectpassword);
		return  incorrectpassword.getText();
	}
}
