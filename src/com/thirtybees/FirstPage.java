package com.thirtybees;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstPage {
 
	 WebDriver driver;
	public static String readProperty(String key, String file) throws Exception {
		 
		
		FileInputStream fis=new FileInputStream(file);
		Properties property=new Properties();
		property.load(fis);
	return property.getProperty(key);
	}
	 
	 @BeforeMethod
	 public void loadUrl() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", readProperty("chromeBrowser", "Browser.properties"));
			driver = new ChromeDriver();
			driver.get(readProperty("urlTheBee", "Browser.properties"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			
			 
	} 
	 
	 @AfterMethod
	 public void closeUrl() throws Exception {
	driver.close();
	 }
	  
	 @Test
	 public void text() throws Exception {
		 	
			driver.findElement(By.xpath("//*[@id=\"blockuserinfo-login\"]/a")).click();
			driver.findElement(By.id("email")).sendKeys("suwarnn5@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("qcXVa4/g");
			driver.findElement(By.id("SubmitLogin")).click();
			
			String actTitle=driver.getTitle();
			String expTitle="My account - My Store";
			Assert.assertEquals(actTitle, expTitle);
			
			driver.findElement(By.id("search_query_top")).sendKeys("coffee");
			driver.findElement(By.xpath("//span/button[@title='Search']")).click();
			
			
			/*
			WebElement A=driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/text()[1]"));
			String axtText=A.getText();
			*/
			/*  
			 WebElement text=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/div/h2/span/text()[1]"));
			 String actText=text.getText();
			 String expText="Our ";
			 Assert.assertEquals(actText, expText);
			*/
		
	 }
	}


 
