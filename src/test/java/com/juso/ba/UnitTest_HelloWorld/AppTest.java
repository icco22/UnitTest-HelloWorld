package com.juso.ba.UnitTest_HelloWorld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
    @BeforeMethod
    public void setUp() {
    	
    }
    
    @Test
    public void unitTest() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP EliteBook 8560W\\Desktop\\selenium\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		String baseUrl = "http://localhost:9095//helloWorld";
    	driver.get(baseUrl);
		Thread.sleep(3000);
		WebElement helloWorld = driver.findElement(By.xpath("//h2[contains(text(),'Hello World!')]"));
		if(helloWorld.isDisplayed()) {
			System.out.println("Test prosao");
		} else {
			System.out.println("Test pao");
		}
    }
}
