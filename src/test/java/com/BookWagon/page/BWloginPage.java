package com.BookWagon.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BWloginPage {
	
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div[2]/div/div[3]/ul/li[1]/a/span[2]")
	WebElement myaccount;
	@FindBy(xpath = "//*[@id=\"ctl00_divLogin\"]/a[1]")
	WebElement login;
	@FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_txtEmail\"]")
	WebElement username;
	
	@FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_txtPassword\"]")
	WebElement password;
	
	@FindBy(xpath ="//*[@id=\"ctl00_phBody_SignIn_btnLogin\"]")
	WebElement loginbutton;
	
	public  BWloginPage(WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	public void login(String un, String pswd) throws InterruptedException
	{
		
		
		
		
		
		
		username.clear();
		username.sendKeys(un);
		Thread.sleep(3000);
		password.sendKeys(pswd);
		loginbutton.click();
		
	}
	
	
	
	
	
	
	
	
	
}
