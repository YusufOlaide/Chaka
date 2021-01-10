package com.CHK.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	
	WebDriver driver;
	
	By signup_btn = By.xpath("//header/nav[1]/ul[1]/li[2]/a[1]");
	By login_btn = By.xpath("//header/nav[1]/ul[1]/li[1]/a[1]");
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clicksignup_btn() {
		driver.findElement(signup_btn).isDisplayed();
		driver.findElement(signup_btn).click();
	}
	
	public void clicklogin_btn() {
		driver.findElement(login_btn).isDisplayed();
		driver.findElement(login_btn).click();
	}
	
}
