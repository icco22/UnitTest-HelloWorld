package com.juso.ba.UnitTest_HelloWorld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * Unit test for simple App.
 */
public class AppTest2 
    
{
    @BeforeMethod
    public void setUp() {
    	
    }
    
    @Test
    public void unitTest() throws InterruptedException {
    	
    	ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\HP EliteBook 8560W\\eclipse-workspace\\UnitTest-HelloWorld\\reports\\l2.html");
    	ExtentReports extent = new ExtentReports();
    	reporter.config().setTheme(Theme.DARK);
    	extent.attachReporter(reporter);
    	ExtentTest test = extent.createTest("UnitTest");
    	
    	
    	
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP EliteBook 8560W\\Desktop\\selenium\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	test.log(Status.INFO, "Pokrecem web adresu");
		String baseUrl = "http://localhost:9095//helloWorld";
		
    	driver.get(baseUrl);
    	test.log(Status.PASS, "Pokrenuta web adresa");
		Thread.sleep(3000);
		WebElement helloWorld = driver.findElement(By.xpath("//h2[contains(text(),'Hello World!')]"));
		if(helloWorld.isDisplayed()) {
			System.out.println("Test je prosao");
			test.log(Status.FAIL, "Hello World2 nije pronađen na stranici");
			test.fail("Test je prosao!");
		} else {
			System.out.println("Test pao");
			test.log(Status.PASS, "Hello World je pronađen na stranici");
			test.pass("Test je prošao");
		}
		extent.flush();
    }
}
