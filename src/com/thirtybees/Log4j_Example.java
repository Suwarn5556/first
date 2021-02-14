package com.thirtybees;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Log4j_Example {
	
	
	WebDriver driver;
	SoftAssert sa=new SoftAssert();
	
	public static String readProperty(String key, String file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
	}
	/*
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript(Window.scroll, arg1)
	*/  
	@BeforeMethod
	public void loadUrl() throws Exception {
		System.setProperty("webdriver.chrome.driver", readProperty("chromeBrowser", "Browser.properties"));
		driver = new ChromeDriver();
	 
	driver.get(readProperty("urlTheBeePasswordRecovery", "Browser.properties"));
	// driver.get("https://javabykiran.in/Other/thbees/");
		 
		Thread.sleep(2000);
	
	//	manageMaximize(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	/*
	  @AfterMethod
	  public void closeUrl() throws Exception {
		  driver.close(); 
	//	 quiting(driver);
		  }
	*/

	@Test(priority = 1)
	public void Title() {
		
		String actTitle=driver.getTitle();
	//	String actTitle = driver.getTitle();
		String expTitle = "BEE";
	
		Assert.assertEquals(actTitle, expTitle);
		System.out.println(actTitle);
		
//		System.out.println(getPageSource(driver));
		
		 
	}

	@Test(priority = 2)
	public void imgLogo() {
		
		WebElement logo = driver.findElement(By.xpath("//div[@id='shop-logo']/a/img"));
		Assert.assertEquals(logo.isDisplayed(), true);
 

	}

	@Test(priority = 3)
	public void waterMark() {
		WebElement watermark = driver.findElement(By.id("search_query_top"));
		 
		
		String placeholder = watermark.getAttribute("Placeholder");
		System.out.println("Expected watermark >>>>>"+"Search" +"\n"+ "Actual watermark >>>>> "+placeholder);
		Assert.assertEquals(placeholder, "Search");
		
	}

}
