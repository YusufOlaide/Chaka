package com.CHK.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

WebDriver driver;
	
	//By titleText = By.xpath("//title[contains(text(),'Chaka - Create Your Chaka Account')]");
	//By page_desc = By.xpath("//h3[contains(text(),'Create your profile')]");
	By email = By.xpath("//body/div[@id='app']/main[1]/div[1]/form[1]/div[1]/label[1]/input[1]]");
	By pwd = By.xpath("//body/div[@id='app']/main[1]/div[1]/form[1]/div[2]/label[1]/input[1]");
	By loginBtn = By.xpath("//button[contains(text(),'Login')]");
	
	
	

	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail() {
		driver.findElement(email).isDisplayed();
		driver.findElement(email).sendKeys("yusufolaideyusuf@yahoo.com");
	}
	
	public void enterPassword() {
		driver.findElement(pwd).isDisplayed();
		driver.findElement(pwd).sendKeys("Junior_97");
	}
	
	public void clickOnlogInBtn() {
		driver.findElement(loginBtn).isDisplayed();
		driver.findElement(loginBtn).click();;
	}


}
