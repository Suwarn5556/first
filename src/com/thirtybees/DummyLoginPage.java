package com.thirtybees;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 

public   class DummyLoginPage extends Driver_Utility{

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
		
		String actTitle=getTitle(driver);
	//	String actTitle = driver.getTitle();
		String expTitle = "BEE";
	
		Assert.assertEquals(actTitle, expTitle);
		System.out.println(actTitle);
		
		System.out.println(getCurrentUrl(driver));
		
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

	@Test(priority = 4)
	public void language() {

		//  //ul[@class='dropdown-menu']/li/a												//ul/li[@class='dropdown open']
		
	//	Select laung= new Select(driver.findElement(By.xpath("//div[2]/ul/li[@id=\"blocklanguages\"]/a")));
		driver.findElement(By.xpath("//ul/li[@class='dropdown']")).click();
	//	Select laung= new Select(driver.findElement(By.xpath("//ul/li[@class='dropdown open']")));
		Select laung= new Select(driver.findElement(By.xpath("//ul/li[@class='dropdown']")));
		
		laung.selectByVisibleText("English");

	//	System.out.println(laung);
		
		WebElement english = driver.findElement(By.xpath("//div[2]/ul/li[@id=\"blocklanguages\"]/a"));
		String actEnglish = english.getText();
		String expEnglish = "English";
		Assert.assertEquals(actEnglish, expEnglish);
		System.out.println(actEnglish+"  "+ expEnglish);
		
		 
		  driver.findElement(By.xpath("//div/ul[1]/li[2]/a")).click();
		   driver.findElement(By.xpath("//li[2]/ul[@class='dropdown-menu']/li/a")).click
		   (); WebElement english1=driver.findElement(By.xpath(
		 "//ul[@class='dropdown-menu']/li/a/span/text()")); String
		  actEnglish1=english1.getText(); String expEnglish1="English";
		   Assert.assertEquals(actEnglish1, expEnglish1);
		}
	
            
	@Test(priority = 5)
public void passwordRecovery() {
		
	//	navigateToURLPasswordRecoveryPagePage(driver);
		driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		
		driver.findElement(By.xpath("//div[@class='lost_password form-group']/a")).click();
//		findElement(By.xpath("//div[@class='lost_password form-group']/a")).click();
	
		
	 	WebElement passText=driver.findElement(By.className("page-subheading"));     
		String actText=passText.getText();
		String expText="FORGOT YOUR PASSWORD?";	
		
		WebElement passSubText=driver.findElement(By.xpath("//h1[@class='page-subheading']//following-sibling::p"));     
		String actSubText=passSubText.getText();
		String expSubText="Please enter the email address you used to register. We will then send you a new password.";	
		
		WebElement emailText=driver.findElement(By.xpath("//div[@class='form-group']/label"));     
		String actemailText=emailText.getText();
		String expemailText="Email address";	
		
		
		
		Assert.assertEquals(actText, expText);
		Assert.assertEquals(actSubText, expSubText);
		Assert.assertEquals(actemailText, expemailText);
		System.out.println("Expected>>>>>>"+ expText +"\n"+ "Actual>>>>>>"+ actText);
		System.out.println("Expected>>>>>>"+ expSubText +"\n"+ "Actual>>>>>>"+ actSubText);
		System.out.println("Expected>>>>>>"+ expemailText +"\n"+ "Actual>>>>>>"+ actemailText);
		
		WebElement retreiveText=driver.findElement(By.xpath("//div[@class='submit']//child::span"));     
		String actRetreiveText=retreiveText.getText();
		String expRetreiveText="Retrieve Password";
		Assert.assertEquals(actRetreiveText, expRetreiveText);
		System.out.println("Expected>>>>>>"+ expRetreiveText +"\n"+ "Actual>>>>>>"+ actRetreiveText);
		
		driver.findElement(By.id("email")).sendKeys("suwarnn5@gmail.com");
	driver.findElement(By.xpath("//div[@class='submit']//child::button")).click();
	 
	WebElement conformationText=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
	String actconformationText=conformationText.getText();
	String expconformationText="A confirmation email has been sent to your address: suwarnn5@gmail.com";
	Assert.assertEquals(actconformationText, expconformationText);
	System.out.println("Expected>>>>>>"+ expconformationText +"\n"+ "Actual>>>>>>"+ actconformationText);
	
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/nav/ul/li/a")).click();
	
	
	}         
	@Test(priority = 6)
	public void testingTitle() throws Exception {
		driver.findElement(By.xpath("//li[@id=\"blockuserinfo-login\"]/a")).click();
		String actTitle = driver.getTitle();
		String expTitle = "Login - BEE";
		Assert.assertEquals(actTitle, expTitle);
		System.out.println(actTitle+"\n"+expTitle);

		
		  driver.findElement(By.id("email")).sendKeys("suwarnn5@gmail.com");
		  driver.findElement(By.id("passwd")).sendKeys("qcXVa4/g");
		  driver.findElement(By.id("SubmitLogin")).click();
		 

		// driver.findElement(By.id("search_query_top")).sendKeys("coffee");
		// driver.findElement(By.xpath("//span/button[@title='Search']")).click();
	}

	 
	@Test(priority = 7)
	public void textAUTHENTICATION() throws Exception {
		
		driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		WebElement textAUTHENTICATION = driver.findElement(By.xpath("//div/main/h1[text()]"));
		String acttext = textAUTHENTICATION.getText();
		String exptext = "AUTHENTICATION";
		Assert.assertEquals(acttext, exptext);
		System.out.println("Expected>>>>> "+exptext+"\n"+ "Actual>>>>> "+acttext);
	}

