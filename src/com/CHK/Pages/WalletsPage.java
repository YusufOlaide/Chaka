package com.CHK.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletsPage {

WebDriver driver;
	
	By fund = By.xpath("//body/div[@id='app']/main[1]/section[1]/section[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[2]/button[1]");
	By wallet = By.xpath("//a[contains(text(),'Wallets')]");
	By amount = By.xpath("//body/div[@id='app']/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/label[1]/input[1]");
	By continueBtn = By.xpath("//button[contains(text(),'Continue')]");
	By instantBankFundingPaymentMethod = By.xpath("//body/div[@id='app']/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/button[1]");
	By accountNumber = By.xpath("//strong[contains(text(),'0467937290')]");
	By withdrawal = By.xpath("//button[contains(text(),'Withdraw')]");
	By bvn = By.xpath("//body/div[@id='app']/main[1]/section[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/label[1]/input[1]");
	By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
	By error = By.xpath("//div[contains(text(),'Please check your BVN and try again')]");

	public WalletsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String LocalWalletValueFundBtn() {
		driver.findElement(fund).isDisplayed();
		return driver.findElement(fund).getText();
	}
	
	public void clickOnLocalWalletValueFundBtn() {
		driver.findElement(fund).isDisplayed();
		driver.findElement(fund).click();
	}
	
	public void enterAmount() {
		driver.findElement(amount).isDisplayed();
		driver.findElement(amount).sendKeys("12345");
	}
	
	public void continue_btn() {
		driver.findElement(continueBtn).isDisplayed();
		driver.findElement(continueBtn).click();
	}
	
	public void instant_Bank_Funding_Payment_Method() {
		driver.findElement(instantBankFundingPaymentMethod).isDisplayed();
		driver.findElement(instantBankFundingPaymentMethod).click();
	}
	
	public String account_Number() {
		driver.findElement(accountNumber).isDisplayed();
		return driver.findElement(accountNumber).getText();
	}
	
	public String withdrawalProcess() {
		driver.findElement(withdrawal).isDisplayed();
		return driver.findElement(withdrawal).getText();
	}
	
	public void clickOnwWithdrawalBtn() {
		driver.findElement(withdrawal).isDisplayed();
		driver.findElement(withdrawal).click();
	}
	
	public void enterBVN() {
		driver.findElement(bvn).isDisplayed();
		driver.findElement(bvn).sendKeys("11111111111");
	}
	
	public void clickOnSubmitBtn() {
		driver.findElement(submitBtn).isDisplayed();
		driver.findElement(submitBtn).click();
	}
	
	public String errorMessage() {
		driver.findElement(error).isDisplayed();
		return driver.findElement(error).getText();
	}
	
}
