package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;
import junit.framework.Assert;

public class FourTest extends Base {
	public WebDriver driver;
	@Test
	public void testFour() throws IOException, InterruptedException  {
		
		System.out.println("we changed the code");
		System.out.println();		
		System.out.println("Test Four");
		 driver = initializeDriver();
		
		driver.get("http://www.tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
		driver.close();
	}
}