	@Test(priority = 8)
	public void textCREATE_AN_ACCOUNT() throws Exception {
		
		 
	 	driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		WebElement textCREATE_AN_ACCOUNT = driver.findElement(By.xpath("//div/form/h3[contains(text(), 'Create')]"));
		String acttext = textCREATE_AN_ACCOUNT.getText();
		String exptext = "CREATE AN ACCOUNT"; 
		Assert.assertEquals(acttext, exptext);
		System.out.println("Expected>>>>> "+exptext+"\n"+ "Actual>>>>> "+acttext);
	}
	 

	 
	@Test(priority = 9)
	public void textPleaseEnter() throws Exception {
		driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		WebElement text = driver.findElement(By.xpath("//div[@class='form_content clearfix']/p"));
		String acttext = text.getText();
		String exptext = "Please enter your email address to create an account.";
		Assert.assertEquals(acttext, exptext);
		System.out.println("Expected>>>>> "+exptext+"\n"+ "Actual>>>>> "+acttext);
		
	}  

	@Test(priority = 10)
	public void textALREADY_REGISTERED() throws Exception {
		driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		WebElement text = driver.findElement(By.xpath("//div[2]/form/h3"));
		String acttext = text.getText();
		String exptext = "ALREADY REGISTERED?";
		Assert.assertEquals(acttext, exptext);
		System.out.println("Expected>>>>> "+exptext+"\n"+ "Actual>>>>> "+acttext);
	}

	@Test(priority = 11)
	public void forgotPassword() throws Exception {
	//	driver.navigate().to(readProperty("urlTheBee_Login", "Browser.properties"));
		
	 	driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		WebElement text = driver.findElement(By.xpath("//div[3]/a"));
		String acttext = text.getText();
		String exptext = "Forgot your password?";
		Assert.assertEquals(acttext, exptext);
		System.out.println("Expected>>>>> "+exptext+"\n"+ "Actual>>>>> "+acttext);
	}

	// Creating an account

