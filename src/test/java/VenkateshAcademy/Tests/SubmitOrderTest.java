package VenkateshAcademy.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import VenkateshAcademy.TestComponents.BaseTest;
import VenkateshAcademy.pageObjects.Cartcheckout;
import VenkateshAcademy.pageObjects.LandingPage;
import VenkateshAcademy.pageObjects.OrderPage;
import VenkateshAcademy.pageObjects.PlaceOrderpage;
import VenkateshAcademy.pageObjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{

	    WebDriver driver;
		@Test(dataProvider="getdata")
		public void submitorder(HashMap<String,String> input) throws Exception {
			
			driver = initializedriver();
             
        LandingPage landpage =  new LandingPage(driver);
        landpage.Goto();
        landpage.LoginApp(input.get("email"), input.get("password"));
		ProductCatalog ProductCatalopage  = new ProductCatalog(driver);
		List<WebElement> products = ProductCatalopage.getProductsList();
		ProductCatalopage.addproductToCart(input.get("ProductName"));
		ProductCatalopage.gotoCartpage();
		Cartcheckout chkout = new Cartcheckout(driver);
		Boolean match = chkout.findmatch(input.get("ProductName"));
		Assert.assertTrue(match);
		chkout.checkout();
		PlaceOrderpage placeOrder = new PlaceOrderpage(driver);
		String confirmMessage = placeOrder.FillIndetailsandClickPlaceOrderBtn();
				
	//	PlaceorderBtn.click();
		Thread.sleep(3000);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		}
		
		@Test(dependsOnMethods= {"submitorder"},dataProvider="getdata")
		public void OrderHistory(HashMap<String,String> input) throws Exception {
			
			    
			    driver = initializedriver();
			    LandingPage landpage =  new LandingPage(driver);
		        landpage.Goto();
		        landpage.LoginApp(input.get("email"), input.get("password"));
		        landpage.gotoOrderpage();
		        OrderPage orderpage = new OrderPage(driver);
		      //  String ProductName="ZARA COAT 3";
		        Boolean match2 = orderpage.VerifyOrderIsPresent(input.get("ProductName"));
		        Assert.assertTrue(match2);
		}
		
		@DataProvider
		public Object[][] getdata() throws Exception {
			
//	    List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\VenkateshAcademy\\data\\purchaseorder.json");
//		return new Object[][]  {{data.get(0)}};
////	
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "killamsetty.venkatesh@gmail.com");
			map.put("password", "Steal@101");
			map.put("ProductName", "ZARA COAT 3");
			return new Object[][] { {map} };
			}
		
		
		
				
	}
