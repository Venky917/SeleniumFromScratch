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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import VenkateshAcademy.TestComponents.BaseTest;
import VenkateshAcademy.TestComponents.RetryTest;
import VenkateshAcademy.pageObjects.Cartcheckout;
import VenkateshAcademy.pageObjects.LandingPage;
import VenkateshAcademy.pageObjects.PlaceOrderpage;
import VenkateshAcademy.pageObjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTests extends BaseTest{

	    WebDriver driver;
		@Test(retryAnalyzer=RetryTest.class)
		public void LoginErrorCheck() throws Exception {
			
			driver = initializedriver();
        //String ProductName="ZARA COAT 3";
       
        
        LandingPage landpage =  new LandingPage(driver);
        landpage.Goto();
        landpage.LoginApp("killamsetty.venkatesh@gmail.com", "teal@101");
      Assert.assertEquals("Incorrect email  password.", landpage.geterrormessage());
		
		}
		@Test(enabled=false)
		public void SubmitOrderTestValidation() throws Exception {
		driver = initializedriver();
         String ProductName="ZARA COAT 3";
         //String ProductName2="ZARA COAT 33";
        LandingPage landpage =  new LandingPage(driver);
        landpage.Goto();
        landpage.LoginApp("killamsetty.venkatesh@gmail.com", "Steal@101");
		ProductCatalog ProductCatalopage  = new ProductCatalog(driver);
		List<WebElement> products = ProductCatalopage.getProductsList();
		ProductCatalopage.addproductToCart(ProductName);
		ProductCatalopage.gotoCartpage();
		Cartcheckout chkout = new Cartcheckout(driver);
		Boolean match = chkout.findmatch(ProductName);
		Assert.assertTrue(match);
		}
		
		
		
	}//div[@aria-label='Incorrect email or password.']


