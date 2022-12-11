package VenkateshAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import VenkateshAcademy.AbstractComponents.AbstractComponent;

public class Cartcheckout extends AbstractComponent{
	
	WebDriver driver;
	
	public Cartcheckout(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;
	
	public List <WebElement> getcartproducts(){
		return cartProducts;
	}
	
	public Boolean findmatch(String ProductName) {
		
		Boolean match = 	getcartproducts().stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public void checkout(){
		checkoutBtn.click();
	}
	
}
