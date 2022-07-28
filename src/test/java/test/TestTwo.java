package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class TestTwo extends Base {
	public WebDriver driver;
	@Test
	public void testTwo() throws IOException, InterruptedException {
		System.out.println("Test Two");
		
		 driver = initializeDriver();
		
		driver.get("http://www.tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		driver.close();
	}

	
}
