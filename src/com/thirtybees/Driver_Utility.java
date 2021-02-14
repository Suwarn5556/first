package com.thirtybees;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.support.PageFactory;

public abstract class Driver_Utility  implements WebDriver {
	 
	  WebDriver driver;
	  
	public void close(WebDriver driver) {
		driver.close();

	}
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public void quiting(WebDriver driver) {
		driver.quit();

	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	
	public static void navigateToURLLoginPage(WebDriver driver) {
		
		String arg0 = "http://javabykiran.in/Other/thbees/login?back=my-account";
		driver.navigate().to(arg0);
		
		return  ;
	}
public static  void navigateToURLPasswordRecoveryPagePage(WebDriver driver) {
		
		String arg0 = "http://javabykiran.in/Other/thbees/password-recovery";
		driver.navigate().to(arg0);
		
		return  ;
	}
	
	public Navigation navigate(WebDriver driver) {
		return driver.navigate();
	}
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	public Options manageMaximize(WebDriver driver) {
		driver.manage().window().maximize();
		return null  ;
	}
	
	public Options manage(WebDriver driver) {
		return driver.manage();
	}
	
	
	
	public  Alert Alert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void alertGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
		}
	
	public String getWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles(WebDriver driver) {
		return driver.getWindowHandles();
	}
	 
	
	
	
	public void IFrame(WebDriver driver, WebElement element, String abc, int a) {
		 
		driver.switchTo().frame(a);
		driver.switchTo().frame(abc);
		driver.switchTo().frame(element);
	}
	
	public WebElement findElement(By arg0) {
		return driver.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {

		return driver.findElements(arg0);
	}

	public void get(String arg0) {
		driver.get(arg0);
	}

	 
		
		 
	
	public TargetLocator switchTo(WebDriver driver) {
		return driver.switchTo();
	}

	

	
}
