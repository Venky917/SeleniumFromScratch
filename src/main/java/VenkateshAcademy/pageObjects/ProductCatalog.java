package VenkateshAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VenkateshAcademy.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".ng-animating")
	WebElement Spinner;
	
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By  toastmessage = By.cssSelector("#toast-container");
	
	public  List<WebElement> getProductsList() {
		
		waitforElementtoAppear(productsBy);
		return products;
	}
	public WebElement getproductByName(String ProductName) {
		
		WebElement prod = getProductsList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addproductToCart(String ProductName) {
		
		WebElement prod = getproductByName(ProductName);
		prod.findElement(addtocart).click();
		waitforElementtoAppear(toastmessage);	
		
		waitforElementtoDisAppear(Spinner);
	}
	

	
	
}
