package com.CHK.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CHK.Pages.HomePage;
import com.CHK.Pages.SignUpPage;

public class SignUpTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void Initialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	}
	
	@BeforeMethod
	public void Launcher() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void ValidateSearch() {
		driver.navigate().to("https://chaka.ng/");
		
		HomePage home = new HomePage(driver);

		home.clicksignup_btn();
		
	//.....................................................................................................//
		
		wait = new WebDriverWait(driver,3000);
		
		SignUpPage signUp = new SignUpPage(driver);

		signUp.enterEmail();
		signUp.enterPassword();
		signUp.enterPasswordAgain();
		signUp.clickOnSignUpBtn();
		
		
	//................................................................//
		
		wait = new WebDriverWait(driver, 3000);
		
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				
					if(driver.getCurrentUrl().contains("https://chaka.ng/verification-sent")) {
						return true;
					}
					else {
						return false;
					}			
			}
		});
		
		String verification_message = signUp.verification_message();
		Assert.assertEquals(verification_message.contains("We have sent you an email with a link to verify your email address."), true);
		
		String navigateToHomePage = signUp.navigateToHomePage();
		Assert.assertEquals(navigateToHomePage.contains("Continue to site"), true);
		
	
		
	}
	
		
	
				
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