	@Test(priority = 12)
	public void creatingAccount() {
		driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		
		driver.findElement(By.id("email_create")).sendKeys("a@gmail.com");
		 
		driver.findElement(By.id("SubmitCreate")).click();

		WebElement textCREATE_AN_ACCOUNT = driver.findElement(By.xpath("//main/div[@id='noSlide']/h1"));
		String acttextCA = textCREATE_AN_ACCOUNT.getText();
		String exptextCA = "CREATE AN ACCOUNT";
		Assert.assertEquals(acttextCA, exptextCA);
		System.out.println("Expected>>>>> "+exptextCA+"\n"+ "Actual>>>>> "+acttextCA);

		WebElement textPersonalInfo = driver.findElement(By.xpath("//form/div/h3"));
		String acttextPI = textPersonalInfo.getText();
		String exptextPI = "YOUR PERSONAL INFORMATION";
		Assert.assertEquals(acttextPI, exptextPI);
		System.out.println("Expected>>>>> "+exptextPI+"\n"+ "Actual>>>>> "+acttextPI);
	}
		/*
		  WebElement
		  textRequiredfield=driver.findElement(By.xpath("//main/div/h1/text()"));
		  String acttextRF=textRequiredfield.getText(); String
		  exptextRF="Required field"; Assert.assertEquals(acttextRF, exptextRF);
		*/

 
	@Test(priority = 13)
	public void textRequiredField() throws Exception {
		
//	driver.navigate().to(readProperty("urlTheBee_Login", "Browser.properties"));
		
	driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		driver.findElement(By.id("email_create")).sendKeys("ab@gmail.com");
		 
		driver.findElement(By.id("SubmitCreate")).click();

		List<String> expected = new ArrayList<>();
		expected.add("*Required field");
		expected.add("(Five characters minimum)");
		expected.add("*Required field");

		List<WebElement> webElements = driver.findElements(By.xpath("//form/div/h3//following::p"));
		// List<WebElement>
		// webElements=driver.findElements(By.xpath("//form/div/h3//following::p/text()"));
		ArrayList<String> actual = new ArrayList<>();

		for (WebElement el : webElements) {
			actual.add(el.getText());
		}
		System.out.println("Actual....." + actual);
		System.out.println("Expected....." + expected);

		for (int i = 0; i < expected.size(); i++) {
			System.out.println(expected.get(i) + "\n" + actual.get(i));
		}
		Assert.assertEquals(actual, expected);
		System.out.println("*********************************************************************************");

	}
	
	
	@Test (priority = 14)
	public void textLabelNames() throws Exception {
		
	//	navigateToURL(driver);					//div[@class='submit']/button
	 	driver.navigate().to("http://javabykiran.in/Other/thbees/login?back=my-account");
		driver.findElement(By.id("email_create")).sendKeys("5555555555@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='submit']/button")).click();
		Thread.sleep(1000);
		WebElement textAAA=driver.findElement(By.xpath("//div[@class='account_creation']/h3[@class='page-subheading']"));
		String actTextAAA=textAAA.getText();
		String expTextAAA="YOUR PERSONAL INFORMATION";
		System.out.println("Expected>>>>> "+expTextAAA+"\n"+ "Actual>>>>> "+actTextAAA);
		Assert.assertEquals(actTextAAA, expTextAAA);

		//	driver.findElement(By.xpath("//div/label[@class='radio-inline']/input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("ABC");
		driver.findElement(By.id("customer_lastname")).sendKeys("XYZ");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		
		
		Select date = new Select(driver.findElement(By.id("days")));
		date.selectByValue("17");
	 	Select mon= new Select(driver.findElement(By.id("months")));
		mon.selectByVisibleText("November ");
		Select ye= new Select(driver.findElement(By.id("years")));
		ye.selectByValue("1996");

		
		List<String> expected = new ArrayList<>();
		expected.add("Title");
		expected.add("Mr.");
		expected.add("Mrs.");
		expected.add("First name *");
		expected.add("Last name *");
		expected.add("Email *");
		expected.add("Password *");
		expected.add("Date of Birth");
		expected.add("Sign up for our newsletter!");
		expected.add("Receive special offers from our partners!");
	//	List<WebElement> webElements = driver.findElements(By.xpath("//div/label"));
		List<WebElement> webElements = driver.findElements(By.tagName("label"));
		
		
	//	List<WebElement> webElements = driver.findElements(By.xpath("//main[@id='center_column']//following-sibling::form/div/div/label"));
		
		ArrayList<String> actualList = new ArrayList<>();
		System.out.println(10);
		for (WebElement el : webElements) {
			actualList.add(el.getText());			
		}
		System.out.println("Expected....." + expected);
		System.out.println("Actual....." + actualList);
	
		for (int i = 0; i < expected.size(); i++) {
			System.out.println(expected.get(i) + "\n" + actualList.get(i));
		} 
		System.out.println("Expected>>>>> "+expected+"\n"+ "Actual>>>>> "+actualList);
		Assert.assertEquals(actualList, expected);	 
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
		
		driver.findElement(By.id("submitAccount")).click();
		WebElement text=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		
		String actText=text.getText();
		String extText="Your account has been created.";

		Assert.assertEquals(actText, extText);	 
 
