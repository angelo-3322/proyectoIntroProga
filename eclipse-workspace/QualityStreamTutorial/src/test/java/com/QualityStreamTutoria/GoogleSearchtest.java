package com.QualityStreamTutoria;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchtest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/intento/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
	}
	 @Test
	 public void testGooglepage() {
		 
		 WebElement searchbox = driver.findElement(By.name("q"));
		 
		 searchbox.clear();
		 
		 searchbox.sendKeys("kimetsu no yaiba");
		 
		 searchbox.submit();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 assertEquals("kimetsu no yaiba - Google Search",driver.getTitle() );
	 }
	 
	 @After
	 public void tearDown() {
		 driver.quit();
	 }
}
