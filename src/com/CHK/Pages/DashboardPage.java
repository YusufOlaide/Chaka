package com.CHK.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;
	
	By account = By.xpath("//span[contains(text(),'Account')]");
	By wallet = By.xpath("//a[contains(text(),'Wallets')]");
	By explore = By.xpath("//header/nav[1]/div[1]/ul[1]/li[2]/a[1]/span[1]");
	
	

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String Account() {
		driver.findElement(account).isDisplayed();
		return driver.findElement(account).getText();
	}
	
	public void clickOnAccount() {
		driver.findElement(account).isDisplayed();
		driver.findElement(account).click();
	}
	
	public void clickOnWallet() {
		driver.findElement(wallet).isDisplayed();
		driver.findElement(wallet).click();
	}
	
	public String Explore() {
		driver.findElement(explore).isDisplayed();
		return driver.findElement(explore).getText();
	}
	
	public void clickOnExplore() {
		driver.findElement(explore).isDisplayed();
		driver.findElement(explore).click();
	}
}
