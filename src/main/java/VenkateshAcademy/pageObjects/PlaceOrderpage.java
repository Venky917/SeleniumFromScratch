package VenkateshAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import VenkateshAcademy.AbstractComponents.AbstractComponent;

public class PlaceOrderpage extends AbstractComponent{
	
	WebDriver driver;
	
	public PlaceOrderpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	By placebtn = By.cssSelector(".ta-results");
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement placeorderbtn;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement placeorderbtn2;
	
	By Thanks = By.cssSelector(".hero-primary");
	
	public String FillIndetailsandClickPlaceOrderBtn() {
	
	Actions a = new Actions(driver);
	a.sendKeys(Country, "india").build().perform();
	waitforElementtoAppear(placebtn);
	placeorderbtn.click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,10000)");
	js.executeScript("arguments[0].click();",placeorderbtn2);
	String message = WaitandGetText(Thanks);
	return message;
	}
	
}
