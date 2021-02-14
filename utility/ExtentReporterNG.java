package com.jbk.utility;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
       static  ExtentReports extent;
       ExtentTest test;
     
  public static ExtentReports getObject()
  {
	String path= System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("JBK offline Project Report");
	reporter.config().setDocumentTitle("Test Results");
	
	extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester","JBK");
	return extent;
  }

}
