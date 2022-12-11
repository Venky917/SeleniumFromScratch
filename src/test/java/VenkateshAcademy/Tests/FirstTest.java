package VenkateshAcademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String ProductName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		WebElement usermail = driver.findElement(By.cssSelector("input#userEmail"));
		usermail.sendKeys("killamsetty.venkatesh@gmail.com");
		WebElement password =  driver.findElement(By.xpath("//div/input[@id='userPassword']"));
				password.sendKeys("Steal@101");
		driver.findElement(By.name("login")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	WebElement ele = products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		
		ele.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait2 =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)");
		WebElement PlaceorderBtn = driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"));

		js.executeScript("arguments[0].click();",PlaceorderBtn);		
	//	PlaceorderBtn.click();
		WebDriverWait wait3 =new WebDriverWait(driver,Duration.ofSeconds(5));
		String confirmMessage = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary"))).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

		
	}

}
