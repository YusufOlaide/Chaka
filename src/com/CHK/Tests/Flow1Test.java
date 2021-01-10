package com.CHK.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CHK.Pages.DashboardPage;
import com.CHK.Pages.HomePage;
import com.CHK.Pages.LogInPage;

public class Flow1Test {

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
	
	dashboard.clickOnExplore();
	
	Actions builder = new Actions(driver);
	 WebElement Main = driver.findElement(By.xpath("//body/div[@id='app']/main[1]/section[1]/section[1]/section[3]/div[1]/div[1]/div[1]"));
	 builder.moveToElement(Main).build().perform();
	 
	 
	 WebElement Banking = driver.findElement(By.xpath("//div[contains(text(),'Banking')]"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();",Banking );
}
	

//FROM THE QUESTION, THE NEXT STEP IS TO DESELECT NIGERIA TAG. ACTUAL SCENARIO-- NO NIGERIA TAG FOUND. Proof is in the screenshot attcahed


@AfterMethod
public void tearDown() {
	driver.quit();
	
}


}
