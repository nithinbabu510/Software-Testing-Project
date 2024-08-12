package com.BookWagon.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BWcartpage {
	WebDriver driver;
	@FindBy(id = "inputbar")
	WebElement searchbox;
    
	@FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[1]/div[4]/div[4]/input[1]")
	WebElement addtocartbutton;
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div[2]/div/div[3]/ul/li[2]/a/span")
	WebElement cartcontainer;
	
	@FindBy(xpath = "//*[@id=\"btnTopSearch\"]")
	WebElement searchbutton;
	
	@FindBy(xpath = "//*[@id=\"ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete\"]")
	WebElement removebutton;
	
	public BWcartpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
public void addTocart(String Bookname) throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	searchbox.sendKeys(Bookname);
    searchbutton.click();
	addtocartbutton.click();
	
	
}
public void varifycartpage() throws InterruptedException
{
	Thread.sleep(3000);
	cartcontainer.click();
	Thread.sleep(3000);
	
	
}

public void removeitem()
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	removebutton.click();
	driver.navigate().refresh();
	
	
		
			
}


}
