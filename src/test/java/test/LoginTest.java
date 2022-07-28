package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger log;
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
		
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url"));
		
	log = LogManager.getLogger(LoginTest.class.getName());
		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown" );
		landingPage.loginOption().click();
		log.debug("Clicked on login option" );
		
		
		Thread.sleep(40000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		
		
		AccountPage accountPage = new AccountPage(driver);
		String actualResult = null;
		
		try {
		//Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
			if(accountPage.editAccountInformationOption().isDisplayed()) {
				log.debug("User got logged in");
				actualResult = "Successfull";
		//System.out.println("Inside try block");
			}
		}catch(Exception e) {
			log.debug("User didn't log in");
			actualResult = "Failure";
			//System.out.println("Inside catch block");
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		log.info("Login Test got passed");
		
		
	}
	
	@BeforeMethod
	public void openApplication() throws IOException {
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"s.bighnesh123@gmail.com","123456","Successfull"},{"dummy@test.com","dummy","failure"}};
		return data;
	}
	
}
