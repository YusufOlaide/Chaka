package com.CHK.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

	WebDriver driver;
	
	By titleText = By.xpath("//title[contains(text(),'Chaka - Create Your Chaka Account')]");
	By page_desc = By.xpath("//h3[contains(text(),'Create your profile')]");
	By email = By.xpath("//input[@placeholder='Email Address']");
	By create_pwd = By.xpath("//body/div[@id='app']/main[1]/div[1]/form[1]/div[2]/label[1]/input[1]");
	By confirm_pwd = By.xpath("//body/div[@id='app']/main[1]/div[1]/form[1]/div[3]/label[1]/input[1]");
	By signupBtn = By.xpath("//option[contains(text(),'Lagos')]");
	By verificationMessage = By.xpath("//small[contains(text(),'We have sent you an email with a link to verify yo')]");
	By navToSite = By.xpath("//a[contains(text(),'Continue to site')]");
	
	

	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String signupPageTitle() {
		return driver.findElement(titleText).getText();
		
	}
	
	public String page_description() {
		return driver.findElement(page_desc).getText();
		
	}
	
	public void enterEmail() {
		driver.findElement(email).isDisplayed();
		driver.findElement(email).sendKeys("yoy5@yahoo.com");
	}
	
	public void enterPassword() {
		driver.findElement(create_pwd).isDisplayed();
		driver.findElement(create_pwd).sendKeys("Junior_61");
	}
	public void enterPasswordAgain() {
		driver.findElement(confirm_pwd).isDisplayed();
		driver.findElement(confirm_pwd).sendKeys("Junior_61");
	}
	
	public void clickOnSignUpBtn() {
		driver.findElement(signupBtn).isDisplayed();
		driver.findElement(signupBtn).click();;
	}

	public String verification_message() {
		return driver.findElement(verificationMessage).getText();
		
	}
	
	public String navigateToHomePage() {
		return driver.findElement(navToSite).getText();
		
	}

}