		WebElement text2=driver.findElement(By.xpath("//main/p"));
		String actText2=text2.getText();
		String expText2="Welcome to your account. Here you can manage all of your personal information and orders.";
		Assert.assertEquals(actText2, expText2);
		System.out.println("Expected>>>>>"+actText2+"\n"+ "Actual>>>>>"+expText2);
	
	 
		WebElement homeText=driver.findElement(By.xpath("//ul/li/a[contains(text(),'Home')]"));
		String actHomeText=homeText.getText();
		String expHomeText="← Home";
		Assert.assertEquals(actHomeText, expHomeText);
		System.out.println("Expected>>>>>"+expHomeText+"\n"+ "Actual>>>>>"+actHomeText);
		driver.findElement(By.xpath("//ul/li/a[contains(text(),'Home')]")).click();
		WebElement profileName=driver.findElement(By.xpath("//li[@id='blockuserinfo-customer']/a/span"));
		System.out.println(profileName+"-----Acount Create Successfully");
		driver.findElement(By.xpath("//li[@id='blockuserinfo-customer']/a/span")).click();
		driver.findElement(By.id("blockuserinfo-logout")).click();
	}
	
	
	@Test(priority = 15)
	public void signIn() {
		
		driver.findElement(By.xpath("//ul/li[@id='blockuserinfo-login']/a")).click();
	driver.findElement(By.id("email")).sendKeys("a@gmail.com");	
	//		driver.findElement(By.id("email")).sendKeys("55555555h6@gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("123456");
//			driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("SubmitLogin")).click();
		
		 String actTitle = driver.getTitle();
		String expTitle = "My account - BEE";
		System.out.println("Expected>>>>>"+expTitle+"\n"+ "Actual>>>>>"+actTitle);
		Assert.assertEquals(actTitle, expTitle);
		
		
		WebElement text=driver.findElement(By.xpath("//main/h1[@class='page-heading']//following-sibling::p"));
		String actText =text.getText();
		String expText = "Welcome to your account. Here you can manage all of your personal information and orders.";
		Assert.assertEquals(actTitle, expTitle);
		System.out.println(actText+"\n"+expText);
		
		
		
		List<String> expected = new ArrayList<>();
		
		expected.add("Add my first address");
		expected.add("Order history and details");
		expected.add("My credit slips");		
		expected.add("My addresses");
		expected.add("My personal information");
		
		
		List<WebElement> webElements = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked stacked-menu']/li"));
	
		ArrayList<String> actualList = new ArrayList<>();
		for (WebElement el : webElements) {
			actualList.add(el.getText());
		}
		System.out.println("Expected>>>>>"+expected+"\n"+ "Actual>>>>>"+actualList);
		//	for (int i=0; i<4;i++) {
			for (int i=0; i<expected.size();i++) {
			System.out.println(expected.get(i) + "\n" + actualList.get(i));
		}
		sa.assertEquals(actualList, expected);
	//	Assert.assertEquals(actualList, expected);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
	} 
	@Test(priority = 16)
	public void updateInfo() throws Exception {
		driver.findElement(By.xpath("//ul/li[@id='blockuserinfo-login']/a")).click();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("SubmitLogin")).click();
	
		
		driver.findElement(By.xpath("//div/ul[@class='nav nav-pills nav-stacked stacked-menu']/li[1]")).click();
	 
		
		//Text [YOUR ADDRESS]

		WebElement yourAddText = driver.findElement(By.xpath("//div/h1[@class='page-subheading']"));
		String actYourAddText = yourAddText.getText();
		String expYourAddText = "YOUR ADDRESS";
		System.out.println("Expected....." + expYourAddText + "\n" + "Actual....." + actYourAddText);
		Assert.assertEquals(actYourAddText, expYourAddText);
		System.out.println("*********************************************************************************************************");
		
		
		//Text [To add a new address, please fill out the form below.]

		WebElement addNewAddText = driver.findElement(By.xpath("//div/p/b"));
		String actAddNewAddText = addNewAddText.getText();
		String expAddNewAddText = "To add a new address, please fill out the form below.";
		System.out.println( "\n" +"Expected....." + expAddNewAddText + "\n" + "Actual....." + actAddNewAddText);
		Assert.assertEquals(actAddNewAddText, expAddNewAddText);
		System.out.println("*********************************************************************************************************");
		/*
		WebElement placeHolder=driver.findElement(By.id("firstname"));
		placeHolder.getTagName();
		*/
		
		List<String> expected = new ArrayList<>();
		expected.add("First name *");
		expected.add("Last name *");
		expected.add("Company");		
		expected.add("Address *");
		expected.add("Address (Line 2)");
		expected.add("City *");		
		expected.add("State *");
		expected.add("Zip/Postal Code *");
		expected.add("Country *");		
		expected.add("Home phone **");
		expected.add("Mobile phone **");
		expected.add("");
		expected.add("Additional information");		
		expected.add("Please assign an address title for future reference. *");
		
		List<WebElement> webElements = driver.findElements(By.xpath("//div/label"));
		ArrayList<String> actualList = new ArrayList<>();
		for (WebElement el : webElements) {
			actualList.add(el.getText());
		}
		System.out.println("Expected....." + expected);
		System.out.println("Actual....." + actualList);
	

		for (int i = 0; i < expected.size(); i++) {
			System.out.println(expected.get(i) + "\n" + actualList.get(i));
		}
		Assert.assertEquals(actualList, expected);
		System.out.println("*********************************************************************************************************");
			
		// Required field
		
		WebElement requiredFieldText=driver.findElement(By.xpath("//p[@class='help-block required']"));
		String actrequiredFieldText=requiredFieldText.getText();
		String exprequiredFieldText="** You must register at least one phone number.";
		System.out.println("Expected....." + exprequiredFieldText+"\n"+"Actual....." + actrequiredFieldText);
		Assert.assertEquals(actrequiredFieldText, exprequiredFieldText);
		System.out.println("*********************************************************************************************************");
		
		//Text [You must register at least one phone number.]
		
		WebElement mustRegisterText=driver.findElement(By.xpath("//p[@class='help-block required']"));
		String actRegisterText=mustRegisterText.getText();
		String expRegisterText="** You must register at least one phone number.";
		System.out.println("Expected....." + expRegisterText+"\n"+"Actual....." + actRegisterText);
		Assert.assertEquals(actRegisterText, expRegisterText);
		System.out.println("*********************************************************************************************************");
		
		//Company
		driver.findElement(By.id("company")).sendKeys("SRG");
		
		//Address1
		driver.findElement(By.id("address1")).sendKeys("6H");
		
		//Address2
		driver.findElement(By.id("address2")).sendKeys("5Q");
		
		//city
		driver.findElement(By.id("city")).sendKeys("Washington");
		
		//state
		Select state=new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Washington");
				
		//Zip/Postal Code *
		driver.findElement(By.id("postcode")).sendKeys("00356");
		
		//Country 
		Select country=new Select(driver.findElement(By.id("id_country")));
		country.selectByVisibleText("United States");
		
		//Home phone 
		driver.findElement(By.id("phone")).sendKeys("565656");
	
		//Mobile phone 
		driver.findElement(By.id("phone_mobile")).sendKeys("356356356");
		
		//Additional information
		driver.findElement(By.id("other")).sendKeys("abcde fghij klmnu");
			
		//address reference
		driver.findElement(By.id("alias")).sendKeys("  This My New Address");
			
		//save
		driver.findElement(By.id("submitAddress")).click();
		
		WebElement givenText=driver.findElement(By.xpath("//div[@class='addresses']/p/strong"));
		String actGivenText=givenText.getText();
		String expGivenText="Your addresses are listed below.";
		Assert.assertEquals(actGivenText, expGivenText);
		System.out.println("Expected>>>>>"+expGivenText+"\n"+ "Actual>>>>>"+actGivenText);
		
		 driver.findElement(By.xpath("//main[@id=\"center_column\"]/nav/ul/li/a")).click();
	}
	@Test(priority = 17)   
	public void myCreditSlipsSection() throws Exception {
		driver.findElement(By.xpath("//ul/li[@id='blockuserinfo-login']/a")).click();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked stacked-menu']/li[2]/a")).click();
		
		WebElement creditSlipsText=driver.findElement(By.xpath("//h1[@class='page-heading']"));
		String actCreditSlipsText=creditSlipsText.getText();
		String expCreditSlipsText="CREDIT SLIPS";
		Assert.assertEquals(actCreditSlipsText, expCreditSlipsText);
		System.out.println("Expected>>>>> "+expCreditSlipsText+"\n"+ "Actual>>>>> "+actCreditSlipsText);
		System.out.println("*********************************************************************************************************");
		
		
		WebElement subText=driver.findElement(By.xpath("//h1[@class='page-heading']//following::p/b"));
		String actSubText=subText.getText();
		String expSubText="Credit slips you have received after canceled orders.";
		Assert.assertEquals(actSubText, expSubText);
		System.out.println("Expected>>>>> "+expSubText+"\n"+ "Actual>>>>> "+actSubText);
		System.out.println("*********************************************************************************************************");
		
		
		WebElement givenText=driver.findElement(By.xpath("//div[@class='alert alert-warning']"));
		String actGivenText=givenText.getText();
		System.out.println(actGivenText);
		
		String actTitle=getTitle(driver);
		String expTitle="Credit slip - BEE";
		Assert.assertEquals(actTitle, expTitle);
		System.out.println("Expected>>>>> "+expTitle+"\n"+ "Actual>>>>> "+actTitle);
		
		WebElement submitButtonText=driver.findElement(By.xpath("//main[@id=\"center_column\"]/nav/ul/li/a"));
		String actSubmitButtonText=submitButtonText.getText();
		String expSubmitButtonText="← Back to your account";
		Assert.assertEquals(actSubmitButtonText, expSubmitButtonText);
		System.out.println("Expected>>>>> "+expSubmitButtonText+"\n"+ "Actual>>>>> "+actSubmitButtonText);
		
		driver.findElement(By.xpath("//main[@id='center_column']/nav/ul/li/a")).click();
	}
	@Test(priority = 18)   //div[@class='col-xs-12 col-sm-6 address']//ul/li/span
	public void myAddressesSection() {
		driver.findElement(By.xpath("//ul/li[@id='blockuserinfo-login']/a")).click();
		driver.findElement(By.id("email")).sendKeys("suwarnn5@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked stacked-menu']/li[3]/a")).click();
		
		
		// Title
		
		String actTitle=driver.getTitle();
		String expTitle="Addresses - BEE";
		System.out.println("Expected>>>>> "+expTitle+"\n"+ "Actual>>>>> "+actTitle);
		System.out.println("*********************************************************************************************************");
		
		
		// MY ADDRESSES
		WebElement myAddressesText=driver.findElement(By.xpath("//main[@id='center_column']/h1"));
		String actMyAddressesText=myAddressesText.getText();
		String expMyAddressesText="MY ADDRESSES";
		Assert.assertEquals(actMyAddressesText, expMyAddressesText);
		System.out.println("Expected>>>>> "+expMyAddressesText+"\n"+ "Actual>>>>> "+actMyAddressesText);
		System.out.println("*********************************************************************************************************");
		
		
		
		// Please configure your default billing and delivery addresses
		WebElement pleaseConfigureText=driver.findElement(By.xpath("//main[@id='center_column']/p"));
		String actPleaseConfigureText=pleaseConfigureText.getText();
		String expPleaseConfigureText="Please configure your default billing and delivery addresses when placing an order. You may also add additional addresses, which can be useful for sending gifts or receiving an order at your office.";
		Assert.assertEquals(actPleaseConfigureText, expPleaseConfigureText);
		System.out.println("Expected>>>>> "+expPleaseConfigureText+"\n"+ "Actual>>>>> "+actPleaseConfigureText);
		System.out.println("*********************************************************************************************************");
		
		
	// All Given text on page
		List<WebElement> webElements = driver.findElements(By.xpath("//main[@id='center_column']"));
		ArrayList<String> actualList = new ArrayList<>();
		for (WebElement el : webElements) {
			actualList.add(el.getText());
		}
	//	System.out.println("Expected....." + expected);
		System.out.println("Actual....." + actualList);
		System.out.println("*********************************************************************************************************");
		
		driver.findElement(By.xpath("//main[@id='center_column']/nav/ul/li/a")).click();
		
	}
	@Test(priority = 19)   //div[@class='col-xs-12 col-sm-6 address']//ul/li/span
	public void myPersonalInformationSection() {
		driver.findElement(By.xpath("//ul/li[@id='blockuserinfo-login']/a")).click();
		driver.findElement(By.id("email")).sendKeys("suwarnn5@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked stacked-menu']/li[4]/a")).click();
	
		// Title
		
				String actTitleIdentity=driver.getTitle();
				String expTitleIdentity="Identity - BEE";
				System.out.println("Expected>>>>> "+expTitleIdentity+"\n"+ "Actual>>>>> "+actTitleIdentity);
				System.out.println("*********************************************************************************************************");
				
		
		// All Given text on page
				List<WebElement> webElements = driver.findElements(By.xpath("//div[@id='columns']"));
				ArrayList<String> actualList = new ArrayList<>();
				for (WebElement el : webElements) {
					actualList.add(el.getText());
				}
			//	System.out.println("Expected....." + expected);
				System.out.println("Actual....." + actualList);
				System.out.println("*********************************************************************************************************");
				
				driver.findElement(By.xpath("//main[@id='center_column']/nav/ul/li/a")).click();
	driver.findElement(By.xpath("//div[@id='my-account-menu']//following::nav/ul[@class='pager']/li/a")).click();
	// Title
	
			String actTitleMain=driver.getTitle();
			String expTitleMain="BEE";
			System.out.println("Expected>>>>> "+expTitleMain+"\n"+ "Actual>>>>> "+actTitleMain);
			System.out.println("*********************************************************************************************************");
			
	
	}
} 
