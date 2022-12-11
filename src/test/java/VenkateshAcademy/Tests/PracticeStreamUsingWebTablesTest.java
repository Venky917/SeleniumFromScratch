package VenkateshAcademy.Tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeStreamUsingWebTablesTest {
	
	@Test
	public void WebTablesStream() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	//	driver.findElement(By.xpath("//div/a[2]")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/th[1]")));
		element.click();
		List<WebElement> rowelements = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
	List<String> originalList = rowelements.stream().map(s->s.getText()).collect(Collectors.toList());
	List<String> SortedList = originalList.stream().sorted().collect(Collectors.toList());
	Assert.assertTrue(originalList.equals(SortedList));
	System.out.println("Products are in sorted order");
	List<String> price;
	
	
	do {
		
	List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
	 price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
	 price.forEach(a -> System.out.println(a));

	 if(price.size()<1)

	 {

	 driver.findElement(By.cssSelector("[aria-label='Next']")).click();

	 }

	 }while(price.size()<1);
}



	 private static String getPriceVeggie(WebElement s) {

	 // TODO Auto-generated method stub

	 String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();



	 return pricevalue;

	 }

	 }
