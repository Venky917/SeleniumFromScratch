package VenkateshAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VenkateshAcademy.pageObjects.OrderPage;

public class AbstractComponent {
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement CartBtn;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement Orderbtn;
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitforElementtoAppear(By findby) {
	
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(findby));

	}
	
	public void waitforWebElementtoAppear(WebElement ele) {
		
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait4.until(ExpectedConditions.visibilityOf(ele));

	}
	
	public void waitforElementtoDisAppear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void gotoCartpage() {
		CartBtn.click();
	}
	
	public void gotoOrderpage() {
		Orderbtn.click();
	}
	
	public String WaitandGetText(By findby) {
		
		WebDriverWait wait3 =new WebDriverWait(driver,Duration.ofSeconds(5));
		String confirmMessage = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary"))).getText();
        return confirmMessage;
	}
	
}
