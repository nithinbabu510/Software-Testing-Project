package com.BookWagon.page;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BWhomePage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"ctl00_imglogo\"]")
	WebElement logo;

	@FindBy(xpath = "//*[@id=\"inputbar\"]")
	WebElement searchbox;

	@FindBy(xpath = "//*[@id=\"ctl00_lblTotalCartItems\"]")
	WebElement cartContainer;

	@FindBy(xpath = "//*[@id=\"ctl00_lblUser\"]")
	WebElement myAccount;
	
	@FindBy(xpath = "//*[@id=\"ctl00_divLogin\"]/a[1]")
	WebElement loginbutton;
	

	public BWhomePage(WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}


	public void validatingLogo()
	{
	boolean Bwlogo=	logo.isDisplayed();
	if(Bwlogo)
	{
		System.out.println("Logo visible");
	}
	else
	{
		System.out.println("Logo not visible");
	}
	}

	public void brokenlinks()
	{
		List<WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println("num of links="+li.size());
		
		for(WebElement temp:li)
		{
			String link =temp.getAttribute("href");
			varify(link);
		}
	}
	private void varify(String link) {
		
		
		try {
			URL ob=new URL(link);
			HttpURLConnection con=(HttpURLConnection)ob.openConnection();
			if(con.getResponseCode()<=400)
			{
				System.out.println(link+"----is a valid link");
			}
			else if(con.getResponseCode()>=400)
			{
				System.out.println(link+"----is a brokenlink-----"+con.getResponseCode());
				
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
		
		public void titlevarification()
		{
			String actualtitle=driver.getTitle();
			String expectedtitle="bookwagon.com";
			if(actualtitle.equalsIgnoreCase(expectedtitle))
			{
				System.out.println("Title varification passed");
			}
			else
			{
				System.out.println("Title varification failed");
			}
		}
		
		public void screenshot() throws IOException
		{
			File sc=logo.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(sc, new File("./Logo//reiffbutton.png"));
		}
}
