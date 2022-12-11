package VenkateshAcademy.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchResultsTests {
	
	
	@Test
	public void amazonsearch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	     WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String str = "iphone 13 pro max 128gb";
		String Expectedstr= "2018 Apple iPad Pro (12.9-inch, Wi-Fi + Cellular, 256GB) - Space Gray (Renewed)";
		str.toUpperCase();
			
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#twotabsearchtextbox")));
		//WebElement ele = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		ele.sendKeys(str);
		Thread.sleep(5000);
		List<WebElement> SearchSuggestions = driver.findElements(By.cssSelector(".s-suggestion"));
		//List<String> SearchStrings = SearchSuggestions.stream().map(s->s.getText()).collect(Collectors.toList());
		//SearchStrings.stream().forEach(s->System.out.println(s));
		
		//System.out.println(SearchStrings.size());
    WebElement ele1 = SearchSuggestions.stream().filter(s->s.getText().equalsIgnoreCase(str)).findFirst().orElse(null);
	ele1.click();
	
	//List<WebElement> ResultSearch = driver.findElements(By.cssSelector(".a-size-medium"));
	
	//List<String> SearchStrings = ResultSearch.stream().map(p->p.getText()).collect(Collectors.toList());
	//SearchStrings.stream().forEach(p->System.out.println(p));
	
	//List<WebElement> ResultSearch = driver.findElements(By.cssSelector(".a-size-mini"));
	
		//List<String> SearchStrings = ResultSearch.stream().map(p->p.findElement(By.cssSelector("span")).getText()).collect(Collectors.toList());
		//SearchStrings.stream().forEach(p->System.out.println(p));
		//System.out.println(SearchStrings.size());
	Boolean flag=false;
	while(!flag) {
		List<WebElement> ResultSearch = driver.findElements(By.cssSelector(".a-size-mini"));
		WebElement ele2 = ResultSearch.stream().filter(p->p.findElement(By.cssSelector("span")).getText().equalsIgnoreCase(Expectedstr)).findFirst().orElse(null);
	    if(ele2!=null) {
		ele2.click();
	
		flag=true;
        break;
		}
	
	////h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']
	
	
	if(!flag) {
		WebElement nextpagebtn = driver.findElement(By.cssSelector(".s-pagination-item:last-child"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",nextpagebtn);
		nextpagebtn.click();
		Thread.sleep(10000);
		ResultSearch.clear();
	}
	}
	
	}
}
