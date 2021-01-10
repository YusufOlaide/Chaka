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

import com.CHK.Pages.DashboardPage;
import com.CHK.Pages.HomePage;
import com.CHK.Pages.LogInPage;
import com.CHK.Pages.WalletsPage;


public class FundingProcessTest {

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
	public void ValidateSearch() throws Exception {
		driver.navigate().to("https://chaka.ng/");
		
		HomePage home = new HomePage(driver);

		home.clicklogin_btn();
		
	//.....................................................................................................//
		
		wait = new WebDriverWait(driver,3000);
		
		LogInPage login = new LogInPage(driver);

		login.enterEmail();
		login.enterPassword();
		login.clickOnlogInBtn();
		
		
	//................................................................//
		
		wait = new WebDriverWait(driver, 3000);
		
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				
					if(driver.getCurrentUrl().contains("https://chaka.ng/dashboard/portfolio")) {
						return true;
					}
					else {
						return false;
					}			
			}
		});
		
	DashboardPage dashboard = new DashboardPage(driver);
	
	dashboard.clickOnAccount();
	dashboard.clickOnWallet();
	
	
	Thread.sleep(5000);
	
	WalletsPage wallet = new WalletsPage(driver);
	
	wallet.clickOnLocalWalletValueFundBtn();
	
	Thread.sleep(3000);
	
	wallet.enterAmount();
	wallet.continue_btn();
	
	Thread.sleep(3000);
	
	String account_Number = wallet.account_Number();
	Assert.assertEquals(account_Number.contains("0467937290"), true);
	
		
	}
	
		
	
				
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	
}
